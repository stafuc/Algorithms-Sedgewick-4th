
public class FiveSample {

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi)	return;
		if(hi - lo >= 4){
			int j = findKth(a, lo, lo + 4, 3);
			exch(a, lo, j);
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
//		i and left less or equal a[lo] , j and right larger or equal a[lo]
		int i = lo, j = hi + 1;
		while (true){
			while(less(a[++i], a[lo]))	if(i == hi)	break;
			while(less(a[lo], a[--j]))	;
			if(i >= j)	break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	private static int findKth(Comparable[] a, int lo, int hi, int k) {
		int i = lo, j = hi + 1;
		while(true){
			while(less(a[++i], a[lo]))	if(i == hi)	break;
			while(less(a[lo], a[--j]))	;
			if(i >= j)	break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		int n = j - lo + 1;
		if(k == n)	return	j;
		if(n > k)	return	findKth(a, lo, j - 1, k);
		else return	findKth(a, j + 1, hi, k - n);
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
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
			else	StdOut.println(N + " finish!");
//			int k = StdRandom.uniform(a.length);
//			int kth = a[findKth(a, 0, a.length - 1, k)];
//			Quick.sort(a);
//			if(a[k - 1] != kth)	StdOut.println("error!");
//			else	StdOut.println(N + "finish!");
		}
	}

}
