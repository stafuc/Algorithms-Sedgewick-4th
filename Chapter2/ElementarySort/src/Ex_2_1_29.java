
public class Ex_2_1_29 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 128; N < 1e7; N += N) {
			Double[] a = new Double[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform();
			}
			double time1 = SortCompare.time("Shell", a);
			double time2 = SortCompare.time("AlterShell", a);
			StdOut.printf("N:%d Shell:%.3f AlterShell:%.3f\n", N, time1, time2);
		}
	}

}
