
public class Ex_2_2_23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 10000000;
		StdDraw.setXscale(0, 30);
		StdDraw.setYscale(0, 10);
		StdDraw.setPenRadius(0.006);
		int index = 0;
		for (int N = 100; N < 5e7; N += N) {
			Integer[] a = new Integer[N];
			Integer[] b = new Integer[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
				b[i] = a[i];
			}
			StopWatch sw = new StopWatch();
//			StdDraw.setPenColor(StdDraw.BLACK);
			Merge.sort(a);
			double t1 = sw.elapsedTime();
			StdOut.printf("N:%d, ori:%f\n", N, t1);
//			StdDraw.point(index, t1);
//			sw.clear();
//			StdDraw.setPenColor(StdDraw.GRAY);
//			Ex_2_2_11.sort(b);
//			double t2 = sw.elapsedTime();
//			StdOut.printf("N:%d, opt:%f\n", N, t2);
//			StdDraw.point(index++, t2);
		}
		StdOut.println("over!");

	}

}
