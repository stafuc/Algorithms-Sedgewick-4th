import java.util.Arrays;


public class ThreeSumFast {
	
	/**
	 * Count.
	 * assume no duplicated integers in array
	 *
	 * @param a the a
	 * @return the int
	 */
	public static int count(int[] a) {
		Arrays.sort(a);
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			int j = i + 1, k = a.length - 1;
			while(j < k){
				int sum = a[j] + a[k];
				if(sum == -a[i]){
					++cnt;
					++j;
					--k;
				}else if(sum > -a[i])	--k;
				else ++j;
			}
		}
		return cnt;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 1000000;
		for (int N = 100; N < 1000; N += N) {
			int[] a = new int[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
			}
			StdOut.printf("three sum for %5d:%5d\n", N, ThreeSum.count(a));
			StdOut.printf("three sum fast for %5d:%5d\n", N, ThreeSumFast.count(a));
		}
	}

}
