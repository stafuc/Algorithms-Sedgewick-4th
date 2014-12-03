
public class StopWatch {
	private final long start;
	public StopWatch() {
		start = System.currentTimeMillis();
	}
	
	public double elapsedTime() {
		return (System.currentTimeMillis() - start) / 1000.0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
