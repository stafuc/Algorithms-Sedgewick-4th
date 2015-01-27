import java.util.ArrayList;
import java.util.Arrays;


public class Multiway {

	public static void merge(int[][] arrays) {
		IndexMinPQ<Integer> pq = new IndexMinPQ<Integer>();
		for (int i = 0; i < arrays.length; i++) {
			pq.insert(i, arrays[i][0]);
		}
		int[] in = new int[arrays.length];
		for (int i = 0; i < arrays.length; i++) {
			in[i] = 1;
		}
		String res = "";
		while (!pq.isEmpty()) {
			Integer min = pq.min();
			res += min + ",";
			int index = pq.delMin();
			if(in[index] < arrays[index].length)	pq.insert(index, arrays[index][in[index]++]);
		}
		System.out.println(res);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arrays = new int[4][10];
		int Max = 100;
		for (int i = 0; i < arrays.length; i++) {
			arrays[i] = new int[10];
			for (int j = 0; j < arrays[i].length; j++) {
				arrays[i][j] = StdRandom.uniform(-Max, Max);
			}
			Arrays.sort(arrays[i]);
//			String s = "";
//			for (int j = 0; j < arrays[i].length; j++) {
//				s += arrays[i][j] + " ";
//			}
//			System.out.println(s);
		}
		merge(arrays);
	}

}
