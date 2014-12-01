
public class ModifiedDoublingTest {

	
	public static double timeTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(-MAX, MAX);
		}
		Stopwatch w = new Stopwatch();
		ThreeSum.count(a);
		return w.elapsedTime();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//picture for typical
//		int XMax = 8000;
//		int YMax = 60;
//		StdDraw.setXscale(-10, XMax);
//		StdDraw.setYscale(-5, YMax);
		
		double XMax = Math.log(8000);
		double YMax = Math.log(60);
		
		StdDraw.setXscale(-5, XMax);
		StdDraw.setYscale(-10, YMax);
		
		StdDraw.line(0, 0, XMax, 0);
		int slice = 5;
		for (int i = 1; i <= slice; i++) {
			double tempx = XMax / slice * i;
			StdDraw.text(tempx, -3, String.format("%.2f", tempx));
		}
		
		StdDraw.line(0, 0, 0, YMax);
		for (int i = 1; i <= slice; i++) {
			double tempy = YMax / slice * i;
			StdDraw.text(-5, tempy, String.format("%.2f", tempy));
			
		}
		StdDraw.setPenRadius(0.01);
		
		for (int N = 250; N < 10000; N += N) {
			double time = timeTrial(N);
			StdDraw.setPenColor(StdDraw.DARK_GRAY);
//			StdDraw.point(N, time);
			StdDraw.point(Math.log(N), Math.log(time));
			StdOut.printf("%7f %5.1f\n", Math.log(N), Math.log(time));
			
		}
		
		

	}

}
