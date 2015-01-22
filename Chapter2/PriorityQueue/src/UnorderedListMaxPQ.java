
public class UnorderedListMaxPQ<Key extends Comparable<Key>> {

	private Node<Key> head;
	
	private static class Node<Key>{
		Key v;
		Node next;
	}
	
	public void insert(Key v){
		Node<Key> n = new Node<Key>();
		n.v = v;
		n.next = head;
		head = n;
	}
	
	public Key delMax() {
		Node<Key> maxPre = null;
		Key max = head.v;
		Node<Key> cur = head.next, pre = head;
		while(cur != null){
			if(max.compareTo(cur.v) < 0){
				max = cur.v;
				maxPre = pre;
			}
			pre = cur;
			cur = cur.next;
		}
		if(maxPre != null)	maxPre.next = maxPre.next.next;
		else	head = head.next;
		return max;
	}
	
	public void show(){
		Node<Key> cur = head;
		while(cur != null){
			System.out.print(cur.v + "->");
			cur = cur.next;
		}
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
