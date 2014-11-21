import java.util.Iterator;
import java.util.NoSuchElementException;


public class CycleLinkedQueue<Item> implements Iterable<Item>{
	
	private Node last;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void enqueue(Item item){
		Node n = new Node();
		n.item = item;
		if(last == null){
			last = n;
			last.next = last;
		}
		else{
			Node oldlast = last;
			last = n;
			last.next = oldlast.next;
			oldlast.next = last;
		}
	}
	
	public Item dequeue(){
		if(last == null)	throw new NoSuchElementException();
		Item item = last.next.item;
		if(last.next == last){
			last = null;
		}else{
			last.next = last.next.next;
		}
		return item;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CycleLinkedQueue<Integer> q = new CycleLinkedQueue<Integer>();
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(8);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		for (Integer integer : q) {
			StdOut.println(integer);
		}
		

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new CycledLinkedQueueIterator();
	}
	
	private class CycledLinkedQueueIterator implements Iterator<Item>{

		Node start = (last == null ? null : last.next);
		Node cur = start;
		int cnt = 1;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return cur != null && cnt != 2;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = cur.item;
			cur = cur.next;
			if(cur == start)	cnt++;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
