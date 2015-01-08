
public class Ex_2_3_27 {

	public static void sort(Comparable[] a, int M) {
		sort(a, 0, a.length - 1, M);
		insertSort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi, int M) {
		if(lo >= hi)	return;
		int N = hi - lo + 1;
		if(N <= M)	return;
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
		sort(a, lo, j, M);
		sort(a, i, hi, M);
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
		StdDraw.setXscale(0, 30);
		StdDraw.setYscale(0, 4);
		StdDraw.setPenRadius(0.006);
		for (int M = 0; M <= 30; M++) {
			double t1 = 0, t2 = 0;
			for (int N = 1000; N <= 1e7; N *= 10) {
				Integer[] a = ArrayUtil.randArray(N);
				Integer[] b = new Integer[N];
				System.arraycopy(a, 0, b, 0, N);
				StopWatch w = new StopWatch();
				sort(a, M);
				t1 += w.elapsedTime();
				w.clear();
				Ex_2_3_25.sort(b, M);
				t2 += w.elapsedTime();
			}

			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.point(M, t1);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(M, t2);
			StdOut.println(M + " " + t1 + " " + t2);
		}

	}

}
