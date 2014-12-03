import java.util.Arrays;




public class Ex_1_4_8 {

	public static int count(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if(a[i] == a[j])	sum++;
			}
		}
		return sum;
	}
	
	public static int quickCount(int[] a) {
		Arrays.sort(a);
		int sum = 0;
		for (int i = 0; i < a.length;) {
			int cnt = 1;
			int j;
			for (j = i + 1; j < a.length && a[i] == a[j]; ++j, ++cnt)
				;
			i = j;
			if(cnt >= 2)	sum += cnt * (cnt - 1) / 2;
		}
		return sum;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 100000;
		for (int N = 100; N < Integer.MAX_VALUE / 2; N *= 10) {
			int[] a = new int[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
			}
			StopWatch s = new StopWatch();
//			int cnt = count(a);
			int cnt = quickCount(a);
			StdOut.printf("%5d %5.2f %5d\n", N, s.elapsedTime(), cnt);
		}
	}

}
