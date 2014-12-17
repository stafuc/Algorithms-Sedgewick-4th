
public class Ex_2_1_28 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 128; N < 9e4; N += N) {
			Integer[] a = new Integer[N];
			for (int i = 0; i < a.length; i++) {
				a[i] = StdRandom.uniform(1, 3);
			}
			double time1 = SortCompare.time("Insertion", a);
			double time2 = SortCompare.time("Selection", a);
			StdOut.printf("N:%d, ins:%.3f, sel:%.3f\n",  N, time1, time2);
		}

	}

}
