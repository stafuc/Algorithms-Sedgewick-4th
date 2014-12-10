
public class RandomGrid {
	private static class Connection{
		int p;
		int q;
		
		public Connection(int p, int q) {
			// TODO Auto-generated constructor stub
			this.p = p;
			this.q = q;
		}
		
		public String toString() {
			return p + " -> " + q;
		}
	}

	public static Connection[] generate(int N) {
		RandomBag<Connection> bag = new RandomBag<Connection>();
		for (int i = 0; i < N * N; i++) {
			for (int j = 0; j < N * N; j++) {
				bag.add(new Connection(i, j));
			}
		}
		Connection[] cons = new Connection[bag.size()];
		int index = 0;
		for (Connection con : bag) {
			cons[index++] = con;
		}
		return cons;
	}
	
	public static boolean adjacent(int p, int q, int N) {
		if((p / N == q / N) && (Math.abs(p - q) == 1))	return true;
		if(Math.abs(p - q) == N)	return true;
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		Connection[] c = generate(N);
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N);
		StdDraw.setPenRadius(0.05);
		StdDraw.setPenColor(StdDraw.RED);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				StdDraw.point(i, j);
			}
		}
		PathCprWeightedQuickUnionUF p = new PathCprWeightedQuickUnionUF(N * N);
		StdDraw.setPenRadius(0.005);
		StdDraw.setPenColor(StdDraw.BLACK);
		for (Connection con : c) {
			int p1 = con.p, p2 = con.q;
			if(p.connected(p1, p2))	continue;
			if(adjacent(p1, p2, N)){
				p.union(p1, p2);
				StdDraw.line(p1 / N, p1 % N, p2 / N, p2 % N);
			}
		}
	}

}
