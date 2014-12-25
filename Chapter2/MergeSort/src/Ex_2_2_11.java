
public class Ex_2_2_11 {
	
	private static final int CUTOFF = 7; 
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = a.clone();
		sort(aux, a, 0, a.length - 1);
		assert Ex_2_2_11.isSorted(a);
	}
	
	/**
	 * Sort.sort results saved to dst with help of src
	 *
	 * @param a the a
	 * @param aux the aux
	 * @param lo the lo
	 * @param hi the hi
	 */
	private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
		if(lo >= hi)	return;
		if(hi - lo + 1 <= CUTOFF){
			insertSort(dst, lo, hi);
		}else{
			int mid = (lo + hi) / 2;
			sort(dst, src, lo, mid);
			sort(dst, src, mid + 1, hi);
			if(less(src[mid + 1], src[mid]))
				merge(src, dst, lo, mid, hi);
			else	System.arraycopy(src, lo, dst, lo, hi - lo + 1);
		}
		
	}
	
	private static void insertSort(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			int j = i - 1;
			while(j >= lo && less(a[i], a[j]))
				j--;
			Comparable tmp = a[i];
			for (int k = i - 1; k >= j + 1; k--)	a[k + 1] = a[k];
			a[j + 1] = tmp;
		}
		
	}
	
	/**
	 * Merge.merge results to dst with help of src
	 *
	 * @param a the a
	 * @param aux the aux
	 * @param lo the lo
	 * @param mid the mid
	 * @param hi the hi
	 */
	private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if(i > mid)	dst[k] = src[j++];
			else if(j > hi)	dst[k] = src[i++];
			else if(less(src[i], src[j]))	dst[k] = src[i++];
			else dst[k] = src[j++];
		}
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if(less(a[i + 1], a[i]))	return false;
		}
		return true;
	}
	
	public static void show(Comparable[] a) {
		String str = "";
		for (Comparable c : a) {
			str += c + " ";
		}
		StdOut.println(str);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Integer[] a = {5, 4, 3, 2, 1};
//		Ex_2_2_11.sort(a);
//		Ex_2_2_11.show(a);
		int MAX = 1000000;
		for (int N = 100; N < 1e8; N += N) {
			Integer[] a = new Integer[N];
			Integer[] b = new Integer[N];
			for (int i = 0; i < a.length; i++){ 
				a[i] = StdRandom.uniform(-MAX, MAX);
				b[i] = a[i];
			}
			StopWatch s = new StopWatch();
			Ex_2_2_11.sort(a);
			double time1 = s.elapsedTime();
			if(!Ex_2_2_10.isSorted(a))
				StdOut.println("error!");
			s.clear();
			NonStaticMerge.sort(b);
			double time2 = s.elapsedTime();
			StdOut.printf("N:%d, optimise:%.3f, origin:%.3f, improve:%.1f%%\n", N, time1, time2, (time2 - time1) / time2 * 100);
		}

	}

}
