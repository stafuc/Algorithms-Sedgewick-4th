import java.util.Arrays;


// TODO: Auto-generated Javadoc
/**
 * The Class BinarySearch for 1.1.29.
 */
public class BinarySearch {

	public static int rank(int key, int[] a){
		int lo = 0, hi = a.length - 1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(a[mid] < key) lo = mid + 1;
			else if(a[mid] > key) hi = mid - 1;
			else return mid;
		}
		return lo;
	}
	
	public static int count(int key, int[] a){
		int r = rank(key, a);
		int cnt = 0;
		if(r >= 0 && r < a.length){
			int p1 = r;
			int p2 = r + 1;
			while(a[p1--] == key){
				cnt++;
				if(p1 < 0) break;
			}
			while(a[p2++] == key){
				cnt++;
				if(p2 >= a.length) break;
			}	
		}
		return cnt;
		
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] whitelist = In.readInts(args[0]);
		Arrays.sort(whitelist);
		String str = "";
		for (int i : whitelist) {
			str += i + " ";
		}
		StdOut.println(str);
		while(!StdIn.isEmpty()){
			int key = StdIn.readInt();
//			StdOut.println(rank(key, whitelist));
			StdOut.println(count(key, whitelist));
		}

	}

}
