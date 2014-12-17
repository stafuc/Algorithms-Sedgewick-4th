
public class InsertionAnimation {

	/**
	 * Sort.
	 *
	 * @param a the a
	 */
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				show(a, j, j - 1);
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
		StdDraw.setXscale(-1, N + 1);
		StdDraw.setYscale(0, 2);
		StdDraw.setPenRadius(0.006);
		Double[] a = new Double[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform();
			StdDraw.line(i, 0, i, a[i]);
		}
//		InsertionAnimation.quickSort(a);
		InsertionAnimation.sort(a);
	}

}
