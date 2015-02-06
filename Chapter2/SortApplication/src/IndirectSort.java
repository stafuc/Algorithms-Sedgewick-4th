
public class IndirectSort {
	private static int[] index;
	
	public static int[] sort(int[] a) {
		index = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			index[i] = i;
		}
		sort(a, 0, a.length - 1);
		return index;
	}
	
	private static void sort(int[] a, int lo, int hi) {
		if(lo >= hi)	return;
		int mid = (lo + hi) / 2;
		int j = partition(a, index, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	
	private static int partition(int[] a, int[] index, int lo, int hi) {
		int v = a[index[lo]];
		int i = lo, j = hi + 1;
		while(true){
			while (less(a, index, ++i, lo)) {if(i == hi)	break;}
			while (less(a, index, lo, --j))	{}
			if(i >= j)	break;
			exch(index, i, j);
		}
		exch(index, lo, j);
		return j;
	}
	
	private static boolean less(int[] a, int[] index, int i, int j) {
		return a[index[i]] < a[index[j]];
	}
	
	private static void exch(int[] index, int i, int j) {
		int tmp = index[i];
		index[i] = index[j];
		index[j] = tmp;
	}
	
	private static boolean isSorted(int[] a, int[] index) {
		for (int i = 0; i < index.length - 1; i++) {
			if(less(a, index, i + 1, i))	return false;
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 100000;
		for (int N = 100; N < 1e6; N += N) {
			int[] a = new int[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
			}
			int[] index = sort(a);
			if(!isSorted(a, index))	System.out.println("error");
			else System.out.println(N + " finish!");
		}
	}

}
