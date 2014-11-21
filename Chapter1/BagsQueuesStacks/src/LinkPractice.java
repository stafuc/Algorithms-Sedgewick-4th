import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkPractice<Item> implements Iterable<Item>{
	
	private Node first;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void deleteLast(){
		if(first == null) throw new NoSuchElementException();
		if(first.next == null)	first = null;
		else{
			Node temp = first;
			while(temp.next.next != null){
				temp = temp.next;
			}
			temp.next = null;
		}
	}
	
	public void delete(int k){
		Node pre = null, current = first;
		int cnt = 0;
		while(current != null){
			cnt++;
			if(cnt == k){
				if(pre == null)	first = current.next;
				else{
					pre.next = current.next;
				}
				break;
			}
			pre = current;
			current = current.next;
		}
		if(cnt != k) throw new NoSuchElementException();
	}
	
	public void add(Item item){
		Node node = new Node();
		node.item = item;
		if(first == null)	first = node;
		else{
			Node temp = first;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	public boolean find(String key){
		Node temp = first;
		while(temp != null){
			if(temp.item.equals(key))	return true;
			temp = temp.next;
		}
		return false;
	}
	
	public void remove(String key){
		Node cur = first;
		Node pre = null;
		while(cur != null){
			if(cur.item.equals(key)){
				if(pre == null){
					first = cur.next;
				}else{
					pre.next = cur.next;
				}
			}else{
				pre = cur;
			}
			cur = cur.next;
		}
	}
	
	public void reverse(){
//		Node reverse = null;
//		Node left = first;
//		while(left != null){
//			Node temp = left;
//			left = left.next;
//			temp.next = reverse;
//			reverse = temp;
//		}
//		first = reverse;
		first = reverse(first);
	}
	
	private Node reverse(Node first){
		if(first == null)	return null;
		if(first.next == null)	return first;
		Node second = first.next;
		Node rest = reverse(second);
		second.next = first;
		first.next = null;
		return rest;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkPractice<Integer> l = new LinkPractice<Integer>();
//		l.add(3);
//		l.add(4);
//		l.add(5);
//		l.delete(4);
////		l.deleteLast();
//		for (Integer integer : l) {
//			StdOut.println(integer);
//		}
		
		LinkPractice<String> l = new LinkPractice<String>();
		l.add("34");
		l.add("1234");
		l.add("1234"); 
		l.add("abc");
		l.remove("123");
		l.reverse();
		for (String string : l) {
			StdOut.println(string);
		}
//		StdOut.println(l.find("abc"));

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<Item>{

		Node current = first;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item temp = current.item;
			current = current.next;
			return temp;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
