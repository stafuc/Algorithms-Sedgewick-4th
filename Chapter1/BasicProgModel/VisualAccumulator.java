
public class VisualAccumulator {

	private int N;
	private double total;
	
	public VisualAccumulator(int trial, double max) {
		// TODO Auto-generated constructor stub
		StdDraw.setXscale(0, trial);
		StdDraw.setYscale(0, max);
		StdDraw.setPenRadius(0.005);
	}
	
	public void addDataValue(double val){
		N++;
		total += val;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, val);
		
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(N, mean());
	}
	
	public double mean(){
		return N == 0? 0.0:total / N;
	}
	
	public String toString(){
		return "Mean (" + N + " values):" + String.format("%7.5f", mean());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = Integer.parseInt(args[0]);
		VisualAccumulator a = new VisualAccumulator(T, 1.0);
		for (int i = 0; i < T; i++) {
			a.addDataValue(StdRandom.random());
		}
		StdOut.println(a);
	}

}
