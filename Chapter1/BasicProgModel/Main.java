import java.util.Arrays;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;


public class Main {
	
	private static TreeMap<Integer, Long> countMap = new TreeMap<Integer, Long>(); 
	
	public static void invert(int[][] mat){
		int M = mat.length;
		int N = mat[0].length;
		for(int i = 0; i < N; ++i){
			for(int j = 0; j < M; j++)
				System.out.printf("%3d", mat[j][i]);
			System.out.println();
		}
	}
	
	/**
	 * Log.
	 *
	 * @param N the n
	 * @return the int
	 */
	public static int log(int N){
		int index = 0;
		int temp = 1;
		while(temp <= N){
			temp *= 2;
			index++;
		}
		return index - 1;
	}
	
	public static int[] count(int[] a, int M) {
		int[] data = new int[M];
		for (int i : a) {
//			System.out.println(i);
			data[i]++;
		}
		return data;
	}
	
	public static int mystery(int a, int b){
		if(b == 0) return 0;
		if(b % 2 == 0) return mystery(a + a, b / 2);
		return mystery(a + a, b / 2) + a;
	}
	
	public static long F(int N){
		if(N == 0) return 0;
		if(N == 1) return 1;
		if(countMap.containsKey(N))
			return countMap.get(N);
		long ret = F(N - 1) + F(N - 2);
		countMap.put(N, ret);
		return ret;
	}
	
	public static double logFact(int N){
		if(N == 1 || N == 0)
			return 1;
		return Math.log(N) + logFact(N - 1);
	}
	
	public static void printTable(){
		while(StdIn.hasNextLine()){
			String name = StdIn.readString();
			int a = StdIn.readInt();
			int b = StdIn.readInt();
			System.out.printf("%s %3d %3d %.3f\n", name, a, b, a / 1.0 / b);
		}
	}
	
	public static int rank(int key, int[] a){
		return rank(key, a, 0, a.length - 1, 1);
	}
	
	private static int rank(int key, int[] a, int lo, int hi, int depth){
//		StdOut.printf("%s%d-%d\n", repeat(depth, ' '), lo, hi);
		if(lo > hi) return -1;
		int mid = (lo + hi) / 2;
		if(a[mid] < key) return rank(key, a, mid + 1, hi, depth + 1);
		else if(a[mid] > key) return rank(key, a, lo, mid - 1, depth + 1);
		else return mid;
	}
	
	private static String repeat(int n, char c){
		String s = "";
		for (int i = 0; i < n; i++) {
			s += c;
		}
		return s;
	}
	
	public static int Euclid(int a, int b){
		StdOut.printf("%d, %d\n", a, b);
		if(a < b) return Euclid(b, a);
		if(b == 0) return a;
		return Euclid(b, a % b);
	}
	
	private static int recurCnt =0;
	public static double binomial(int N, int K, double p){
		double[][] v = new double[N + 1][K + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				v[i][j] = -1;
			}
		}
		return binomial(v, N, K, p);
	}
	
	private static double binomial(double[][] v, int N, int K, double p){
		recurCnt++;
		if(N == 0 && K == 0) return 1.0;
		if(N < 0 || K < 0) return 0.0;
		if(v[N][K] != -1) return v[N][K];
		v[N][K] = p * binomial(v, N - 1, K - 1, p) + (1 - p) * binomial(v, N - 1, K, p);
		return v[N][K];
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int N = 3;
//		String res = "";
//		while(N > 0){
//			if(N % 2 == 1)
//				res = "1" + res;
//			else
//				res = "0" + res;
//			N /= 2;
//		}
//		System.out.println(res);
//		int[][] mat = new int[5][5];
//		for(int i = 0; i < 5; ++i){
//			for(int j = 0; j < 5; ++j){
//				mat[i][j] = i * 5 + j;
//				System.out.printf("%3d", mat[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println("------------------------");
//		invert(mat);

//		System.out.println(log(4));
//		int[] a = {0, 2, 3, 4, 0, 1, 3, 5};
//		int[] r = count(a, 6);
//		for (int i : r) {
//			System.out.print(i);
//		}
		
//		System.out.println(mystery(3, 11));
//		System.out.println(F(2));
//		System.out.println(logFact(10));
//		printTable();
//		int[] a = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 18, 20, 22, 30};
//		rank(31, a);
		
//		1.1.23
//		int[] whitelist = In.readInts(args[0]);
//		Arrays.sort(whitelist);
////		StdOut.println(args[0] + "-" + args[1]);
//		while(!StdIn.isEmpty()){
//			int key = StdIn.readInt();
//			int r = rank(key, whitelist);
////			StdOut.println(r);
//			if(args[1].equals("+") && r < 0) StdOut.println(key);
//			if(args[1].equals("-") && r >= 0) StdOut.println(key);
//		}
		
//		1.1.24
//		if(args.length != 2) return;
//		StdOut.printf("res: %d", Euclid(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
		
//		1.1.27
		binomial(5, 5, 0.25);
		StdOut.println(recurCnt);
	}

}
