import java.util.Iterator;
import java.util.NoSuchElementException;


public class BiDirectionList<Item> implements Iterable<Item>{
	
	private DoubleNode head;
	private DoubleNode tail;
	
	private class DoubleNode{
		Item item;
		DoubleNode pre;
		DoubleNode next;
	}
	
	public void enqueueHead(Item item){
		DoubleNode node = new DoubleNode();
		node.item = item;
		if(head == null){
			head = node;
			tail = node;
		}else{
			node.next = head;
			head.pre = node;
			head = node;
		}
	}
	
	public void enqueueTail(Item item){
		DoubleNode node = new DoubleNode();
		node.item = item;
		if(tail == null){
			head = node;
			tail = node;
		}else{
			tail.next = node;
			node.pre = tail;
			tail = node;
		}
	}
	
	public Item dequeueHead(){
		if(head == null)	throw new NoSuchElementException();
		Item item = head.item;
		head = head.next;
		if(head != null)	head.pre = null;
		else	tail = null;
		return item;
	}
	
	public Item dequeueTail(){
		if(tail == null)	throw new NoSuchElementException();
		Item item = tail.item;
		tail = tail.pre;
		if(tail != null)	tail.next = null;
		else	head = null;
		return item;
	}
	
	private DoubleNode find(Item item){
		DoubleNode temp = head;
		while(temp != null){
			if(temp.item == item)	return temp;
			temp = temp.next;
		}
		return null;
	}
	
	public void enqueueBefore(Item item1, Item item2){
		DoubleNode node = new DoubleNode();
		node.item = item2;
		DoubleNode f = find(item1);
		if(f == null)	throw new NoSuchElementException();
		DoubleNode pre = f.pre;
		node.next = f;
		f.pre = node;
		if(pre != null){
			pre.next = node;
			node.pre = pre;
		}else{
			head = node;
		}
	}
	
	public void enqueueAfter(Item item1, Item item2){
		DoubleNode node = new DoubleNode();
		node.item = item2;
		DoubleNode f = find(item1);
		if(f == null)	throw new NoSuchElementException();
		DoubleNode after = f.next;
		f.next = node;
		node.pre = f;
		if(after != null){
			after.pre = node;
			node.next = after;
		}else{
			tail = node;
		}
	}
	
	public void dequeue(Item item){
		DoubleNode f = find(item);
		if(f == null)	throw new NoSuchElementException();
		if(f.pre != null){
			f.pre.next = f.next;
		}else{
			head = f.next;
			if(head == null)	tail = null;
		}
		
		if(f.next != null){
			f.next.pre = f.pre;
		}else{
			tail = f.pre;
			if(tail == null)	head = null;
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiDirectionList<Integer> l = new BiDirectionList<Integer>();
		l.enqueueHead(3);
		l.enqueueHead(4);
		l.enqueueTail(2);
		l.enqueueTail(1);
		l.dequeue(4);
		l.dequeue(3);
		l.dequeue(2);
		l.dequeue(1);
		l.dequeue(1);
//		l.enqueueBefore(5, 5);
//		l.enqueueAfter(0, 5);
//		l.dequeueTail();
//		l.dequeueHead();
//		l.dequeueTail();
//		l.dequeueTail();
		for (Integer integer : l) {
			StdOut.println(integer);
		}

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new BiDirectionListIterator();
	}
	
	private class BiDirectionListIterator implements Iterator<Item>{

		DoubleNode cur = head;
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
