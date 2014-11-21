import java.util.Iterator;

import org.omg.CORBA.Current;


public class LinkedBag<Item> implements Iterable<Item> {
	
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;
	private int N;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public void add(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedBag<String> bag = new LinkedBag<String>();
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			bag.add(s);
		}
		
		for (String string : bag) {
			StdOut.println(string);
		}

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new LinkIterator();
	}
	
	private class LinkIterator implements Iterator<Item>{

		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
