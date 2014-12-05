
public class ThreeSum {

	public static int count(int[] a){
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = j + 1; k < a.length; k++) {
					if(a[i] + a[j] + a[k] == 0)	cnt++;
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
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
		StdOut.println(Integer.MAX_VALUE);
	}

}
