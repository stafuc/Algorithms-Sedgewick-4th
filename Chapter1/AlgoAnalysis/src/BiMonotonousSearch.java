
public class BiMonotonousSearch {

	/**
	 * Rank.
	 *
	 * @param a assume a is bi-monotonous
	 * @param key the key
	 * @return the int
	 */
	public static int rank(int[] a, int key) {
		int lo = 0, hi = a.length - 1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(a[mid] == key)	return mid;
			if(mid + 1 <= hi && a[mid] <= a[mid + 1]){
				if(a[mid] > key){
					int index = binarySearch(a, key, lo, mid - 1);
					if(index != -1)	return index;
				}
				lo = mid + 1;
			}else{
				if(a[mid] > key){
					int index = binarySearch(a, key, mid + 1, hi);
					if(index != -1)	return index;
				}
				hi = mid - 1;
			}
		}
		return -1;
	}
	
	private static int binarySearch(int[] a, int key, int lo, int hi) {
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(a[mid] == key)	return mid;
			if(a[mid] > key)	hi = mid - 1;
			else	lo = mid + 1;
		}
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 10;
		for (int N = 5; N < 50; N += N) {
			int[] a = new int[N];
			int M = StdRandom.uniform(N);
			for (int i = 0; i <= M; ++i) {
				a[i] = (i == 0 ? StdRandom.uniform(MAX) : a[i - 1] 
						+ StdRandom.uniform(MAX));
				StdOut.printf("%d ", a[i]);
			}
			for (int i = M + 1; i < N; ++i) {
				a[i] = a[i - 1] - StdRandom.uniform(MAX);
				StdOut.printf("%d ", a[i]);
			}
			StdOut.println();
			for (int i = 0; i < 10; ++i) {
				int temp = StdRandom.uniform(-MAX, MAX);
				StdOut.printf("find %3d: %3d\n", temp, rank(a, temp));
			}
			StdOut.println("---------------------");
		}
		
	}

}
