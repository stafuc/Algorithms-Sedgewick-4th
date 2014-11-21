
/**
 * The Class PrimeArray for 1.1.30.
 */
public class PrimeArray {

	/**
	 * Prime.
	 *
	 * @param a the a
	 * @param b the b
	 * @return true, if successful
	 */
	private static boolean prime(int a, int b){
		if(a == 0 || b == 0) return false;
		for (int i = 2; i <= a; i++) {
			if(a % i == 0 && b % i == 0) return false;
		}
		return true;
	}
	public static boolean[][] primeArray(int N){
		boolean[][] a = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(prime(i, j)) a[i][j] = true;
				else a[i][j] = false;
			}
		}
		return a;
	}
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 10;
		boolean[][] b = primeArray(N);
		String str = "";
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				str += b[i][j] + " ";
			}
			str += "\n";
		}
		StdOut.println(str);

	}

}
