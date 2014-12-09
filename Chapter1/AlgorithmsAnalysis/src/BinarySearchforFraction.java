
public class BinarySearchforFraction {

	private static final double EXP = 0.00001;
	
	/**
	 * Guess.
	 *
	 * @param p the p
	 * @param q the q
	 * @return the double
	 */
	public static double guess(int p, int q) {
		double left = 0, right = 1;
		double x = p / 1.0 / q;
		while(left <= right){
			double mid = (left + right) / 2;
			if(Math.abs(mid - x) <= EXP)	return mid;
			if(mid < x)	left = mid + EXP;
			else	right = mid - EXP;
		}
		return -1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p, q;
		while(!StdIn.isEmpty()){
			p = StdIn.readInt();
			q = StdIn.readInt();
			StdOut.printf("find: %f\n", guess(p, q));
		}
	}

}
