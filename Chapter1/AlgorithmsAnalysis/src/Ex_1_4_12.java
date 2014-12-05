
public class Ex_1_4_12 {

	public static void common(int[] a, int[] b) {
		int i = 0, j = 0;
		while(i < a.length && j < b.length){
			while(i < a.length && j < b.length && a[i] < b[j])	++i;
			while(i < a.length && j < b.length && b[j] < a[i])	++j;
			if(i < a.length && j < b.length && a[i] == b[j]){
				StdOut.print(a[i] + " ");
				++i;
				++j;
			}
		}
		StdOut.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int[] b = {0, 0, 0, 0, 0, 0, 7};
		common(a, b);
	}

}
