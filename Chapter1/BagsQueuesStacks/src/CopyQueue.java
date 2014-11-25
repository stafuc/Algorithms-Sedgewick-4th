
public class CopyQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new Queue<Integer>();
		Queue<Integer> r = new Queue<Integer>();
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		
		int N = q.size();
		for (int i = 0; i < N; i++) {
			int temp = q.dequeue();
			r.enqueue(temp);
			q.enqueue(temp);
		}
		
		
		q.enqueue(2);
		r.enqueue(6);
		
		for (Integer integer : q) {
			StdOut.println(integer);
		}
		
		StdOut.println("-------------");
		
		for (Integer integer : r) {
			StdOut.println(integer);
		}

	}

}
