import java.util.NoSuchElementException;


public class DoubleStackQueue<Item> {

	private Stack<Item> left = new Stack<Item>();
	private Stack<Item> right = new Stack<Item>();
	
	/**
	 * Enqueue.
	 *
	 * @param item the item
	 */
	public void enqueue(Item item) {
		right.push(item);
	}
	
	/**
	 * Dequeue.
	 *
	 * @return the item
	 */
	public Item dequeue() {
		if(!left.isEmpty())	return left.pop();
		if(right.isEmpty())	throw new NoSuchElementException();
		while(!right.isEmpty()){
			Item item = right.pop();
			left.push(item);
		}
		return left.pop();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleStackQueue<Integer> dq = new DoubleStackQueue<Integer>();
		for (int i = 0; i < 20; ++i) {
			if(StdRandom.uniform() < 0.5){
				int temp = StdRandom.uniform(100);
				dq.enqueue(temp);
				StdOut.printf("enqueue %3d\n", temp);
			}else{
				try {
					int temp = dq.dequeue();
					StdOut.printf("dequeue %3d\n", temp);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		}

	}

}
