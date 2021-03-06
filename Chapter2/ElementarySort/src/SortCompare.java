
public class SortCompare {

	public static double time(String alg, Comparable[] a) {
		StopWatch timer = new StopWatch();
		if(alg.equals("Insertion"))	Insertion.sort(a);
		if(alg.equals("QuickInsertion"))	Insertion.quickSort(a);
		if(alg.equals("Selection"))	Selection.sort(a);
		if(alg.equals("Shell"))	Shell.sort(a);
		if(alg.equals("AlterShell")){
			int[] h = {1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905, 8929, 16001, 36289, 64769, 146305, 260609};
			Shell.sort(a, h);
		}
		if(alg.equals("GuardInsertion"))	GuardInsertion.quickSort(a);
		return timer.elapsedTime();
	}
	
	/**
	 * Time randam input.
	 *
	 * @param alg the alg
	 * @param N the n
	 * @param T the t
	 * @return the double
	 */
	public static double timeRandamInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < N; j++) {
				a[j] = new Double(StdRandom.uniform());
			}
			total += time(alg, a);
		}
		return total;
	}
	
	/**
	 * Time uneven input. half zero half one
	 *
	 * @param alg the alg
	 * @param N the n
	 * @param T the t
	 * @return the double
	 */
	public static double timeZeroOneInput(String alg, int N, int T) {
		double total = 0.0;
		Integer[] a = new Integer[N];
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < N; j++) {
				if(StdRandom.uniform() < 0.5)
					a[j] = new Integer(0);
				else	a[j] = new Integer(1);
			}
			total += time(alg, a);
		}
		return total;
	}
	
	/**
	 * Time uneven input. half zero quarter one quarter two
	 *
	 * @param alg the alg
	 * @param N the n
	 * @param T the t
	 * @return the double
	 */
	public static double timeZeroOneTwoInput(String alg, int N, int T) {
		double total = 0.0;
		Integer[] a = new Integer[N];
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < N; j++) {
				double p = StdRandom.uniform();
				if(p < 0.5)	a[j] = new Integer(0);
				else if(p < 0.75)	a[j] = new Integer(1);
				else a[j] = new Integer(2);
			}
			total += time(alg, a);
		}
		return total;
	}
	
	/**
	 * Time uneven input. half zero
	 *
	 * @param alg the alg
	 * @param N the n
	 * @param T the t
	 * @return the double
	 */
	public static double timeHalfZeroInput(String alg, int N, int T) {
		double total = 0.0;
		Integer[] a = new Integer[N];
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < N; j++) {
				double p = StdRandom.uniform();
				if(p < 0.5)	a[j] = new Integer(0);
				else a[j] = new Integer(StdRandom.uniform(-N, N));
			}
			total += time(alg, a);
		}
		return total;
	}
	
	/**
	 * Time partially ordered input.
	 *
	 * @param alg the alg
	 * @param N the n
	 * @param T the t
	 * @return the double
	 */
	public static double timePartiallyOrderedInput(String alg, int N, int T) {
		double total = 0.0;
		Integer[] a = new Integer[N];
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < N; j++) {
				double p = StdRandom.uniform();
				if(p < 0.95)	a[j] = new Integer(j);
				else a[j] = new Integer(StdRandom.uniform(-N, N));
			}
			total += time(alg, a);
		}
		return total;
	}
	
	
	public static double timeReverseOrderInput(String alg, int N, int T) {
		double total = 0.0;
		for (int i = 0; i < T; i++) {
			Integer[] a = new Integer[N];
			for (int j = 0; j < N; j++) {
				a[j] = new Integer(N - j);
			}
			total += time(alg, a);
		}
		return total;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 128; N < 1e7; N += N) {
			double time1 = timeRandamInput("Quick", N, 5);
			double time2 = timeRandamInput("Guard", N, 5);
			StdOut.printf("N:%3d, quick:%.3f, guard:%.3f\n", N, time1, time2);
		}
	}

}
