
public class NonStaticMerge {

	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if(lo >= hi)	return;
		int mid = (lo + hi) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		if(less(a[mid + 1], a[mid]))
			merge(a, aux, lo, mid, hi);
	}
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if(i > mid)	a[k] = aux[j++];
			else if(j > hi)	a[k] = aux[i++];
			else if(less(aux[i], aux[j]))	a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	
	public static void show(Comparable[] a) {
		String str = "";
		for (Comparable c : a) {
			str += c + " ";
		}
		StdOut.println(str);
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
		for (int N = 1; N <= 512; N++) {
			Integer[] a = new Integer[N];
			for (int i = 0; i < a.length; i++) 
				a[i] = StdRandom.uniform(-MAX, MAX);
			NonStaticMerge.sort(a);
			if(!NonStaticMerge.isSorted(a))	StdOut.println(N + ":error");
		}
	}

}
