
public class Ex_2_2_10 {

	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if(lo >= hi)	return;
		int mid = (lo + hi) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		if(less(a[mid + 1], a[mid]))
			merge(a, aux, lo, mid, hi);
	}
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= mid; k++) {
			aux[k] = a[k];
		}
		for (int k = mid + 1, i = 0; k <= hi; k++, i++) {
			aux[k] = a[hi - i];
		}
		int i = lo;
		int j = hi;
		for (int k = lo; k <= hi; k++) {
			if(less(aux[i], aux[j]))	a[k] = aux[i++];
			else a[k] = aux[j--];
		}
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
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
		int MAX = 1000000;
		StdDraw.setXscale(0, 50);
		StdDraw.setYscale(0, 10);
		StdDraw.setPenRadius(0.006);
		int cnt = 0;
		for (int N = 100; N < 1e8; N += N) {
			Integer[] a = new Integer[N];
			Integer[] b = new Integer[N];
			for (int i = 0; i < a.length; i++){ 
				a[i] = StdRandom.uniform(-MAX, MAX);
				b[i] = a[i];
			}
			StopWatch s = new StopWatch();
			Ex_2_2_10.sort(a);
			double time1 = s.elapsedTime();
			if(!Ex_2_2_10.isSorted(a))
				StdOut.println("error!");
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.point(cnt, time1);
			s.clear();
			NonStaticMerge.sort(b);
			double time2 = s.elapsedTime();
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.point(cnt++, time2);
			StdOut.printf("N:%d, fast:%.3f, origin:%.3f\n", N, time1, time2);
		}
	}

}
