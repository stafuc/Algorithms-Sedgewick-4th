
public class BST_No_Recursive<Key extends Comparable<Key>, Value> {
	private Node root;
	
	private class Node{
		Key key;
		Value val;
		Node left;
		Node right;
		int size;
		
		public Node(Key key, Value val) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.val = val;
		}
	}
	
	public Value get(Key key) {
		Node t = root;
		while(t != null){
			int cmp = key.compareTo(t.key);
			if(cmp < 0)	t= t.left;
			else if(cmp > 0)	t = t.right;
			else	return t.val;
		}
		return null;
	}
	
	public void put(Key key, Value val){
		Node p = null, t = root;
		int flag = 0;
		while(t != null){
			int cmp = key.compareTo(t.key);
			if(cmp < 0){
				p = t;
				t = t.left;
				flag = 0;
			}else if(cmp > 0){
				p = t;
				t = t.right;
				flag = 1;
			}else{
				t.val = val;
				return;
			}
		}
		if(p == null)	root = new Node(key, val);
		else{
			if(flag == 0)	p.left = new Node(key, val);
			else	p.right = new Node(key, val);	
		}
		t = root;
		while(t != null){
			t.size += 1;
			int cmp = key.compareTo(t.key);
			if(cmp == 0)	break;
			else if(cmp < 0)	t = t.left;
			else	t = t.right;
		}
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node x) {
		if(x == null)	return 0;
		return x.size;
	}
	
	public Key min() {
		Node t = min(root);
		if(t == null)	return null;
		return t.key;
	}
	
	private Node min(Node x) {
		Node t = x;
		while(t != null){
			if(t.left == null)	break;
			t = t.left;
		}
		return t;
	}
	
	public Key max() {
		Node t = max(root);
		if(t == null)	return null;
		return t.key;
	}
	
	private Node max(Node x) {
		Node t = x;
		while(t != null){
			if(t.right == null)	break;
			t = t.right;
		}
		return t;
	}
	
	public Key floor(Key key) {
		Node t = floor(root, key);
		if(t == null)	return null;
		return t.key;
	}
	
	private Node floor(Node x, Key key){
		Node t = null;
		Node r = x;
		while(r != null){
			int cmp = key.compareTo(r.key);
			if(cmp == 0)	return r;
			else if(cmp < 0)	r = r.left;
			else{
				t = r;
				r = r.right;
			}
		}
		return t;
	}
	
	public Key ceiling(Key key) {
		Node t = ceiling(root, key);
		if(t == null)	return null;
		return t.key;
	}
	
	private Node ceiling(Node x, Key key) {
		Node t = null;
		Node r = x;
		while(r != null){
			int cmp = key.compareTo(r.key);
			if(cmp == 0)	return r;
			else if(cmp > 0)	r = r.right;
			else if(cmp < 0){
				t = r;
				r = r.left;
			}
		}
		return t;
	}
	
	public int rank(Key key) {
		return rank(root, key);
	}
	
	private int rank(Node x, Key key) {
		int t = 0;
		Node r = x;
		while(r != null){
			int cmp = key.compareTo(r.key);
			if(cmp == 0)	return t + size(r.left);
			else if(cmp < 0)	r = r.left;
			else{
				t += size(r.left) + 1;
				r = r.right;
			}
		}
		return t;
	}
	
	public Key select(int k) {
		Node t = select(root, k);
		if(t == null)	return null;
		return t.key;
	}
	
	private Node select(Node x, int k) {
		int t = k;
		Node r = x;
		while(r != null){
			int s = size(r.left);
			if(s == t)	return r;
			else if(s > t)	r = r.left;
			else{
				t -= s + 1;
				r = r.right;
			}
		}
		return null;
	}
	
	public Iterable<Key> keys() {
		Queue<Key> q = new Queue<Key>();
		Node x = root;
		Stack<Node> s = new Stack<Node>();
		while(x != null || !s.isEmpty()){
			if(x != null){
				s.push(x);
				x = x.left;
			}else{
				x = s.pop();
				q.enqueue(x.key);
				x = x.right;
			}
		}
		return q;
	}
	
	
	public void show() {
		Iterable<Key> s = keys();
		for (Key key : s) {
			System.out.printf(key + " ");
		}
		System.out.println();
	}
	
	public void showSize() {
		showSize(root);
	}
	
	private void showSize(Node x) {
		if(x == null)	return;
		showSize(x.left);
		System.out.println(x.key + " " + x.size);
		showSize(x.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST_No_Recursive<String, Integer> t = new BST_No_Recursive();
		String[] s = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
		for (int i = 0; i < s.length; i++) {
			t.put(s[i], i);
		}
		t.show();
//		t.showSize();
//		System.out.println(t.min());
//		System.out.println(t.max());
//		System.out.println(t.floor("Z"));
//		System.out.println(t.ceiling("B"));
//		System.out.println(t.ceiling("A"));
//		System.out.println(t.size());
//		System.out.println(t.rank("Y"));
		System.out.println(t.select(6));
	}

}
