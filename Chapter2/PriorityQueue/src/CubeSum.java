
public class CubeSum {
	private int N;
	private MinPQ<Node> pq;
	
	private static class Node implements Comparable{
		int v;
		int i;
		int j;
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			Node n2 = (Node)o;
			if(v < n2.v)	return -1;
			else if(v == n2.v)	return 0;
			else	return 1;
		}
	}
	
	public CubeSum(int N) {
		// TODO Auto-generated constructor stub
		this.N = N;
		pq = new MinPQ<Node>();
		for (int i = 0; i <= N; i++) {
			Node n = new Node();
			n.v = i * i * i + 0;
			n.i = i;
			n.j = 0;
			pq.insert(n);
		}
	}
	
	public void sort() {
		while(!pq.isEmpty()){
			Node n = pq.delMin();
			System.out.printf("(%d, %d, %d)\n", n.v, n.i, n.j);
			if(n.j < N){
				Node n1 = new Node();
				n1.i = n.i;
				n1.j = n.j + 1;
				n1.v = n1.i * n1.i * n1.i + n1.j * n1.j * n1.j;
				pq.insert(n1);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CubeSum c = new CubeSum(10);
		c.sort();
	}

}
