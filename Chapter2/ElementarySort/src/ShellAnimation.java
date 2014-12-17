
public class ShellAnimation {
	
	/**
	 * Sort.
	 *
	 * @param a the a
	 */
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while(h < N / 3){
			h = 3 * h + 1;
		}
		while(h >= 1){
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					show(a, j, j - h);
					exch(a, j, j - h);
				}
			}
			h /= 3;
		}
	}
	
	
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
		
	}
	
	/**
	 * Show. the process of change element a[i] from position i to position j
	 *
	 * @param a the a
	 * @param i the i
	 * @param j the j
	 */
	private static void show(Comparable[] a, int i, int j) {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.line(i, 0, i, (Double)a[i]);
		StdDraw.line(j, 0, j, (Double)a[j]);
		
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.line(j, 0, j, (Double)a[i]);
		StdDraw.line(i, 0, i, (Double)a[j]);
	}
	
	private static void show(Comparable[] a) {
		String str = "";
		for (int i = 0; i < a.length; i++) {
			str += a[i] + " ";
		}
		StdOut.println(str);
	}
	
	/**
	 * Flip. flip color of bar of position i to color GRAY
	 *
	 * @param a the a
	 * @param i the i
	 */
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if(less(a[i], a[i - 1]))	return false;
		}
		return true;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(-1, N + 1);
		StdDraw.setYscale(0, 2);
		StdDraw.setPenRadius(0.006);
		StdDraw.setPenColor(StdDraw.GRAY);
		Double[] a = new Double[N];
		for (int i = 0; i < a.length; i++) {
//			a[i] = i / 1.0 / N;
//			a[i] = (N - i) / 1.0 / N;
			a[i] = StdRandom.uniform();
			StdDraw.line(i, 0, i, a[i]);
		}
		StopWatch timer = new StopWatch();
		ShellAnimation.sort(a);
		StdOut.println(timer.elapsedTime());

	}

}
