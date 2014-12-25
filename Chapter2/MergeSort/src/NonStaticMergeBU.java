
public class NonStaticMergeBU {	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++)
			aux[i] = a[i];
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if(i > mid)	a[k] = aux[j++];
			else if(j > hi)	a[k] = aux[i++];
			else if(less(aux[i], aux[j]))	a[k] = aux[i++];
			else	a[k] = aux[j++];
		}
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		Comparable[] aux = new Comparable[N];
		for (int sz = 1; sz < N; sz += sz) {
			for (int i = 0; i < N - sz; i += sz + sz) {
				if(less(a[i + sz], a[i + sz - 1]))
					merge(a, aux, i, i + sz - 1, Math.min(N - 1, i + sz + sz - 1));
			}
		}
	}
	
	public static void show(Comparable[] a) {
		String s = "";
		for (Comparable c : a) 
			s += c + " ";
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
		for (int N = 1; N <= 512; N++) {
			Integer[] a = new Integer[N];
			for (int i = 0; i < a.length; i++) 
				a[i] = StdRandom.uniform(-MAX, MAX);
			NonStaticMerge.sort(a);
			if(!NonStaticMerge.isSorted(a))	StdOut.println(N + ":error");
		}
	}

}
