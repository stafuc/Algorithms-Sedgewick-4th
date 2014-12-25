
public class Merge {

	private static Comparable[] aux;
	private static int visitCnt;
	
	public static void sort(Comparable[] a) {
		visitCnt = 0;
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
//		StdOut.println(lo + " " + hi);
		if(lo >= hi)	return;
		int mid = (lo + hi) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		visitCnt += 2;
		merge(a, lo, mid, hi);
	}
	
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
			visitCnt += 2;
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if(i > mid){
				a[k] = aux[j++];
				visitCnt += 2;
			}
			else if(j > hi){
				a[k] = aux[i++];
				visitCnt += 2;
			}
			else if(less(aux[i], aux[j])){
				a[k] = aux[i++];
				visitCnt += 4;
			}
			else{
				a[k] = aux[j++];
				visitCnt += 4;
			}
		}
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	
	public static void show(Comparable[] a) {
		String s = "";
		for (Comparable c : a) {
			s += c + " ";
		}
		StdOut.println(s);
		
	}
	
	public static int count() {
		return visitCnt;
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if(!less(a[i], a[i + 1]))	return false;
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {5, 4, 3, 2, 1};
		Merge.sort(a);
		Merge.show(a);
		StdOut.println(Merge.count());
	}

}
