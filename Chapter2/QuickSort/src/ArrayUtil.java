
public class ArrayUtil {
	public static Integer[] randArray(int N) {
		Integer[] a = new Integer[N];
		int MAX = 100000;
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(-MAX, MAX);
		}
		return a;
	}
	
	public static Integer[] orderedArray(int N) {
		Integer[] a = new Integer[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		return a;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
