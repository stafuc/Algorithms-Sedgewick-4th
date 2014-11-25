import java.util.Iterator;
import java.util.NoSuchElementException;


public class RingBuffer<Item> implements Iterable<Item> {
	
	private int head = -1;
	private int tail = 0;
	private Item[] a;
	private int N;
	
	public RingBuffer(int N) {
		// TODO Auto-generated constructor stub
		a = (Item[])new Object[N];
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public boolean isFull(){
		return N == a.length;
	}
	
	public int size() {
		return N;
	}
	
	public void enqueue(Item item) throws Exception {
		if(isFull())	throw new Exception("Buffer is full!");
		a[tail] = item;
		tail = (tail + 1) % a.length;
		if(N == 0)	head = 0;
		N++;
	}
	
	public Item dequeue(){
		if(isEmpty())	throw new NoSuchElementException("Buffer is empty!");
		Item item = a[head];
		head = (head + 1) % a.length;
		N--;
		if(N == 0){
			head = -1;
			tail = 0;
		}
		return item;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RingBuffer<Integer> b = new RingBuffer<Integer>(1);
		for (int i = 0; i < 20; i++) {
			if(StdRandom.uniform() < 0.5){
				int temp = StdRandom.uniform(10);
				try {
					b.enqueue(temp);
					StdOut.println("enqueue " + temp);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}else{
				try {
					int temp = b.dequeue();
					StdOut.println("dequeue " + temp);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RingBufferIterator();
	}
	
	private class RingBufferIterator implements Iterator<Item>{

		int cur = head;
		int cnt = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cnt < N;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = a[cur];
			cnt++;
			cur = (cur + 1) % a.length;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
