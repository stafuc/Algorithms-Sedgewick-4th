
public class NonRecursiveQuick {

	public static void sort(Comparable[] a) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		s.push(a.length - 1);
		while(!s.isEmpty()){
			int hi = s.pop(), lo = s.pop();
			if(lo >= hi)	continue;
			int j = partition(a, lo, hi);
			if(hi - j > j - lo){
				s.push(j + 1);
				s.push(hi);
				s.push(lo);
				s.push(j - 1);
			}else{
				s.push(lo);
				s.push(j - 1);
				s.push(j + 1);
				s.push(hi);
			}
		}
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		while(true){
			while(less(a[++i], a[lo]))	if(i == hi)	break;
			while(less(a[lo], a[--j]))	;
			if(i >= j)	break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return	j;
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void show(int[] a) {
		String s = "";
		for (int c : a) {
			s += c + " ";
		}
		StdOut.println(s);
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
		int MAX = 10000;
		for (int N = 100; N < 1e6; N += N) {
			Integer[] a = new Integer[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
			}
			sort(a);
			if(!isSorted(a))	StdOut.println("error!");
			else	StdOut.println(N + " finish!");
		}
	}

}
