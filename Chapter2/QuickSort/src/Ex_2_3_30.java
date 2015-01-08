
public class Ex_2_3_30 {

	public static void sort(Comparable[] a) {
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
			while(less(a[++i], v))	if(i == hi)	break;
			while(less(v, a[--j]))	if(j == lo)	break;
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
		String s = "";
		for (Comparable c : a) {
			s += c + " ";
		}
		StdOut.println(s);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 100; N < 5e4; N += N) {
			Integer[] a = ArrayUtil.orderedArray(N);;
			Integer[] b = new Integer[N];
			System.arraycopy(a, 0, b, 0, N);
			double t1 = 0, t2 = 0;
			StopWatch w = new StopWatch();
			sort(a);
			t1 = w.elapsedTime();
			w.clear();
			Quick.sort(b);
			t2 = w.elapsedTime();
			StdOut.println(N + " " + t1 + "," + t2);
		}

	}
}
