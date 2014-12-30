
public class Ex_2_3_6 {
	
	private static class Count{
		int k = 0;
	}

	public static int sort(Comparable[] a) {
		StdRandom.shuffle(a);
		Count c = new Count();
		sort(a, 0, a.length - 1, c);
		return c.k;
	}
	
	private static void sort(Comparable[] a, int lo, int hi, Count c) {
		if(lo >= hi)	return;
		int j = partition(a, lo, hi, c);
		sort(a, lo, j - 1, c);
		sort(a, j + 1, hi, c);
	}
	
	private static int partition(Comparable[] a, int lo, int hi, Count c) {
		int i = lo, j = hi + 1;
		Comparable v = a[lo];
		while(true){
			c.k += 1;
			while(less(a[++i], v)){	
				if(i == hi)	break;
				c.k += 1;
			}
			c.k += 1;
			while(less(v, a[--j])){
				if(j == lo)	break;
				c.k += 1;
			}
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
		int[] N = {100, 1000, 10000};
		int MAX = 100000;
		for (int i = 0; i < N.length; i++) {
			Integer[] a = new Integer[N[i]];
			for (int j = 0; j < a.length; j++) {
				a[j] = StdRandom.uniform(-MAX, MAX);
//				a[j] = 1;	//ex 2.3.8
			}
			int cnt = sort(a);
			if(!isSorted(a)){
				StdOut.println("error");
				break;
			}
			StdOut.printf("precision:%d, appro:%f\n", cnt, 2 * N[i] * Math.log(N[i]) / Math.log(2));
		}
	}

}
