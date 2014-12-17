
public class Selection {
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if(less(a[j], a[min]))	min = j;
			}
//			show(a, i, min);
			exch(a, i, min);
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private static void show(Comparable[] a, int i, int min) {
		StdDraw.setYscale(-a.length + i, i + 1);
		StdDraw.setPenColor(StdDraw.GRAY);
		for (int j = 0; j < i; j++) {
			StdDraw.line(j, 0, j, (Double)a[j] * 0.6);
		}
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int j = i; j < a.length; j++) {
			if(j == min)	StdDraw.setPenColor(StdDraw.RED);
			StdDraw.line(j, 0, j, (Double)a[j] * 0.6);
			StdDraw.setPenColor(StdDraw.BLACK);
		}
//		StdOut.println();
		
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if(less(a[i], a[i - 1]))	return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		StdDraw.setXscale(-1, N + 1);
		StdDraw.setPenRadius(0.006);
		Double[] a = new Double[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform();
		}
		Selection.sort(a);
	}

}
