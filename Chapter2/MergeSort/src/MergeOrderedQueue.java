
public class MergeOrderedQueue {

	public static Queue<Comparable> merge(Queue<Comparable> q1, Queue<Comparable> q2) {
		Queue<Comparable> ret = new Queue<Comparable>();
		while(!q1.isEmpty() && !q2.isEmpty()){
			if(less(q1.peek(), q2.peek()))	ret.enqueue(q1.dequeue());
			else ret.enqueue(q2.dequeue());
		}
		while(!q1.isEmpty()){
			ret.enqueue(q1.dequeue());
		}
		
		while(!q2.isEmpty()){
			ret.enqueue(q2.dequeue());
		}
		return ret;
	}
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Comparable> q1 = new Queue<Comparable>();
		Queue<Comparable> q2 = new Queue<Comparable>();
		q1.enqueue(1);
		q1.enqueue(2);
		q1.enqueue(3);
		q2.enqueue(4);
		q2.enqueue(5);
		Queue<Comparable> q = merge(q1, q2);
		for (Comparable c : q) {
			StdOut.printf(c + " ");
		}
		StdOut.println();

	}

}
