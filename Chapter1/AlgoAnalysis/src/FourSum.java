import java.util.Arrays;


public class FourSum {

	/**
	 * Count number of the sum of 4 integers is zero
	 *
	 * @param a the a
	 * @return the int
	 */
	public static int count(int[] a) {
		Arrays.sort(a);
		int cnt = 0;
		int N = a.length;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					if(BinarySearch.rank(-(a[i] + a[j] + a[k]), a) > 0)	++cnt;
				}
			}
		}
		return cnt;
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 100; N < 10000; N += N) {
			int[] a = new int[N];
			int MAX = 1000000;
			for (int i = 0; i < N; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
			}
			StopWatch s = new StopWatch();
			int cnt = count(a);
			StdOut.printf("%5d %5.2f %5d\n", N, s.elapsedTime(), cnt);
		}

	}

}
