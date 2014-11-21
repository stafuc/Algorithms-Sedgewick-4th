
public class Ex_1_1_33 {
	
	private static double[][] readMatrix(int M, int N){
		double[][] a = new double[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = StdIn.readDouble();
			}
		}
		return a;
	}
	
	private static String matrix2Str(double[][] a){
		String str = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				str += a[i][j] + " ";
			}
			str += "\n";
		}
		return str;
	}
	
	public static double dot(double[] x, double[] y){
		if(x.length != y.length){
			StdOut.println("dimension not equal!");
			return -1;
		}
		double s = 0.0;
		for (int i = 0; i < x.length; i++) {
			s += x[i] * y[i];
		}
		return s;
	}
	
	public static double[][] mult(double[][] a, double[][] b) {
		if(a.length == 0 || a[0].length == 0 || b.length == 0 || b[0].length == 0){
			StdOut.println("invalid matrix");
			return null;
		}
		if(a[0].length != b.length){
			StdOut.println("dimension not match");
			return null;
		}
		double[][] c = new double[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				double s = 0;
				for (int k = 0; k < a[0].length; k++) {
					s += a[i][k] * b[k][j];
				}
				c[i][j] = s;
			}
		}
		return c;
	}
	
//	public static double[] mult(double[] y, double[][] a){
//		if(a.length != 1){
//			StdOut.println("dimension not match");
//			return null;
//		}
//		double[][] c = new double[y.length][a[0].length];
//		for (int i = 0; i < c.length; i++) {
//			for (int j = 0; j < c[0].length; j++) {
//				c[i][j] = y[i] * a[0][j];
//			}
//		}
//		return c;
//	}
	
	public static double[][] transpose(double[][] a){
		double[][] b = new double[a[0].length][a.length];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				b[i][j] = a[j][i];
			}
		}
		return b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test vector dot
//		double[] a, b;
//		String[] s1 = StdIn.readLine().split(" "),
//				 s2 = StdIn.readLine().split(" ");
//		a = new double[s1.length];
//		b = new double[s2.length];
//		for (int i = 0; i < s1.length; i++) {
//			a[i] = Double.parseDouble(s1[i]);
//		}
//		
//		for (int i = 0; i < s2.length; i++) {
//			b[i] = Double.parseDouble(s2[i]);
//		}
//		
//		StdOut.println(dot(a, b));
		
		// test matrix mult
//		int M = StdIn.readInt(), N = StdIn.readInt();
//		double[][] a = new double[M][N];
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				a[i][j] = StdIn.readDouble();
//			}
//		}
//		
//		M = StdIn.readInt();
//		N = StdIn.readInt();
//		double[][] b = new double[M][N];
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				b[i][j] = StdIn.readDouble();
//			}
//		}
//		
//		double[][] c = mult(a, b);

//		}
//		StdOut.println(str);
		
		// test matrix transpose
		int M = StdIn.readInt(), N = StdIn.readInt();
		double[][] a = readMatrix(M, N);
		double[][] b = transpose(a);
		StdOut.println(matrix2Str(b));
		

	}

}
