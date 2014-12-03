
public class LocalMinimum {

	/**
	 * Find one local minimum in array
	 *
	 * @param a the a
	 * @return the int
	 */
	public static int find(int[] a) {
		int lo = 0, hi = a.length - 1;
		int index = 0;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(mid - 1 >= lo && a[mid] > a[mid - 1])	hi = mid - 1;
			else if(mid + 1 <= hi && a[mid] > a[mid + 1])	lo = mid + 1;
			else{
				index = mid;
				break;
			}
		}
		return index;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 1000;
		for (int N = 5; N < 50; N += N) {
			int[] a = new int[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-MAX, MAX);
				StdOut.print(a[i] + " ");
			}
			StdOut.println();
			StdOut.printf("one local mini index:%5d\n", find(a));
		}
	}

}
