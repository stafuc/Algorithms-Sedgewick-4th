
public class Ex_2_3_16 {
	
	public static int[] best(int N){
		int[] a = new int[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		best(a, 0, N - 1);
		return a;
	}
	
	private static void best(int[] a, int lo, int hi) {
		if(lo >= hi)	return;
		int mid = (lo + hi) / 2;
		best(a, lo, mid - 1);
		best(a, mid + 1, hi);
		exch(a, lo, mid);
	}
	
	private static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = best(20);
		for (int i : a) {
			StdOut.print(i + " ");
		}
	}

}
