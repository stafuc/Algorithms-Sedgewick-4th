
public class LocalMinimuminMatrix {

	public static int[] find(int[][] a) {
		return find(a, 0, 0, a.length - 1, a[0].length - 1);
	}
	
	private static int[] find(int[][] a, int r1, int c1, int r2, int c2) {
		assert r1 <= r2 && c1 <= c2 : "invalid matrix parameter";
//		StdOut.printf("%d %d %d %d\n", r1, c1, r2, c2);
		int midr = (r1 + r2) / 2, midc = (c1 + c2) / 2;
		int index1 = LocalMinimum.find(a[midr]);
		if(midr - 1 < r1 || a[midr - 1][index1] >= a[midr][index1]){
			if(midr + 1 > r2 || a[midr + 1][index1] >= a[midr][index1])
				return new int[]{midr, index1};
		}
		int nr1, nc1, nr2, nc2;
		if(midr - 1 >= r1 && a[midr - 1][index1] < a[midr][index1]){
			nr1 = r1;
			nr2 = midr - 1;
		}else{
			nr1 = midr + 1;
			nr2 = r2;
		}
		
		int[] cols = new int[r2 - r1 + 1];
		for (int i = 0; i < cols.length; i++) {
			cols[i] = a[r1 + i][midc];
		}
		index1 = r1 + LocalMinimum.find(cols);
		if(midc - 1 < c1 || a[index1][midc - 1] >= a[index1][midc]){
			if(midc + 1 > c2 || a[index1][midc + 1] >= a[index1][midc]){
				return new int[]{index1, midc};
			}
		}
		if(midc - 1 >= c1 && a[index1][midc - 1] < a[index1][midc]){
			nc1 = c1;
			nc2 = midc - 1;
		}else{
			nc1 = midc + 1;
			nc2 = c2;
		}
		return find(a, nr1, nc1, nr2, nc2);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 10;
		for (int N = 1; N < 10; ++N) {
			int[][] a = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					a[i][j] = StdRandom.uniform(-MAX, MAX);
					StdOut.printf("%3d ", a[i][j]);
				}
				StdOut.println();
			}
			int[] res = find(a);
			StdOut.printf("%3d %3d\n------------\n", res[0], res[1]);
		}
	}

}
