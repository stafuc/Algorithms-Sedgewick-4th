
public class Reverse {

	private static Comparable[] aux;
	
	public static int count(Comparable[] a) {
		aux = new Comparable[a.length];
		return count(a, 0, a.length - 1);
		
	}
	
	private static int count(Comparable[] a, int lo, int hi) {
		if(lo >= hi)	return 0;
		int mid = (lo + hi) / 2;
		int c1 = count(a, lo, mid);
		int c2 = count(a, mid + 1, hi);
		int c3 = 0;
		if(less(a[mid + 1], a[mid]))
			c3 = merge(a, lo, mid, hi);
		return c1 + c2 + c3;
	}
	
	private static int merge(Comparable[] a, int lo, int mid, int hi) {
		int cnt = 0;
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if(i > mid){
				a[k] = aux[j++];
			}
			else if(j > hi){
				a[k] = aux[i++];
			}
			else if(less(aux[j], aux[i])){
				a[k] = aux[j++];
				cnt += mid - i + 1;
			}
			else{
				a[k] = aux[i++];
			}
		}
		return cnt;
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = new Integer[5];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(20);
			StdOut.printf(a[i] + " ");
		}
		StdOut.println();
		StdOut.println(count(a));

	}

}
