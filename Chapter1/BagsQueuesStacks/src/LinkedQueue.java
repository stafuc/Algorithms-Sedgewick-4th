import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedQueue<Item> implements Iterable<Item> {
	
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;
	private Node last;
	private int N;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public void enqueue(Item item){
		Node oldlast = last;
		last = new Node();
		last.item = item;
		if(isEmpty())	first = last;
		else	oldlast.next = last;
		N++;
	}
	
	public Item dequeue(){
		if(N == 0)	throw new NoSuchElementException();
		Item item = first.item;
		first = first.next;
		if(--N == 0)	last = first;
		return item;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedQueue<String> s = new LinkedQueue<String>();
		while(!StdIn.isEmpty()){
			String str = StdIn.readString();
			if(str.equals("-"))	s.dequeue();
			else	s.enqueue(str);
		}
		for (String string : s) {
			StdOut.println(string);
		}
		
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new LinkedQueueIterator();
	}
	
	private class LinkedQueueIterator implements Iterator<Item>{

		private Node temp = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return temp != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = temp.item;
			temp = temp.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
