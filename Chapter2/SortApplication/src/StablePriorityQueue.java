
public class StablePriorityQueue {

	private static class Node implements Comparable<Node>{
		int value;
		int index;
		public Node(int v, int i) {
			// TODO Auto-generated constructor stub
			value = v;
			index = i;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(value < o.value)	return -1;
			else if(value > o.value)	return 1;
			else	return index - o.index;
//			return value - o.value;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinPQ<Node> pq = new MinPQ<Node>();
		for (int i = 0; i < 5; i++) {
			pq.insert(new Node(2, i));
		}
		while(!pq.isEmpty()){
			Node n = pq.delMin();
			System.out.println(n.value + " " + n.index);
		}

	}

}
