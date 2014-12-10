
public class StopWatch {
	private long start;
	public StopWatch() {
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime() {
		return (System.currentTimeMillis() - start) / 1000.0;
	}
	
	public void clear() {
		start = System.currentTimeMillis();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
