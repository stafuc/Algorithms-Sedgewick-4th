
public class Tri_Heap {
	private static int cmp_cnt = 0;
	private static int exc_cnt = 0;
	
	public static void sort(Integer[] a) {
		cmp_cnt = 0;
		exc_cnt = 0;
		int N = a.length;
		for (int i = (N + 1) / 3; i >= 1; i--) {
			sink(a, i, N);
		}
//		while(N > 0){
//			exch(a, 1, N--);
//			sink(a, 1, N);
//		}
	}
	
	private static void sink(Integer[] a, int i, int N) {
		while(3 * i - 1 <= N){
			int j = 3 * i - 1;
			int index = j;
			if(j + 1 <= N && less(a, index, j + 1))	index = j + 1;
			if(j + 2 <= N && less(a, index, j + 2))	index = j + 2;
			if(!less(a, i, index))	break;
			exch(a, i, index);
			i = index;
		}
	}
	private static boolean less(Integer[] a, int i, int j) {
		++cmp_cnt;
		return a[i - 1] < a[j - 1];
	}
	
	private static void exch(Integer[] a, int i, int j) {
		++exc_cnt;
		int tmp = a[i - 1];
		a[i - 1] = a[j - 1];
		a[j - 1] = tmp;
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
			s += a[i] + " ";
		}
		System.out.println(s);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Max = 10000;
		for (int N = 100; N < 1e7; N += N) {
			Integer[] a = new Integer[N];
			Integer[] b = new Integer[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-Max, Max);
				b[i] = a[i];
			}
			StopWatch sw = new StopWatch();
			sort(a);
			double t1 = sw.elapsedTime();
			sw.clear();
			HeapSort.sort(b);
			double t2 = sw.elapsedTime();
			System.out.printf("N:%d, 3-heap-cmp:%d, 3-heap-exc:%d, 3-heap-time:%f, origin-cmp:%d, origin-exc:%d, origin-time:%f\n", 
					N, cmp_cnt, exc_cnt, t1, HeapSort.cmp_cnt, HeapSort.exc_cnt, t2);
//			if(!isSorted(a))	System.out.println("error!");
//			else	System.out.println(N + " finish!");
		}
	}

}
