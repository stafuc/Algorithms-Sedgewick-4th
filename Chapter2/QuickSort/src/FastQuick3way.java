
public class FastQuick3way {

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi)	return;
//		i, j have been handled
//		[lo, p] equal v, (p, i] less than v, [j, q) larger than v, [q, hi] equal v
		int p = lo, q = hi + 1, i = lo, j = hi + 1;
		Comparable v = a[lo];
		while(true){
			while(less(a[++i], v))	if(i == hi)	break;
			while(less(v, a[--j]))	;
//			i, j have been checked not handled
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
		int MAX = 10000;
		for (int N = 100; N < 1e6; N += N) {
			Integer[] a = new Integer[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
			}
			sort(a);
			if(!isSorted(a))	StdOut.println("error!");
			else	StdOut.println(N + " finish!");
		}
	}

}
