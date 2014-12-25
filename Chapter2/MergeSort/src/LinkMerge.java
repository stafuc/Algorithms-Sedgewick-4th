
public class LinkMerge {
	private static class Node{
		Comparable c;
		Node next = null;
	}
	
	public static Node merge(Node n1, Node n2) {
		Node pre = null;
		Node h1 = n1, h2 = n2;
		Node head = null;
		while(h1 != null && h2 != null){
			if(less(h1.c, h2.c)){
				if(pre == null)
					head = h1;
				else	pre.next = h1;
				pre = h1;
				h1 = h1.next;
			}else{
				if(pre == null)	head = h2;
				else pre.next = h2;
				pre = h2;
				h2 = h2.next;
			}
		}
		if(h1 != null){
			if(pre == null)	head = h1;
			else pre.next = h1;
		}
		if(h2 != null){
			if(pre == null)	head = h2;
			else pre.next = h2;
		}
		return head;
	}
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(), n2 = new Node(), n3 = new Node(), n4 = new Node(), n5 = new Node();
		n1.c = 1;
		n2.c = 3;
		n3.c = 5;
		n1.next = n2;
		n2.next = n3;
		n4.c = 2;
		n5.c = 4;
		n4.next = n5;
		Node n = merge(n1, n4);
		while(n != null){
			StdOut.printf(n.c + " ");
			n = n.next;
		}
		StdOut.println();
	}

}
