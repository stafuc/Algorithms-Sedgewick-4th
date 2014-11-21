import java.util.Arrays;


public class Ex_1_1_38 {
	
	public static int BruteForceSearch(int key, int[] a){
		for (int i = 0; i < a.length; i++) {
			if(a[i] == key) return i;
		}
		return -1;
	}
	
	public static int BinarySearch(int key, int[] a){
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
		int[] whitelist = In.readInts(args[0]);
//		Arrays.sort(whitelist);
		long startTime = System.currentTimeMillis();
		while(!StdIn.isEmpty()){
			int key = StdIn.readInt();
//			if(BinarySearch(key, whitelist) < 0) StdOut.println(key);
			if(BruteForceSearch(key, whitelist) < 0) StdOut.println(key);
		}
		long endTime = System.currentTimeMillis();
		StdOut.println(endTime - startTime + "ms");
	}

}
