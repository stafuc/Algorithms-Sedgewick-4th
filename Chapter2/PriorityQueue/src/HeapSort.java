
public class HeapSort {
	public static int cmp_cnt = 0;
	public static int exc_cnt = 0;

	public static void sort(Integer[] a) {
		int N = a.length;
		cmp_cnt = 0;
		exc_cnt = 0;
		for (int i = N / 2; i >= 1; --i) {
			sink(a, i, N);
		}
		while(N > 0){
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
	
	private static void sink(Integer[] a, int i, int N) {
		while(2 * i <= N){
			int j = 2 * i;
			if(j + 1 <= N && less(a, j, j + 1))	++j;
			if(!less(a, i, j))	break;
			exch(a, i, j);
			i = j;
		}
	}
	
	private static boolean less(Integer[] a, int i, int j) {
		++cmp_cnt;
		return a[i - 1] < a[j - 1];
	}
	
	private static void exch(Integer[] a, int i, int j) {
		++exc_cnt;
		Integer t = a[i - 1];
		a[i - 1] = a[j - 1];
		a[j - 1] = t;
	}
	
	public static boolean isSorted(Integer[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if(a[i + 1] < a[i])	return false;
		}
		return true;
	}
	
	public static void show(Integer[] a) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s += a[i] + ",";
		}
		System.out.println(s);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 10000;
		for (int N = 100; N < 1e6; N += N) {
			Integer[] a = new Integer[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
			}
			sort(a);
			if(!isSorted(a))	System.out.println("error!");
			else	System.out.println(N + " finish!");
		}
	}

}
