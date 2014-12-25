
public class K_merge {
	
	public static void sort(Comparable[] a, int k) {
		Comparable[] aux = new Comparable[a.length];
		if(k <= 1){
			StdOut.println("k error!");
			return;
		}
		sort(a, aux, k, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int k, int lo, int hi) {
		if(lo >= hi)	return;
		k = Math.min(k, hi - lo + 1);
		int[] point = new int[k + 1];
		point[0] = lo;
		int length = (hi - lo + 1) / k;
		for (int i = 1; i < k; i++) {
			point[i] = point[i - 1] + length;
		}
		point[k] = hi + 1;
		for (int i = 0; i < k; i++) {
			sort(a, aux, k, point[i], point[i + 1] - 1);
		}
		merge(a, aux, point, lo, hi);
	}
	
	private static void merge(Comparable[] a, Comparable[] aux, int[] point, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		int[] index = new int[point.length - 1];
		for (int i = 0; i < index.length; i++) {
			index[i] = point[i];
		}
		for (int i = lo; i <= hi; i++) {
			int temp = -1;
			for (int j = 0; j < index.length; j++) {
				if(index[j] < point[j + 1] && (temp == -1 || less(aux[index[j]], aux[index[temp]]))){
					temp = j;
				}
			}
			a[i] = aux[index[temp]++];
		}
	}

	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	
	public static void show(Comparable[] a) {
		String s = "";
		for (Comparable c : a) {
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
		int MAX = 100000;
		for (int k = 2; k <= 30; k++) {
			StopWatch sw = new StopWatch();
			for (int t = 0; t < 5; t++) {
				Integer[] a = new Integer[1000000];
				for (int i = 0; i < a.length; i++) {
					a[i] = StdRandom.uniform(-MAX, MAX);
				}
				sort(a, k);	
			}
			StdOut.printf("k:%d, time:%.3f\n", k, sw.elapsedTime() / 5);
		}
	}

}
