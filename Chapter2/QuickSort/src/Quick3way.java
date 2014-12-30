
public class Quick3way {

	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
//		show(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if(lo >= hi)	return;
		int lt = lo, i = lo + 1, gt = hi;
		Comparable v = a[lo];
		while(i <= gt){
			int cmp = a[i].compareTo(v);
			if(cmp < 0)	exch(a, lt++, i++);
			else if(cmp == 0)	i++;
			else	exch(a, i, gt--);
		}
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
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
		Integer[] a = {5, 4, 3, 2, 1, 2, 2, 2, 3, 3, 3, 3};
		sort(a);
		show(a);

	}

}
