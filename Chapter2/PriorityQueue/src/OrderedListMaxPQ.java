
public class OrderedListMaxPQ<Key extends Comparable<Key>>{

	private Node<Key> head;
	
	private static class Node<Key>{
		Key v;
		Node<Key> next;
	}
	
	public void insert(Key v) {
		Node<Key> pre = null, cur = head;
		while(cur != null && v.compareTo(cur.v) < 0){
			pre = cur;
			cur = cur.next;
		}
		Node<Key> n = new Node<Key>();
		n.v = v;
		if(pre == null){
			n.next = head;
			head = n;
		}else{
			n.next = pre.next;
			pre.next = n;
		}
	}
	
	public Key delMax() {
		Key max = head.v;
		head = head.next;
		return max;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
