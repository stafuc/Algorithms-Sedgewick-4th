
public class Ex_1_1_36 {
	
	public static int[] shuffle(int[] a){
		for (int i = 0; i < a.length; i++) {
//			int c = StdRandom.uniform(a.length);
			int c = i + StdRandom.uniform(a.length - i);
//			int c = StdRandom.uniform(i + 1);
			int tmp = a[c];
			a[c] = a[i];
			a[i] = tmp;
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M = Integer.parseInt(args[0]),
			N = Integer.parseInt(args[1]);
		int[][] count = new int[M][M];
		for (int i = 0; i < N; i++) {
			int[] a = new int[M];
			for (int j = 0; j < M; j++) {
				a[j] = j;
			}
			a = shuffle(a);
			for (int j = 0; j < a.length; j++) {
				count[a[j]][j]++;
			}
		}
		
		String str = "";
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				str += count[i][j] + " ";
			}
			str += "\n";
		}
		StdOut.println(str);

	}

}
