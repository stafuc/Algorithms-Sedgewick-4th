
public class Ex_1_2_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		double min = Double.parseDouble(args[1]);
		double max = Double.parseDouble(args[2]);
		
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		
		Interval2D[] interv = new Interval2D[N];
		for (int i = 0; i < interv.length; i++) {
			double s = StdRandom.uniform(0, 1 - max);
			Interval1D hori = new Interval1D(s, s + StdRandom.uniform(min, max));
			s = StdRandom.uniform(0, 1 - max);
			Interval1D vert = new Interval1D(s, s + StdRandom.uniform(min, max));
			interv[i] = new Interval2D(hori, vert);
			
			interv[i].draw();
		}
		
		int interCnt = 0;
		for (int i = 0; i < interv.length; i++) {
			for (int j = i + 1; j < interv.length; j++) {
				if(interv[i].intersects(interv[j])) interCnt++;
			}
		}

	}

}
