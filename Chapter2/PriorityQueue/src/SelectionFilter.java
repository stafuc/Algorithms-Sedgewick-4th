
public class SelectionFilter {
	private MinPQ<Point> pq;
	
	private static class Point implements Comparable{
		double x;
		double y;
		double z;
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			Point p = (Point)o;
			double d1 = distance(), d2 = p.distance();
			if(d1 < d2)	return 1;
			else if(d1 > d2)	return -1;
			else return 0;
		}
		
		public double distance() {
			return x * x + y * y + z * z;
		}
	}
	
	public SelectionFilter() {
		// TODO Auto-generated constructor stub
		pq = new MinPQ<Point>();
	}
	
	public void filter(int N, int M) {
		double max = 10000.0;
		for (int i = 0; i < N; i++) {
			Point p = new Point();
			p.x = StdRandom.uniform(-max, max);
			p.y = StdRandom.uniform(-max, max);
			p.z = StdRandom.uniform(-max, max);
			pq.insert(p);
			if(pq.size() > M)	pq.delMin();
		}
		Stack<Point> s = new Stack<Point>();
		while(!pq.isEmpty()){
			s.push(pq.delMin());
		}
		while(!s.isEmpty()){
			Point p = s.pop();
			System.out.printf("(%f, %f, %f, %f)\n", p.x, p.y, p.z, p.distance());
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int N = Integer.parseInt(args[0]);
//		int M = Integer.parseInt(args[1]);
		SelectionFilter sf = new SelectionFilter();
		StopWatch sw = new StopWatch();
		sf.filter(100000000, 10000);
		System.out.println(sw.elapsedTime());
	}

}
