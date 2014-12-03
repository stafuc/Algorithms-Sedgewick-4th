import java.util.Arrays;


public class TwoSumFaster {

	/**
	 * Count.
	 * assume no duplicated integers in array
	 *
	 * @param a the a
	 * @return the int
	 */
	public static int count(int[] a) {
		Arrays.sort(a);
		int i = 0, j = a.length - 1;
		int cnt = 0;
		while(i < j){
			int s = a[i] + a[j];
			if(s == 0){
				++cnt;
				++i;
				--j;
			}else if(s > 0)	--j;
			else ++i;
		}
		return cnt;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 10000000;
		for (int N = 100; N < 100000; N += N) {
			int[] a = new int[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
			}
			StdOut.printf("two sum for %5d:%5d\n", N, TwoSum.count(a));
			StdOut.printf("two sum fast for %5d:%5d\n", N, TwoSumFaster.count(a));
		}
//		int[] a = {-3, -1, 0, 1, 2, 3};
//		StdOut.println(TwoSumFaster.count(a));

	}

}
