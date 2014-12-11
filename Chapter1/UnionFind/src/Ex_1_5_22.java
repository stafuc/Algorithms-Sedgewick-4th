import javax.rmi.CORBA.Tie;


public class Ex_1_5_22 {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = Integer.parseInt(args[0]);
		double pretime = -1;
		
		//double ration experiment for quick find
//		for (int N = 100; N < 1e5; N += N) {
//			int cnt = 0;
//			double time = 0;
//			for (int i = 0; i < T; i++) {
//				StopWatch sw = new StopWatch();
//				cnt += Ex_1_5_17.QFCount(N);
//				time += sw.elapsedTime();	
//			}
//			time = time / T;
//			StdOut.printf("N:%3d, cnt:%.3f ratio:%.3f\n", N, cnt / 1.0 / T, pretime < 0 ? 0 : (time / pretime));
//			pretime = time;
//		}
		
		
		//double ration experiment for quick union
		pretime = -1;
//		for (int N = 100; N < 1e5; N += N) {
//			int cnt = 0;
//			double time = 0;
//			for (int i = 0; i < T; i++) {
//				StopWatch sw = new StopWatch();
//				cnt += Ex_1_5_17.QUCount(N);
//				time += sw.elapsedTime();	
//			}
//			time = time / T;
//			StdOut.printf("N:%3d, cnt:%.3f ratio:%.3f\n", N, cnt / 1.0 / T, pretime < 0 ? 0 : (time / pretime));
//			pretime = time;
//		}
		
//		//double ration experiment for weighted quick union
//		pretime = -1;
//		for (int N = 100; N < 1e6; N += N) {
//			int cnt = 0;
//			double time = 0;
//			for (int i = 0; i < T; i++) {
//				StopWatch sw = new StopWatch();
//				cnt += Ex_1_5_17.count(N);
//				time += sw.elapsedTime();	
//			}
//			time = time / T;
//			StdOut.printf("N:%3d, cnt:%.3f ratio:%.3f\n", N, cnt / 1.0 / T, pretime < 0 ? 0 : (time / pretime));
//			pretime = time;
//		}
		
		//double ration experiment for path compression quick union
		pretime = -1;
		for (int N = 100; N < 1e6; N += N) {
			int cnt = 0;
			double time = 0;
			for (int i = 0; i < T; i++) {
				StopWatch sw = new StopWatch();
				cnt += Ex_1_5_17.count1(N);
				time += sw.elapsedTime();	
			}
			time = time / T;
			StdOut.printf("N:%3d, cnt:%.3f ratio:%.3f\n", N, cnt / 1.0 / T, pretime < 0 ? 0 : (time / pretime));
			pretime = time;
		}
	}

}
