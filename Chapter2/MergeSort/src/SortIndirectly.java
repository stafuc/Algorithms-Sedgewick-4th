
public class SortIndirectly {

	public static int[] sort(Comparable[] a) {
		int[] aux = new int[a.length];
		int[] aux1 = new int[a.length];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = i;
		}
		sort(a, aux, aux1, 0, a.length - 1);
		return aux;
	}
	
	private static void sort(Comparable[] a, int[] aux, int[] aux1, int lo, int hi) {
		if(lo >= hi)	return;
		int mid = (lo + hi) / 2;
		sort(a, aux, aux1, lo, mid);
		sort(a, aux, aux1, mid + 1, hi);
		merge(a, aux, aux1, lo, mid, hi);
	}
	
	private static void merge(Comparable[] a, int[] aux, int[] aux1, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++) {
			aux1[k] = aux[k];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if(i > mid)	aux[k] = aux1[j++];
			else if(j > hi)	aux[k] = aux1[i++];
			else if(less(a[aux1[i]], a[aux1[j]]))	aux[k] = aux1[i++];
			else aux[k] = aux1[j++];
		}
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if(less(a[i + 1], a[i]))	return false;
		}
		return true;
	}
	
	public static void show(Comparable[] a) {
		String s = "";
		for (Comparable c : a) {
			s += c + " ";
		}
		StdOut.println(s);	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 10000;
		for (int N = 100; N < 1e7; N += N) {
			Integer[] a = new Integer[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
			}
			int[] index = sort(a);
			Integer[] b = new Integer[N];
			for (int i = 0; i < b.length; i++) {
				b[i] = a[index[i]];
			}
			if(!isSorted(b)){
				StdOut.println("error");
				show(a);
				show(b);
			}
		}
		
	}

}
