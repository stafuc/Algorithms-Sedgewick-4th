
public class FloyHeapSort {
	
	public static int cmp_cnt = 0;
	public static int exc_cnt = 0;
	public static void sort(Integer[] a) {
		cmp_cnt = 0;
		exc_cnt = 0;
		int N = a.length;
		for (int i = N / 2; i >= 1; i--) {
			sink(a, i, N);
		}
		while(N > 0){
			exch(a, 1, N--);
			int i = 1;
			while(2 * i <= N){
				int j = 2 * i;
				if(j + 1 <= N && less(a, j, j + 1))	++j;
				exch(a, i, j);
				i = j;
			}
			swim(a, i);
		}
	}

	private static void sink(Integer[] a, int i, int N){
		while(2 * i <= N){
			int j = 2 * i;
			if(j + 1 <= N && less(a, j, j + 1))	++j;
			if(!less(a, i, j))	break;
			exch(a, i, j);
			i = j;
		}
	}
	
	private static void swim(Integer[] a, int i) {
		while(i > 1 && less(a, i / 2, i)){
			exch(a, i, i / 2);
			i /= 2;
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
			System.out.printf("N:%d, floy:%d, floy_exc:%d, floy_time:%f, origin:%d, origin_exc:%d, origin_time:%f\n", 
					N, cmp_cnt, exc_cnt, t1, HeapSort.cmp_cnt, HeapSort.exc_cnt, t2);
//			if(!isSorted(a))	System.out.println("error!");
//			else	System.out.println(N + " finish!");
		}
//		Integer[] a = {5,4 , 3, 2, 1};
//		sort(a);
//		show(a);
		

	}

}
