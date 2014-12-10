
public class Ex_1_5_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = (int)1e7, M = (int)1e6;
		WeightedQuickUnionUF wquf = new WeightedQuickUnionUF(N);
		StopWatch sw = new StopWatch();
		for (int i = 0; i < M; i++) {
			int p = StdRandom.uniform(N), q = StdRandom.uniform(N);
			if(wquf.connected(p, q))	continue;
			wquf.union(p, q);
//			StdOut.printf("%5d <-> %5d\n", p, q);
		}
		StdOut.printf("%d components\n", wquf.count());
		StdOut.printf("time: %.3f\n", sw.elapsedTime());
	}

}
