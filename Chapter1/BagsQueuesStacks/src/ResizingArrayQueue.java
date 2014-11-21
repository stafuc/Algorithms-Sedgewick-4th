import java.util.Iterator;
import java.util.NoSuchElementException;


public class ResizingArrayQueue<Item> implements Iterable<Item>{
	
	private Item[] a = (Item[])new Object[1];
	
	private int head = -1;
	private int tail = 0;
	private int N = 0;
	
	private void resize(int max){
		assert max >= N;
		Item[] temp = (Item[])new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[(head + i) % a.length];
		}
		head = 0;
		tail = N;
		a = temp;
	}
	
	
	public void enqueue(Item item){
		if(N == a.length){
			resize(2 * a.length);
		}
		a[tail] = item;
		tail = (tail + 1) % a.length;
		if(head == -1)	head = 0;
		N++;
	}
	
	public Item dequeue(){
		if(N == 0)	throw new NoSuchElementException();
		Item item = a[head];
		head = (head + 1) % a.length;
		N--;
		if(N > 0 && N <= a.length / 4)	resize(a.length / 2);
		return item;
	}
	
	public int size(){
		return N;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResizingArrayQueue<Integer> q = new ResizingArrayQueue<Integer>();
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(s.equals("-"))	q.dequeue();
			else	q.enqueue(Integer.parseInt(s));
		}
		
		StdOut.println(q.size() + " left in queue!");
		for (Integer integer : q) {
			StdOut.println(integer);
		}
	}


	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ResizingArrayQueueIterator();
	}
	
	private class ResizingArrayQueueIterator implements Iterator<Item>{

		int current = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current < N;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[(head + current++) % a.length];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
