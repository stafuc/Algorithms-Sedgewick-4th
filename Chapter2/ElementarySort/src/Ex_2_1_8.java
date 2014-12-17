
public class Ex_2_1_8 {
	public static double timeTriValue(String alg, int N) {
		Integer[] a = new Integer[N];
		for (int i = 0; i < N; i++) {
			a[i] = new Integer(StdRandom.uniform(1, 4));
		}
		return SortCompare.time(alg, a);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 100; N < 1e6; N += N) {
			StdOut.printf("N:%3d, %.3f\n", N, timeTriValue("Insertion", N));
		}
	}

}
