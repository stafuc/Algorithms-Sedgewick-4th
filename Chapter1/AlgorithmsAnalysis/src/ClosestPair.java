import java.util.Arrays;


public class ClosestPair {

	/**
	 * Find closest pair in array.
	 *
	 * @param a the a
	 * @return the closest pair
	 */
	public static double[] findClosest(double[] a) {
		assert a.length > 1 : "array size must larger than 1";
		Arrays.sort(a);
		double min = Double.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if(i + 1 < a.length){
				double diff = a[i + 1] - a[i];
				if(diff < min){
					min = diff;
					index = i;
				}
			}
		}
		return new double[] {a[index], a[index + 1]};
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double MAX = 1000000;
		for (int N = 100; N < 100000; N += N) {
			double[] d = new double[N];
			for (int i = 0; i < d.length; i++) {
				d[i] = StdRandom.uniform(-MAX, MAX);
			}
			double[] pair = findClosest(d);
			StdOut.printf("%5.2f %5.2f\n", pair[0], pair[1]);
		}

	}

}
