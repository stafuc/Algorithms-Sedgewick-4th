
public class QuickX {
	private static int CUTOFF = 8;
	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		int N = hi - lo + 1;
		if(N <= CUTOFF){
			insertSort(a, lo, hi);
			return;
		}
		else if(N <= 40){
			int m = median3(a, lo, lo + N / 2, hi);
			exch(a, lo, m);
		}else{
			int eps = N / 8;
			int mid = lo + N / 2;
			int m1 = median3(a, lo, lo + eps, lo + eps + eps);
			int m2 = median3(a, mid - eps, mid, mid + eps);
			int m3 = median3(a, hi, hi - eps, hi - eps - eps);
			int m = median3(a, m1, m2, m3);
			exch(a, lo, m);
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
		sort(a, lo, j);
		sort(a, i, hi);
	}
	
	private static void insertSort(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}
	
	private static int median3(Comparable[] a, int i, int j, int k) {
		return less(a[i], a[j])?
				(less(a[j], a[k])?j:less(a[i], a[k])?k:i):
				(less(a[k], a[j])?j:less(a[i], a[k])?i:k);
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
		for (int N = 100; N < 1e6; N += N) {
			Integer[] a = new Integer[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-10000, 10000);
			}
			sort(a);
			if(!isSorted(a))	StdOut.println("error!");
			else 	StdOut.println(N + " finish!");
		}
		
	}

}
