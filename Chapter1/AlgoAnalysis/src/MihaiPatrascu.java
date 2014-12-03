import java.util.Arrays;


public class MihaiPatrascu {

	public static int rank(int[] a, int key) {
		int last = 0, cur = 1;
		while(cur < a.length && a[cur] < key){
			int temp = last + cur;
			last = cur;
			cur = temp;
		}
		if(cur < a.length){
			if(a[cur] == key)	return cur;
			else{
				for (int i = last; i < cur; ++i) {
					if(a[i] == key)	return i;
				}
			}
		}else{
			for (int i = last; i < a.length; ++i) {
				if(a[i] == key)	return i;
			}
		}
		return -1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 5; N < 20; N += 2) {
			int[] a = new int[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(-20, 20);
			}
			Arrays.sort(a);
			for (int i = 0; i < a.length; i++) {
				StdOut.printf("%d ", a[i]);
			}
			StdOut.println();
			for (int i = 0; i < N; i++) {
				int temp = StdRandom.uniform(-20, 20);
				StdOut.printf("find %d %d\n", temp, rank(a, temp));
			}
		}
	}

}
