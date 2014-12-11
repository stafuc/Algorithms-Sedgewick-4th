
public class Ex_1_5_24 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = Integer.parseInt(args[0]);
		for (int N = 100; N < 1e7; N += N) {
			double t1 = 0, t2 = 0;
			for (int i = 0; i < T; i++) {
				StopWatch sw = new StopWatch();
				Ex_1_5_17.count(N);
				t1 += sw.elapsedTime();	
			}
			t1 = t1 / T;
			
			for (int i = 0; i < T; i++) {
				StopWatch sw = new StopWatch();
				Ex_1_5_17.count1(N);
				t2 += sw.elapsedTime();	
			}
			t2 = t2 / T;
			StdOut.printf("N:%3d, t1:%.3f, t2:%.3f, ratio:%.3f\n", N, t1, t2, t1 / t2);
		}
	}

}
