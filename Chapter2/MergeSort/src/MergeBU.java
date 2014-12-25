
public class MergeBU {

	private static Comparable[] aux;
	private static int visitCnt;
	
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
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		visitCnt = 0;
		for (int sz = 1; sz < N; sz += sz) {
			for (int i = 0; i < N - sz; i += sz + sz) {
				visitCnt += 2;
				if(less(a[i + sz], a[i + sz - 1]))
					merge(a, i, i + sz - 1, Math.min(N - 1, i + sz + sz - 1));
			}
		}
	}
	
	public static void show(Comparable[] a) {
		String s = "";
		for (Comparable c : a) {
			s += c + " ";
		}
		StdOut.println(s);
		
	}
	
	public static int Count() {
		return visitCnt;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {5, 4, 3, 2, 1};
		MergeBU.sort(a);
		MergeBU.show(a);
		StdOut.println(MergeBU.Count());
	}

}
