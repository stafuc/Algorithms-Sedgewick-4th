import java.util.Arrays;


public class StaticSETofInts {
	
	private int[] a;
	
	public StaticSETofInts(int[] keys) {
		// TODO Auto-generated constructor stub
		a = new int[keys.length];
		for (int i = 0; i < keys.length; i++) {
			a[i] = keys[i];
		}
		Arrays.sort(a);
	}
	
	/**
	 * Contain.
	 *
	 * @param key the key
	 * @return true, if successful 
	 */
	public boolean contain(int key){
		return rank(key) != -1;
	}
	
	private int rank(int key) {
		int lo = 0, hi = a.length - 1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(a[mid] < key) lo = mid + 1;
			else if(a[mid] > key) hi = mid - 1;
			else return mid;
		}
		return -1;
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = In.readInts(args[0]);
		StaticSETofInts s = new StaticSETofInts(a);
		while(!StdIn.isEmpty()){
			int key = StdIn.readInt();
			if(!s.contain(key)) StdOut.println(key);
		}
	}

}
