
public class Ex_1_2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		Interval1D[] interv = new Interval1D[N];
		for (int i = 0; i < interv.length; i++) {
			double s = StdIn.readDouble();
			double e = StdIn.readDouble();
			interv[i] = new Interval1D(s, e);
		}
		
		for (int i = 0; i < interv.length; i++) {
			for (int j = i + 1; j < interv.length; j++) {
				if(interv[i].intersects(interv[j])){
					StdOut.printf("(%f, %f) intersects with (%f, %f)\n", interv[i].left(), interv[i].right(), interv[j].left(), interv[j].right());
				}
			}
		}

	}

}
