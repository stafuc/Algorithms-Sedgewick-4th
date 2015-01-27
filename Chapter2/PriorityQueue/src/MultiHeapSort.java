
public class MultiHeapSort {

	private int way;
	private int cmp_cnt = 0;
	private int exc_cnt = 0;
	
	public MultiHeapSort(int w) {
		// TODO Auto-generated constructor stub
		way = w;
	}
	
	public void sort(Integer[] a) {
		int N = a.length;
		for (int i = (N - 2 + way) / way; i >= 1; i--) {
			sink(a, i, N);
		}
		while (N > 0) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
	
	private void sink(Integer[] a, int i, int N){
		while(way * (i - 1) + 2 <= N){
			int j = way * (i - 1) + 2;
			int max = j;
			for (int index = j + 1, k = 1; k < way && index <= N ; index++, k++) {
				if(less(a, max, index))	max = index;
			}
			if(!less(a, i, max))	break;
			exch(a, i, max);
			i = max;
		}
	}
	
	private boolean less(Integer[] a, int i, int j) {
		++cmp_cnt;
		return a[i - 1] < a[j - 1];
	}
	
	private void exch(Integer[] a, int i, int j) {
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
		int way1 = 6, way2 = 3;
		MultiHeapSort mh = new MultiHeapSort(way1);
		MultiHeapSort mh1 = new MultiHeapSort(way2);
		for (int N = 100; N < 1e7; N += N) {
			Integer[] a = new Integer[N];
			Integer[] b = new Integer[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-Max, Max);
				b[i] = a[i];
			}
			StopWatch sw = new StopWatch();
			mh.sort(a);
			double t1 = sw.elapsedTime();
			sw.clear();
//			mh1.sort(b);
			HeapSort.sort(b);
			double t2 = sw.elapsedTime();
			System.out.printf("N:%d, %d-heap-time:%f, origin-time:%f\n", 
					N, way1, t1, t2);
//			System.out.printf("N:%d, %d-heap-time:%f, %d-heap-time:%f\n", 
//					N, way1, t1, way2, t2);
//			if(!isSorted(a))	System.out.println("error!");
//			else	System.out.println(N + " finish!");
		}
		
	}

}
