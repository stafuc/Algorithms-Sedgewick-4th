
public class Ex_2_3_28 {
	
	/**
	 * Sort.
	 *
	 * @param a the a
	 * @param M the m
	 * @return the recursive depth of sort
	 */
	public static int sort(Comparable[] a, int M) {
		return sort(a, 0, a.length - 1, M);
	}
	
	private static int sort(Comparable[] a, int lo, int hi, int M) {
		if(lo >= hi)	return 1;
		int N = hi - lo + 1;
		if(N <= M){
			insertSort(a, lo, hi);
			return 1;
		}
		int p = lo, i = lo, q = hi + 1, j = hi + 1;
		Comparable v = a[lo];
		while(true){
			while(less(a[++i], v))	if(i == hi)	break;
			while(less(v, a[--j]))	;
			if(i == j && equal(a[i], v))	exch(a, ++p, i);
			if(i >= j)	break;
			exch(a, i, j);
			if(equal(a[i], v))	exch(a, ++p, i);
			if(equal(a[j], v))	exch(a, --q, j);
		}
		i = j + 1;
		for (int k = lo; k <= p; k++)	exch(a, k, j--);
		for (int k = hi; k >= q; k--)	exch(a, k, i++);
		int h1 = sort(a, lo, j, M);
		int h2 = sort(a, i, hi, M);
		return Math.max(h1, h2) + 1;
	}
	
	private static void insertSort(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	
	private static boolean equal(Comparable u, Comparable v) {
		return u.compareTo(v) == 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void show(Comparable[] a) {
		String s = "";
		for (Comparable c : a) {
			s += c + " ";
		}
		StdOut.println(s);
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if(less(a[i + 1], a[i]))	return false;
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] M = {10, 20, 50};
		for (int i = 0; i < M.length; i++) {
			double h = 0;
			for (int N = 1000; N <= 1e6; N *= 10) {
				Integer[] a = ArrayUtil.randArray(N);
				h += sort(a, M[i]);
//				StdOut.println(N + "," + h);
			}
			StdOut.println(M[i] + "," + h / 4);
		}

	}

}
