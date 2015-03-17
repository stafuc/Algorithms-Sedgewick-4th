
public class BST<Key extends Comparable<Key>, Value> {
	private Node root;
	public int cmpCnt;
	
	private class Node{
		private Key key;
		private Value val;
		private Node left, right;
		private int N;
		private int h;
		private int length;
		public Node(Key key, Value val, int N, int h, int length){
			this.key=key;
			this.val= val;
			this.N = N;
			this.h= h;
			this.length = length;
		}
	}
	
	public int size(){
		return size(root);
	}
	
	private int size(Node x){
		if(x == null)	return 0;
		return x.N;
	}
	
	public int height(){
		return height(root);
	}
	
	private int height(Node x){
		if(x == null)	return 0;
		return x.h;
	}
	
	public double avgCompares() {
		return length(root) / 1.0 / size() + 1;
	}
	
	private int length(Node x){
		if(x == null)	return 0;
		return x.length;
	}
	
	public Value get(Key key){
		return get(root, key);
	}
	
	private Value get(Node x, Key key) {
		if(x== null)	return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)	return	get(x.left, key);
		else if(cmp > 0)	return	get(x.right, key);
		else	return x.val;
	}
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	
	private Node put(Node x, Key key, Value val){
		if(x == null)	return	new Node(key, val, 1, 1, 0);
		int cmp= key.compareTo(x.key);
		cmpCnt++;
		if(cmp < 0)	x.left = put(x.left, key, val);
		else if(cmp > 0)	x.right = put(x.right, key, val);
		else	x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		x.h = Math.max(height(x.left), height(x.right)) + 1;
		x.length = length(x.left) + length(x.right) + size(x) - 1;
		return x;
	}
	
	public Key min() {
		return min(root).key;
	}
	
	private Node min(Node x) {
		if(x == null)	return null;
		if(x.left == null)	return x;
		return min(x.left);
	}
	
	public Key max() {
		return max(root).key;
	}
	
	private Node max(Node x) {
		if(x == null)	return null;
		if(x.right == null)	return x;
		return max(x.right);
	}
	
	public Key floor(Key key) {
		Node x = floor(root, key);
		if(x == null)	return null;
		return x.key;
	}
	
	private Node floor(Node x, Key key) {
		if(x == null)	return null;
		int cmp = key.compareTo(x.key);
		if(cmp == 0)	return x;
		else if(cmp < 0)	return	floor(x.left, key);
		else{
			Node t = floor(x.right, key);
			if(t != null)	return t;
			return x;
		}
	}
	
	public Key ceiling(Key key) {
		return ceiling(root, key).key;
	}
	
	private Node ceiling(Node x, Key key) {
		if(x == null)	return null;
		int cmp= key.compareTo(x.key);
		if(cmp == 0)	return x;
		if(cmp > 0)	return ceiling(x.right, key);
		Node t = ceiling(x.left, key);
		if(t != null)	return t;
		return x;
	}
	
	public Key select(int k) {
		Node t= select(root, k);
		if(t == null)	return null;
		return	t.key;
	}
	
	private Node select(Node x, int k) {
		if(x == null)	return null;
		int t = size(x.left);
		if(t == k)	return x;
		else if(t > k)	return	select(x.left, k);
		else	return select(x.right, k - t - 1);
	}
	
	public int rank(Key key) {
		return rank(root, key);
	}
	
	//number of nodes less than key
	private int rank(Node x, Key key) {
		if(x == null)	return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)	return rank(x.left, key);
		else if(cmp > 0)	return size(x.left) + 1 + rank(x.right, key);
		else	return size(x.left);
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node x) {
		if(x == null)	return null;
		if(x.left == null)	return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		x.h = Math.max(height(x.left), height(x.right)) + 1;
		x.length = length(x.left) + length(x.right) + size(x) - 1;
		return x;
	}
	
	public void deleteMax() {
		root = deleteMax(root);
	}
	
	private Node deleteMax(Node x) {
		if(x == null)	return null;
		if(x.right == null)	return x.left;
		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		x.h = Math.max(height(x.left), height(x.right)) + 1;
		x.length = length(x.left) + length(x.right) + size(x) - 1;
		return x;
	}
	
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key) {
		if(x == null)	return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0)	x.left = delete(x.left, key);
		else if(cmp > 0)	x.right = delete(x.right, key);
		else{
			if(x.left == null)	return x.right;
			else if(x.right == null)	return x.left;
			else{
				Node t= x;
				x = min(t.right);
				x.right = deleteMin(t.right);
				x.left= t.left;
			}
		}
		x.N= size(x.left) + size(x.right) + 1;
		x.h = Math.max(height(x.left), height(x.right)) + 1;
		x.length = length(x.left) + length(x.right) + size(x) - 1;
		return x;
	}
	
	public Iterable<Key> keys() {
		return keys(min(), max());
	}
	
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> q = new Queue<Key>();
		keys(root, q, lo, hi);
		return q;
	}
	
	private void keys(Node x, Queue<Key> q, Key lo, Key hi) {
		if(x == null)	return;
		int cmp1 = lo.compareTo(x.key), cmp2 = hi.compareTo(x.key);
		if(cmp1 < 0)	keys(x.left, q, lo, hi);
		if(cmp1 <= 0 && cmp2 >= 0)	q.enqueue(x.key);
		if(cmp2 > 0)	keys(x.right, q, lo, hi);
	}
	
	public void show() {
		Iterable<Key> l = this.keys();
		for (Key k : l) {
			System.out.printf(k + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<String, Integer> t = new BST<>();
		String[] s = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
		for (int i = 0; i < s.length; i++) {
			t.put(s[i], i);
		}
		t.show();
		t.delete("S");
		t.show();
		t.deleteMin();
		t.show();
		t.deleteMax();
		t.show();
		
//		System.out.println(t.avgCompares());
	}

}
