import java.util.Iterator;
import java.util.NoSuchElementException;


public class GeneralizedQueueList<Item> implements Iterable<Item>{

	private Node head;
	private Node tail;
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public void insert(Item x){
		Node node = new Node();
		node.item = x;
		if(tail == null)	head = tail = node;
		else{
			tail.next = node;
			tail = node;
		}
		N++;
	}
	
	public Item delete(int k){
		if(k > N)	throw new NoSuchElementException();
		int index = 1;
		Node pre = null, cur = head; 
		while(index < k){
			pre = cur;
			cur = cur.next;
			index++;
		}
		Item item = cur.item;
		if(cur == head){
			head = head.next;
			if(head == null)	tail = null;
		}else if(cur == tail){
			tail = pre;
			if(tail == null)	head = null;
			else tail.next = null;
		}else	pre.next = cur.next;
		N--;
		return item;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralizedQueueList<Integer> q = new GeneralizedQueueList<Integer>();
		q.insert(3);
		q.insert(4);
		q.insert(5);
		q.insert(6);
//		q.delete(2);
//		q.delete(2);
		q.delete(2);
		q.delete(1);
//		q.delete(1);
		for (Integer integer : q) {
			StdOut.println(integer);
		}
		

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new GeneralizedQueueListIterator();
	}
	
	private class GeneralizedQueueListIterator implements Iterator<Item>{

		Node cur = head;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cur != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item ret = cur.item;
			cur = cur.next;
			return ret;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
