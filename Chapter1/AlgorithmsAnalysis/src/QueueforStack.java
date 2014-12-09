import java.util.NoSuchElementException;


public class QueueforStack<Item> {

	private Queue<Item> queue = new Queue<Item>();
	
	public void push(Item item) {
		queue.enqueue(item);
	}
	
	public Item pop() {
		if(queue.isEmpty())	throw new NoSuchElementException("stack underflow");
		Queue<Item> nq = new Queue<Item>();
//		StdOut.println(queue.size());
		int size = queue.size();
		for (int i = 0; i < size - 1; i++) {
			nq.enqueue(queue.dequeue());
		}
//		StdOut.println(nq.size());
		Item item = queue.dequeue();
		queue = nq;
		return item;
	}
	
	public String toString() {
		String str = "";
		for (Item i : queue) {
			str += i + " ";
		}
		return str;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueforStack<Integer> qs = new QueueforStack<Integer>();
		for (int i = 0; i < 20; ++i) {
			if(StdRandom.uniform() < 0.5){
				int temp = StdRandom.uniform(100);
				qs.push(temp);
				StdOut.printf("push %3d\n", temp);
			}else{
				try {
					int temp = qs.pop();
					StdOut.printf("pop %3d\n", temp);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
			
//			StdOut.println("now queue:" + qs.toString());
		}

	}

}
