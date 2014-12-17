
// TODO: Auto-generated Javadoc
/**
 * The Class PrimitiveInsertion.
 * for exercise 2.1.26
 */
public class PrimitiveInsertion {

	
	/**
	 * Sort.
	 *
	 * @param a the a
	 */
	public static void sort(int[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}
	
	/**
	 * Quick sort. reduce number of exchange
	 *
	 * @param a the a
	 */
	public static void quickSort(int[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			int j = i - 1;
			while(j >= 0 && less(a[i], a[j]))
				--j;
			int temp = a[i];
			for (int k = i - 1; k > j; k--) {
				a[k + 1] = a[k];
			}
			a[j + 1] = temp;
//			show(a, i, j + 1);
		}
	}
	
	
	
	/**
	 * Less.
	 *
	 * @param v the v
	 * @param w the w
	 * @return true, if successful
	 */
	private static boolean less(int v, int w) {
		return v < w;
	}
	
	/**
	 * Exch.
	 *
	 * @param a the a
	 * @param i the i
	 * @param j the j
	 */
	private static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	
	/**
	 * Checks if is sorted.
	 *
	 * @param a the a
	 * @return true, if is sorted
	 */
	public static boolean isSorted(int[] a) {
		for (int i = 1; i < a.length; i++) {
			if(less(a[i], a[i - 1]))	return false;
		}
		return true;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 100000;
		for (int N = 100; N < 1e6; N += N) {
			int[] a = new int[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
			}
			
			Integer[] b = new Integer[N];
			for (int i = 0; i < b.length; i++) {
				b[i] = new Integer(a[i]);
			}
			StopWatch timer = new StopWatch();
			Insertion.sort(b);
			double t1 = timer.elapsedTime();
			timer.clear();
			PrimitiveInsertion.sort(a);
			double t2 = timer.elapsedTime();
			StdOut.printf("pri time:%.3f, time:%.3f\n", t2, t1);
		}

	}

}
