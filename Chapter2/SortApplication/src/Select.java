
public class Select {
	public static int select(int[] a, int k) {
		StdRandom.shuffle(a);
		int lo = 0, hi = a.length - 1;
		while(true){
			int t = partition(a, lo, hi);
			if(t == k)	return a[t];
			else if(t < k)	lo = t + 1;
			else	hi = t - 1;
		}
	}
	
	/**
	 * Partition. number of elements must larger than 1
	 *
	 * @param a the a
	 * @param lo the lo
	 * @param hi the hi
	 * @return the int
	 */
	private static int partition(int[] a, int lo, int hi) {
		if(lo >= hi)	return lo;
		int i = lo, j = hi + 1;
		int pivot = a[lo];
		while(true){
			while (a[++i] < pivot) {if(i == hi)	break;}
			while (a[--j] > pivot) {}
			if(i >= j)	break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	
	private static void exch(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4, 3, 2, 5, 7, 8, 1};
		System.out.println(select(a, 5));
	}

}
