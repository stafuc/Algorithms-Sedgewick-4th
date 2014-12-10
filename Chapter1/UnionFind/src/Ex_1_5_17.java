
public class Ex_1_5_17 {

	/**
	 * Count.
	 *
	 * @param N the number of contacts
	 * @return the int number of links to link all contacts
	 */
	public static int count(int N) {
		WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(N);
		int cnt = 0;
		while(wqu.count() > 1){
			int p = StdRandom.uniform(N), q = StdRandom.uniform(N);
			++cnt;
			if(wqu.connected(p, q))	continue;
			wqu.union(p, q);
		}
		return cnt;
	}
	
	public static int count1(int N) {
		PathCprWeightedQuickUnionUF pwqu = new PathCprWeightedQuickUnionUF(N);
		int cnt = 0;
		while(pwqu.count() > 1){
			int p = StdRandom.uniform(N), q = StdRandom.uniform(N);
			++cnt;
			if(pwqu.connected(p, q))	continue;
			pwqu.union(p, q);
		}
		return cnt;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 500; N < 2e7; N += N) {
			StopWatch sw = new StopWatch();
			int cnt = count(N);
			StdOut.printf("no path com:%d %.3f %d\n", N, sw.elapsedTime(), cnt);
			sw.clear();
			cnt = count1(N);
			StdOut.printf("path com:%d %.3f %d\n", N, sw.elapsedTime(), cnt);
			StdOut.println("---------------------");
		}
	}

}
