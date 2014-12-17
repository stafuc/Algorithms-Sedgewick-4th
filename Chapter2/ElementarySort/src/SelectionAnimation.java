
public class SelectionAnimation {
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if(less(a[j], a[min]))	min = j;
			}
			show(a, i, min);
			exch(a, i, min);
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
	 * Show. the process of exchanging between position i and position j
	 *
	 * @param a the a
	 * @param i the position i
	 * @param j the position j
	 */
	private static void show(Comparable[] a, int i, int j) {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.line(i, 0, i, (Double)a[i]);
		StdDraw.line(j, 0, j, (Double)a[j]);
		
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.line(i, 0, i, (Double)a[j]);
		StdDraw.line(j, 0, j, (Double)a[i]);
	}
	
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
		StdDraw.setXscale(-1, N + 1);
		StdDraw.setYscale(0, 2);
		StdDraw.setPenRadius(0.006);
		StdDraw.setPenColor(StdDraw.GRAY);
		Double[] a = new Double[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform();
			StdDraw.line(i, 0, i, a[i]);
		}
		SelectionAnimation.sort(a);
	}

}
