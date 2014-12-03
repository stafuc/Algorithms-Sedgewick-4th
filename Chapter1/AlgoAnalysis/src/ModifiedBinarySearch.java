import java.util.Arrays;


public class ModifiedBinarySearch {
	
	public static int rank(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		while(low <= high){
			if(a[low] == key)	return low;
			int mid = (low + high) / 2;
			if(a[mid] > key)	high = mid - 1;
			else if(a[mid] < key)	low = mid + 1;
			else{
				high = mid;
				low++;
			}
		}
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = In.readInts(args[0]);
		Arrays.sort(a);
		for (int i : a) {
			StdOut.print(i + " ");
		}
		StdOut.println();
		while(!StdIn.isEmpty()){
			StdOut.println(rank(a, StdIn.readInt()));
		}
	}

}
