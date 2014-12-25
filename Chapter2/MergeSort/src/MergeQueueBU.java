
public class MergeQueueBU {
	public static void sort(Comparable[] a) {
		Queue<Queue<Comparable>> queue = new Queue<Queue<Comparable>>();
		for (Comparable c : a) {
			Queue<Comparable> q = new Queue<Comparable>();
			q.enqueue(c);
			queue.enqueue(q);
		}
		while(queue.size() > 1){
			Queue<Comparable> q1 = queue.dequeue();
			Queue<Comparable> q2 = queue.dequeue();
			queue.enqueue(MergeOrderedQueue.merge(q1, q2));
		}
		Queue<Comparable> q = queue.peek();
		int index = 0;
		while(!q.isEmpty()){
			a[index++] = q.dequeue();
		}
	}
	
	public static void show(Comparable[] a) {
		String str = "";
		for (Comparable c : a) {
			str += c + " ";
		}
		StdOut.println(str);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MAX = 10000;
		for (int N = 100; N < 1e6; N += N) {
			Integer[] a = new Integer[N];
			for (int i = 0; i < a.length; i++) 
				a[i] = StdRandom.uniform(-MAX, MAX);
			MergeQueueBU.sort(a);
			if(!NonStaticMerge.isSorted(a))	StdOut.println(N + ":error");
			else StdOut.println(N + " finish.");
		}
	}

}
