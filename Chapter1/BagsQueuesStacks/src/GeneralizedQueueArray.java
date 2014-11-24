import java.util.Iterator;
import java.util.NoSuchElementException;


public class GeneralizedQueueArray<Item> implements Iterable<Item> {
	private Item[] a = (Item[])new Object[1];
	private int N;
	
	private void resize(int max){
		Item[] temp = (Item[])new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void insert(Item x){
		if(N == a.length)	resize(2 * a.length);
		a[N++] = x;
	}
	
	public Item delete(int k) {
		if(k > N || k == 0)	throw new NoSuchElementException();
		Item ret = a[k - 1];
		for (int i = k; i < N; i++) {
			a[i - 1] = a[i];
		}
		N--;
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		GeneralizedQueueArray<Integer> q = new GeneralizedQueueArray<Integer>();
		q.insert(3);
		q.insert(4);
		q.insert(5);
		q.insert(6);
		q.delete(2);
		q.delete(2);
		q.delete(2);
//		q.delete(1);
		for (Integer integer : q) {
			StdOut.println(integer);
		}

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new GeneralizedQueueArrayIterator();
	}
	
	private class GeneralizedQueueArrayIterator implements Iterator<Item>{
		
		int cur = 0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cur < N;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[cur++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
