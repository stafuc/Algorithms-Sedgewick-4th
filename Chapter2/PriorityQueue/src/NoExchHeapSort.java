
public class NoExchHeapSort {

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = N / 2; i >= 1; --i) {
			sink(a, i, N);
		}
		while(N > 0){
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable tmp = a[i - 1];
		a[i - 1] = a[j - 1];
		a[j - 1] = tmp;
	}
	
	private static void sink(Comparable[] a, int i, int N) {
		Comparable key = a[i - 1];
		while(2 * i <= N){
			int j = 2 * i;
			if(j + 1 <= N && less(a[j - 1], a[j]))	++j;
			if(!less(key, a[j - 1]))	break;
			a[i - 1] = a[j - 1];
			i = j;
		}
		a[i - 1] = key;
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if(less(a[i + 1], a[i]))	return false;
		}
		return true;
	}
	
	public static void show(Comparable[] a) {
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
//		Integer[] a = {5, 4, 3, 2, 1};
//		sort(a);
//		show(a);
		int MAX = 100000;
		for (int N = 100; N < 1e7; N += N) {
			Integer[] a = new Integer[N];
			Integer[] b = new Integer[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
				b[i] = a[i];
			}
			StopWatch sw = new StopWatch();
			HeapSort.sort(a);
			double t1 = sw.elapsedTime();
			sw.clear();
			sort(b);
			double t2 = sw.elapsedTime();
			System.out.printf("N:%d, heapsort:%f, noexch:%f\n", N, t1, t2);
//			if(!isSorted(a))	System.out.println("error!");
//			else	System.out.println(N + " finish!");
		}
	}

}
