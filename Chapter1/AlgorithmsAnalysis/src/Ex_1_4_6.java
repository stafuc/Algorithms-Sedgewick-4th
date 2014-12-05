
public class Ex_1_4_6 {

	public static int fun1(int N) {
		int sum = 0;
		for (int n = N; n > 0; n /= 2) {
			for (int i = 0; i < n; i++) {
				sum++;
			}
		}
		return sum;
		
	}
	
	public static int fun2(int N){
		int sum = 0;
		for (int i = 1; i < N; i *= 2) {
			for (int j = 0; j < i; j++) {
				sum++;
			}
		}
		return sum;
	}
	
	public static int fun3(int N) {
		int sum = 0;
		for (int i = 1; i < N; i *= 2) {
			for (int j = 0; j < N; j++) {
				sum++;
			}
		}
		return sum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < Integer.MAX_VALUE / 30; i *= 10) {
//			StdOut.println(i);
			StopWatch s = new StopWatch();
//			fun1(i);
			StdOut.printf("%5d %5d\n", i, fun3(i));
		}

	}

}
