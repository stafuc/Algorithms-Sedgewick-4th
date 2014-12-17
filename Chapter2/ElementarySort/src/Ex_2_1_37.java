
public class Ex_2_1_37 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = Integer.parseInt(args[0]);
		int max = Integer.parseInt(args[1]);
		int t = Integer.parseInt(args[2]);
		int step = (max - min) / 10;
		StdDraw.setXscale(min, max);
		StdDraw.setYscale(0, 20);
		StdDraw.setPenRadius(0.006);
		
		for (int N = min; N <= max; N += step) {
			StdDraw.setPenColor(StdDraw.BLACK);
			double time1 = SortCompare.timePartiallyOrderedInput("QuickInsertion", N, t);
			StdDraw.point(N, time1 / t);
			
			StdDraw.setPenColor(StdDraw.GRAY);
			double time2 = SortCompare.timePartiallyOrderedInput("Selection", N, t);
			StdDraw.point(N, time2 / t);
			
			StdDraw.setPenColor(StdDraw.RED);
			double time3 = SortCompare.timePartiallyOrderedInput("Shell", N, t);
			StdDraw.point(N, time3 / t);
			
			StdOut.printf("N:%d, qi time:%.3f, sel time:%.3f, sh time:%.3f\n", N, time1, time2, time3);
		}

	}

}
