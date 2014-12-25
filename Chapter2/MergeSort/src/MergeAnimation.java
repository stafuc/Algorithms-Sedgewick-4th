
public class MergeAnimation {

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
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			MergeAnimation.clear(aux, k);
			if(i > mid)	a[k] = aux[j++];
			else if(j > hi)	a[k] = aux[i++];
			else if(less(aux[i], aux[j]))	a[k] = aux[i++];
			else a[k] = aux[j++];
			MergeAnimation.draw(a, k);
		}
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	
	/**
	 * Clear. the i-th bar
	 *
	 * @param a the a
	 * @param i the i
	 */
	private static void clear(Comparable[] a, int i) {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.line(i, 0, i, (Double)a[i]);
	}
	
	private static void draw(Comparable[] a, int i) {
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.line(i, 0, i, (Double)a[i]);
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
		int N = Integer.parseInt(args[0]);
		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, 2);
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.setPenRadius(0.006);
		Double[] a = new Double[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdRandom.uniform();
			MergeAnimation.draw(a, i);
		}
		MergeAnimation.sort(a);
	}
}
