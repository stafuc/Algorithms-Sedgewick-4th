
public class Shell {

	private static int[] initShell(int N) {
		int step = 1, cnt = 0;
		while(step < N){
			step = 3 * step + 1;
			++cnt;
		}
		int[] h = new int[cnt];
		if(cnt > 0){
			h[0] = 1;
			for (int i = 1; i < cnt; i++) {
				h[i] = 3 * h[i - 1] + 1;
			}	
		}
		return h;
	}
	
	public static void sort(Comparable[] a){
		int N = a.length;
		int[] h = initShell(N);
		for (int i = h.length - 1; i >= 0; i--) {
			for (int j = h[i]; j < N; j++) {
				for (int k = j; k >= h[i] && less(a[k], a[k - h[i]]); k -= h[i]) {
					exch(a, k, k - h[i]);
				}
			}
		}
	}
	
	public static void sort(Comparable[] a, int[] h) {
		int N = a.length;
		for (int i = h.length - 1; i >= 0; i--) {
			for (int j = h[i]; j < N; j++) {
				for (int k = j; k >= h[i] && less(a[k], a[k - h[i]]); k -= h[i]) {
					exch(a, k, k - h[i]);
				}
			}
		}
//		StdOut.printf("%.3f\n", cmpCnt / 1.0 / a.length);
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if(less(a[i], a[i - 1]))	return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 100; N < 1e7;  N *= 10) {
			StdOut.printf("N:%3d\n", N);
			Double[] a = new Double[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform();
			}
			sort(a);
		}
	}

}
