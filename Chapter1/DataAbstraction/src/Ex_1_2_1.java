
public class Ex_1_2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		Point2D[] p = new Point2D[N];
		for (int i = 0; i < p.length; i++) {
			double x = StdRandom.uniform();
			double y = StdRandom.uniform();
			p[i] = new Point2D(x, y);
		}
		
		for (int i = 0; i < p.length; i++) {
			for (int j = i + 1; j < p.length; j++) {
				StdOut.printf("(%f, %f)-(%f, %f): %f\n", p[i].x(), p[i].y(), p[j].x(), p[j].y(), p[i].distanceTo(p[j]));
			}
		}

	}

}
