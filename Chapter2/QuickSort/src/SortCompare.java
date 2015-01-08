
public class SortCompare {

	public static double time(String alg, Comparable[] a) {
		StopWatch timer = new StopWatch();
		if(alg.equals("Quick"))	Quick.sort(a);
		if(alg.equals("Guard"))	Guard.sort(a);
		if(alg.equals("3Sample"))	ThreeSample.sort(a);
		if(alg.equals("5Sample"))	FiveSample.sort(a);
		if(alg.equals("NonRecursive"))	NonRecursiveQuick.sort(a);
		if(alg.equals("Quick3way"))	Quick3way.sort(a);
		if(alg.equals("FastQuick3way"))	FastQuick3way.sort(a);
		if(alg.equals("QuickX"))	QuickX.sort(a);
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
		return total / T;
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
		return total / T;
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
	
	public static double timeDuplicateInput(String alg, int N, int T) {
		double total = 0.0;
		for (int i = 0; i < T; i++) {
			Integer[] a = new Integer[N];
			for (int j = 0; j < N; j++) {
				a[j] = 1;
			}
			total += time(alg, a);
		}
		return total / T;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 128; N < 1e7; N += N) {
//			double time1 = timeRandamInput("Quick", N, 5);
//			double time2 = timeRandamInput("Guard", N, 5);
//			double time3 = timeRandamInput("3Sample", N, 5);
//			double time4 = timeRandamInput("5Sample", N, 5);
//			double time5 = timeRandamInput("NonRecursive", N, 5);
//			double time6 = timeRandamInput("Quick3way", N, 5);
//			double time7 = timeRandamInput("FastQuick3way", N, 5);
//			double time8 = timeRandamInput("QuickX", N, 5);
			double time1 = timeDuplicateInput("Quick", N, 5);
			double time2 = timeDuplicateInput("Guard", N, 5);
			double time3 = timeDuplicateInput("3Sample", N, 5);
			double time4 = timeDuplicateInput("5Sample", N, 5);
			double time5 = timeDuplicateInput("NonRecursive", N, 5);
			double time6 = timeDuplicateInput("Quick3way", N, 5);
			double time7 = timeDuplicateInput("FastQuick3way", N, 5);
			double time8 = timeDuplicateInput("QuickX", N, 5);
//			StdOut.printf("N:%3d, quick:%.3f, guard:%.3f, 3Sample:%.3f, 5Sample:%f, NonRecursive:%f, Quick3way:%f, FastQuick3way:%f\n", N, time1, time2, time3, time4, time5, time6, time7);
			StdOut.printf("N:%3d, quick:%.3f, 3Sample:%.3f, Quick3way:%f, FastQuick3way:%f, QuickX:%f\n", N, time1, time3, time6, time7, time8);
		}
	}

}
