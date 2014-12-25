import java.util.Arrays;


public class Ex2_2_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 10000;
		StdDraw.setXscale(0, 550);
		StdDraw.setYscale(0, 30000);
//		StdDraw.setCanvasSize(800, 400);
		StdDraw.setPenRadius(0.006);
		for (int N = 1; N <= 512; N++) {
			Integer[] a = new Integer[N];
			Integer[] b = new Integer[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
				b[i] = a[i];
			}
			Merge.sort(a);
			MergeBU.sort(b);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(N, 6 * N * Math.log(N) / Math.log(2));
			
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.point(N, Merge.count());
			
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.point(N, MergeBU.Count());
//			StdOut.println(MergeBU.Count());
			
			StdOut.println(N + "finished.");
		}

	}

}
