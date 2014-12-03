import java.util.Arrays;


public class StaticSETofInts {

	private int[] keys;
	
	public StaticSETofInts(int[] a) {
		// TODO Auto-generated constructor stub
		keys = new int[a.length];
		for (int i = 0; i < a.length; ++i) {
			keys[i] = a[i];
		}
		Arrays.sort(keys);
		
		StdOut.println("keys:");
		for (int i : keys) {
			StdOut.print(i + " ");
		}
		StdOut.println();
	}
	
	/**
	 * return Min index of key in array.
	 *
	 * @param key the key
	 * @return the int
	 */
	private int minRank(int key) {
//		StdOut.println(key);
		int low = 0;
		int high = keys.length - 1;
		while(low <= high){
//			StdOut.println(low + " " + high);
			if(keys[low] == key)	return low;
//			StdOut.println("yes");
			int mid = (low + high) / 2;
			if(keys[mid] > key)	high = mid - 1;
			else if(keys[mid] < key)	low = mid + 1;
			else{
				high = mid;
				low++;
			}
		}
		return -1;
	}
	
	/**
	 * return Max index of key in array.
	 *
	 * @param key the key
	 * @return the int
	 */
	private int maxRank(int key) {
		int low = 0;
		int high = keys.length - 1;
		while(low <= high){
			if(keys[high] == key)	return high;
			int mid = (low + high) / 2;
			if(keys[mid] > key)	high = mid - 1;
			else if(keys[mid] < key)	low = mid + 1;
			else{
				low = mid;
				high--;
			}
		}
		return -1;
	}
	
	/**
	 * return the count of key in array.
	 *
	 * @param key the key
	 * @return the int
	 */
	public int howmany(int key) {
		int lo = minRank(key);
//		StdOut.println("-----------");
		int hi = maxRank(key);
//		StdOut.println(lo + " " + hi);
		if(lo < 0 || hi < 0)	return 0;
		return hi - lo + 1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = In.readInts(args[0]);
		StaticSETofInts s = new StaticSETofInts(a);
		while(!StdIn.isEmpty()){
			StdOut.println(s.howmany(StdIn.readInt()));
		}
	}

}
