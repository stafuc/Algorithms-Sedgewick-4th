
public class ThreeSample {

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi)	return;
		if(hi - lo >= 2){
			int mid = lo;
			if(less(a[lo], a[lo + 1]) && less(a[lo], a[lo + 2])){
				if(less(a[lo + 1], a[lo + 2]))	mid = lo + 1;
				else	mid = lo + 2;
			}
			else if(less(a[lo + 1], a[lo]) && less(a[lo + 2], a[lo])){
				if(less(a[lo + 1], a[lo + 2]))	mid = lo + 2;
				else	mid = lo + 1;
			}
			exch(a, lo, mid);
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
//		for (int N = 100; N < 1e6; N += N) {
//			int[] a = Ex_2_3_16.genRandArray(N);
//			sort(a);
//			if(!isSorted(a))	StdOut.println("error");
//			else	StdOut.println(N + "finish!");
//		}
	}

}
