
public class DisturbList {
	private Node head;
	private Node tail;
	
	public DisturbList() {
		// TODO Auto-generated constructor stub
		head = tail = null;
	}
	
	public void add(int i) {
		Node n = new Node(i);
		if(tail == null)	head = tail = n;
		else{
			tail.next = n;
			tail = n;
		}
	}
	
	public void show() {
		show(head);
	}
	
	private static class Node{
		public Node(int n) {
			// TODO Auto-generated constructor stub
			this.i = n;
			this.next = null;
		}
		int i;
		Node next;
	}

	public static Node disturb(Node head) {
		return disturb(head, size(head));
	}
	
	private static Node disturb(Node node, int size) {
//		StdOut.println(node.i + " " + size);
		if(size == 1)	return node;
		int m = size / 2;
		int cnt = 0;
		Node n1 = node;
		while(cnt < m){
			n1 = n1.next;
			cnt += 1;
		}
		tail(node, m).next = null;
		tail(n1, size - m).next = null;
		Node h1 = disturb(node, m);
		Node h2 = disturb(n1, size - m);
		return merge(h1, h2, m, size - m);
	}
	
	private static Node merge(Node h1, Node h2, int s1, int s2) {
		Node head = null;
		Node cur = head;
		int c1 = 0, c2 = 0;
		while(c1 < s1 && c2 < s2){
			double p = StdRandom.uniform();
			if(p < 0.5){
				if(head == null)	head = h1;
				else cur.next = h1;
				cur = h1;
				h1 = h1.next;
				++c1;
			}else{
				if(head == null)	head = h2;
				else cur.next = h2;
				cur = h2;
				h2 = h2.next;
				++c2;
			}
			cur.next = null;
		}
		if(c1 < s1){
			if(head == null)	head = h1;
			else cur.next = h1;
		}
		if(c2 < s2){
			if(head == null)	head = h2;
			else cur.next = h2;
		}
		return head;
	}
	
	private static int size(Node n) {
		int s = 0;
		while(n != null){
			++s;
			n = n.next;
		}
		return s;
	}
	
	private static Node tail(Node n, int size) {
		int s = 1;
		while(s < size){
			++s;
			n = n.next;
		}
		return n;
	}
	
	public static void show(Node n) {
		while(n != null){
			StdOut.printf(n.i + " ");
			n = n.next;
		}
		StdOut.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisturbList dl = new DisturbList();
		dl.add(1);
		dl.add(2);
		dl.add(3);
		dl.add(4);
		dl.add(5);
		dl.add(6);
		dl.add(7);
		dl.add(8);
		dl.add(9);
		Node h = disturb(dl.head);
		show(h);
	}

}
