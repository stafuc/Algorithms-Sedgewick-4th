
public class Insertion {

	/**
	 * Sort.
	 *
	 * @param a the a
	 */
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}
	
	/**
	 * Quick sort. reduce number of exchange
	 *
	 * @param a the a
	 */
	public static void quickSort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			int j = i - 1;
			while(j >= 0 && less(a[i], a[j]))
				--j;
			Comparable temp = a[i];
			for (int k = i - 1; k > j; k--) {
				a[k + 1] = a[k];
			}
			a[j + 1] = temp;
//			show(a, i, j + 1);
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
	 * Show. a[i] move to the position j
	 *
	 * @param a the a
	 * @param i the i
	 * @param j the j
	 */
	private static void show(Comparable[] a, int i, int j) {
		StdDraw.setYscale(-a.length + i, i + 1);
		StdDraw.setPenColor(StdDraw.GRAY);
		for (int k = 0; k < j; k++) {
			StdDraw.line(k, 0, k, (Double)a[k] * 0.6);
		}
		for (int k = i + 1; k < a.length; k++) {
			StdDraw.line(k, 0, k, (Double)a[k] * 0.6);
		}
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int k = i; k >= j; k--) {
			if(k == j)	StdDraw.setPenColor(StdDraw.RED);
			StdDraw.line(k, 0, k, (Double)a[k] * 0.6);
			StdDraw.setPenColor(StdDraw.BLACK);
		}
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
		StdDraw.setPenRadius(0.006);
		Double[] a = new Double[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform();
		}
		Insertion.quickSort(a);
	}

}
