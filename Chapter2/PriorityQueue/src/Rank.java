
public class Rank {
	public static int rank(int[] a, int v) {
		int lo = 0, hi = a.length - 1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(a[mid] == v)	return mid;
			if(a[mid] < v)	lo = mid + 1;
			else	hi = mid - 1;
		}
		return lo;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5, 7};
		System.out.println(rank(a, 0));
	}

}
