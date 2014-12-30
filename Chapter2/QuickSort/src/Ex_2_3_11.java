
public class Ex_2_3_11 {
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi)	return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		while(true){
			while(!less(v, a[++i]))	if(i == hi)	break;
			while(!less(a[--j], v))	if(j == lo)	break;
			if(i >= j)	break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void show(Comparable[] a) {
		String str = "";
		for (Comparable c : a) {
			str += c + " ";
		}
		StdOut.println(str);
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if(less(a[i + 1], a[i]))	return false;
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] v = {1, 2, 3, 4, 5};
		for (int N = 100; N < 1e5; N += N) {
			Integer[] a = new Integer[N], b = new Integer[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = v[i % 5];
				b[i] = a[i];
			}
			StopWatch sw = new StopWatch();
			sort(a);
			double time = sw.elapsedTime();
			if(!isSorted(a)){
				StdOut.println("error!");
				break;
			}
			sw.clear();
			Quick.sort(b);
			double time2 = sw.elapsedTime();
			if(!isSorted(b)){
				StdOut.println("error!");
				break;	
			}
			StdOut.printf("N:%d, time1:%f, time2:%f\n", N, time, time2);
		}
	}

}
