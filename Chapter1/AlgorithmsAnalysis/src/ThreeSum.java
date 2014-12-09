
public class ThreeSum {

	public static int count(int[] a){
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = j + 1; k < a.length; k++) {
					if(a[i] + a[j] + a[k] == 0)	cnt++;
				}
			}
		}
		return cnt;
	}
	
	public static int elementaryCount(int[] a) {
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				for (int k = 0; k < a.length; k++) {
					if(i < j && j < k){
						if(a[i] + a[j] + a[k] == 0)	cnt++;
					}
					
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
		int MAX = 100000;
		for (int N = 10; N < 10000; N += N) {
			int[] a = new int[N];
			int cnt;
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
			}
			StopWatch s = new StopWatch();
			cnt = count(a);
			StdOut.printf("%3d %.3f %3d\n", N, s.elapsedTime(), cnt);
			
			s.clear();
			cnt = elementaryCount(a);
			StdOut.printf("ele: %3d %.3f %3d\n", N, s.elapsedTime(), cnt);
		}
	}

}
