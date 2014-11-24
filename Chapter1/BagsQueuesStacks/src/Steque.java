import java.util.Iterator;
import java.util.NoSuchElementException;


public class Steque<Item> implements Iterable<Item>{
	
	private Node head;
	private Node tail;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void push(Item item){
		Node node = new Node();
		node.item = item;
		if(head == null){
			head = tail = node;
		}else{
			node.next = head;
			head = node;
		}
	}
	
	public Item pop(){
		if(head == null)	throw new NoSuchElementException();
		Item temp = head.item;
		head = head.next;
		if(head == null)	tail = null;
		return temp;
	}
	
	public void enqueue(Item item){
		Node node = new Node();
		node.item = item;
		if(tail == null)	head = tail = node;
		else{
			tail.next = node;
			tail = node;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Steque<Integer> s = new Steque<Integer>();
		s.push(3);
		s.push(4);
		s.push(1);
		s.enqueue(5);
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		
		for (Integer integer : s) {
			StdOut.println(integer);
		}

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new StequeIterator();
	}
	
	private class StequeIterator implements Iterator<Item>{

		Node cur = head;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cur != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item temp = cur.item;
			cur = cur.next;
			return temp;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
