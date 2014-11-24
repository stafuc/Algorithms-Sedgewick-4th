import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedDeque<Item> implements Iterable<Item>{
	
	Node left;
	Node right;
	int N;
	
	private class Node{
		Item item;
		Node next;
		Node pre;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	void pushLeft(Item item){
		Node node = new Node();
		node.item = item;
		if(left == null)	left = right = node;
		else{
			node.next = left;
			left.pre = node;
			left = node;
		}
		N++;
	}
	
	void pushRight(Item item){
		Node node = new Node();
		node.item = item;
		if(right == null)	left = right = node;
		else{
			node.pre = right;
			right.next = node;
			right = node;
		}
		N++;
	}
	
	Item popLeft(){
		if(left == null)	throw new NoSuchElementException();
		Item temp = left.item;
		left = left.next;
		if(left == null)	right = null;
		else{
			left.pre = null;
		}
		N--;
		return temp;
	}
	
	Item popRight(){
		if(right == null)	throw new NoSuchElementException();
		Item temp = right.item;
		right = right.pre;
		if(right == null)	left = null;
		else{
			right.next = null;
		}
		N--;
		return temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedDeque<Integer> q = new LinkedDeque<Integer>();
		q.pushLeft(3);
		q.pushLeft(4);
		q.pushRight(1);
		q.pushRight(2);
//		StdOut.println(q.size());
		for (Integer integer : q) {
			StdOut.println(integer);
		}

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new LinkedDequeIterator();
	}
	
	
	private class LinkedDequeIterator implements Iterator<Item>{

		Node cur = left;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cur != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = cur.item;
			cur = cur.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
