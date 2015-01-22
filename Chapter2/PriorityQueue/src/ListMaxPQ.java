import javax.print.attribute.standard.Fidelity;


public class ListMaxPQ<Key extends Comparable<Key>> {

	private static class Node<Key>{
		Key v;
		Node left;
		Node right;
		Node parent;
	}
	
	private Node<Key> head;
	private int N = 0;
	
	public int size() {
		return N;
	}
	
	public void insert(Key v) {
		++N;
		Node<Key> n = new Node<Key>();
		n.v = v;
		if(N == 1)	head = n;
		else{
			Node<Key> p = find(N / 2);
			if(N % 2 == 0)	p.left = n;
			else	p.right = n;
			n.parent = p;
			swim(n);
		}
	}
	
	public Key delMax() {
		Key v = head.v;
		Node<Key> tail = find(N);
		exch(head, tail);
		if(N > 1){
			if(N % 2 == 0)	tail.parent.left = null;
			else	tail.parent.right = null;
			tail.parent = null;	
		}
		--N;
		sink(head);
		return v;
	}
	
	private void sink(Node<Key> n) {
		while(n.left != null){
			Node<Key> tmp = n.left;
			if(n.right != null && less(tmp, n.right))	tmp = n.right;
			if(!less(n, tmp))	break;
			exch(n, tmp);
			n = tmp;
		}
	}
	
	private void swim(Node<Key> n) {
		while(n.parent != null && less(n.parent, n)){
			exch(n.parent, n);
			n = n.parent;
		}
	}
	
	private boolean less(Node<Key> n1, Node<Key> n2) {
		return n1.v.compareTo(n2.v) < 0;
	}
	
	private void exch(Node<Key> n1, Node<Key> n2){
		Key tmp = n1.v;
		n1.v = n2.v;
		n2.v = tmp;
	}	
	
	private Node<Key> find(int N) {
		Stack<Integer> s = new Stack<Integer>();
		while(N > 1){
			s.push(N % 2);
			N = (N >> 1);
		}
		Node<Key> cur = head;
		while(!s.isEmpty()){
			if(s.pop() == 0)	cur = cur.left;
			else	cur = cur.right;
		}
		return cur;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListMaxPQ<Integer> pq = new ListMaxPQ<>();
		for (int i = 0; i < 10; i++) {
			pq.insert(i);
			System.err.println(pq.size());
		}
	}

}
