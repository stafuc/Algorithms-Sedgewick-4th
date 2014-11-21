
public class Accumulator {
	
	private int N;
	private double total;
	
	public void addDataValue(double val){
		N++;
		total += val;
	}
	
	public double mean(){
		return N == 0? 0.0: total / N;
	}
	
	public String toString(){
		return "Mean (" + N + " values):" + String.format("%7.5f", mean());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T = Integer.parseInt(args[0]);
		Accumulator a = new Accumulator();
		for (int i = 0; i < T; i++) {
			a.addDataValue(StdRandom.random());
		}
		StdOut.println(a);

	}

}
