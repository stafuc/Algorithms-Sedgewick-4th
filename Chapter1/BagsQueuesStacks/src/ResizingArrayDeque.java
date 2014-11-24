import java.util.Iterator;
import java.util.NoSuchElementException;


public class ResizingArrayDeque<Item> implements Iterable<Item>{
	
	private int left = -1;
	private int right = -1;
	Item[] a = (Item[])new Object[1];
	int N;
	
	
	private void resize(int max){
//		assert max >= a.length;
		assert left != -1;
		assert right != -1;
		Item[] temp = (Item[])new Object[max];
		for(int i = left, index = 0; index < N; ++i){
			temp[index++] = a[i];
			if(i== a.length - 1)	i = -1;
		}
		a = temp;
		left = 0;
		right = N - 1;
	}
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public int length(){
		return a.length;
	}
	
	void pushLeft(Item item){
		if(N == a.length)	resize(2 * a.length);
		if(left == -1){
			a[0] = item;
			left = right = 0;
		}else{
			left = (left - 1 + a.length) % a.length;
			a[left] = item;
		}
		N++;
	}
	
	void pushRight(Item item){
		if(N == a.length)	resize(2 * a.length);
		if(right == -1){
			a[0] = item;
			left = right = 0;
		}else{
			right = (right + 1) % a.length;
			a[right] = item;
		}
		N++;
	}
	
	Item popLeft(){
		if(left == -1)	throw new NoSuchElementException();
		Item temp = a[left];
		a[left] = null;
		N--;
		if(N == 0)	left = right = -1;
		else	left = (left + 1) % a.length;
		if(N > 0 && N <= a.length / 4)	resize(a.length / 2);
		return temp;
	}
	
	Item popRight(){
		if(right == -1)	throw new NoSuchElementException();
		Item temp = a[right];
		a[right] = null;
		N--;
		if(N == 0)	left = right = -1;
		else	right = (right - 1 + a.length) % a.length;
		if(N > 0 && N <= a.length / 4)	resize(a.length / 2);
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResizingArrayDeque<Integer> q = new ResizingArrayDeque<Integer>();
//		StdOut.println("size" + q.length());
		q.pushLeft(1);
		StdOut.println("length" + q.length() + ",size " + q.size());
		q.pushLeft(2);
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.pushRight(3);
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.pushRight(4);
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.popLeft();
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.popLeft();
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.popLeft();
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.popLeft();
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.pushRight(5);
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.pushRight(6);
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.pushRight(7);
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.pushRight(8);
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.popRight();
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.popRight();
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.popRight();
		StdOut.println("size" + q.length() + ",size " + q.size());
		q.popRight();
		StdOut.println("size" + q.length() + ",size " + q.size());
		for (Integer integer : q) {
			StdOut.println(integer);
		}
//		StdOut.println(q.size());

	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ResizingArrayDequeIterator();
	}
	
	private class ResizingArrayDequeIterator implements Iterator<Item>{
		int cur = left;
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
			cur = (cur + 1) % a.length;
			cnt++;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
