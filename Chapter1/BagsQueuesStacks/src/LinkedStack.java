import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedStack<Item> implements Iterable<Item> {
	
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;
	private int N;
	private int pushCnt;
	private int popCnt;
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public void push(Item item){
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
		pushCnt++;
	}
	
	public Item pop(){
		if(N == 0) throw new NoSuchElementException();
		Item temp = first.item;
		first = first.next;
		N--;
		popCnt++;
		return temp;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStack<String> s = new LinkedStack<String>();
		while(!StdIn.isEmpty()){
			String str = StdIn.readString();
			if(str.equals("-"))	s.pop();
			else	s.push(str);
		}
		
		for (String string : s) {
			StdOut.println(string);
			s.push("fuck");
		}


	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new LinkedStackIterator();
	}
	
	private class LinkedStackIterator implements Iterator<Item>{

		private Node temp = first;
		private int push = pushCnt;
		private int pop = popCnt;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(push != pushCnt || pop != popCnt)	throw new ConcurrentModificationException();
			return temp != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(push != pushCnt || pop != popCnt)	throw new ConcurrentModificationException();
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
