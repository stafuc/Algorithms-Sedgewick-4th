import java.util.Arrays;


public class DistantPair {

	public static double[] findDistant(double[] a) {
		assert a.length > 1 : "array size must larger than 1";
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if(a[i] > max)	max = a[i];
			if(a[i] < min)	min = a[i];
		}
		return new double[] {min, max};
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
			double[] pair = findDistant(d);
			StdOut.printf("%5.2f %5.2f\n", pair[0], pair[1]);
		}
	}

}
