import java.util.Arrays;


public class KendallTau {

	private static int[] temp;
	public static int count(int[] a, int[] b) {
		int[] index = new int[a.length];
		for (int i = 0; i < index.length; i++) {
			index[a[i]] = i;
		}
		temp = new int[b.length];
		return sort(b, 0, b.length - 1, index);
	}
	
	private static int sort(int[] a, int lo, int hi, int[] index) {
		if(lo >= hi)	return 0;
		int mid = (lo + hi) / 2, cnt = 0;
		cnt += sort(a, lo, mid, index);
		cnt += sort(a, mid + 1, hi, index);
		cnt += merge(a, lo, mid, hi, index);
		return cnt;
	}
	
	private static int merge(int[] a, int lo, int mid, int hi, int[] index) {
		int cnt = 0;
		for (int i = lo; i <= hi; i++) {
			temp[i] = a[i];
		}
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if(i > mid)	a[k] = temp[j++];
			else if(j > hi)	a[k] = temp[i++];
			else{
				if(index[temp[i]] < index[temp[j]])	a[k] = temp[i++];
				else{
					a[k] = temp[j++];
					cnt += mid - i + 1;
					for (int k2 = i; k2 <= mid; k2++) {
						System.out.println(temp[k2] + " " + a[k]);
					}
				}
			}
		}
		return cnt;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0, 3, 1, 6, 2, 5, 4};
		int[] b = {1, 0, 3, 6, 4, 2, 5};
		System.out.println(count(a, b));
	}

}
