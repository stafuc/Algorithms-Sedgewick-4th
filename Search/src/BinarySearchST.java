
public class BinarySearchST <Key extends Comparable<Key>, Value>{
	private Key[] keys;
	private Value[] vals;
	private int N;
	private int cmpCnt;
	
	public BinarySearchST() {
		// TODO Auto-generated constructor stub
		this(1);
	}
	
	public BinarySearchST(int capacity){
		keys = (Key[])new Comparable[capacity];
		vals = (Value[])new Comparable[capacity];
	}
	
	public boolean contain(Key k) {
		for (int i = 0; i < N; i++) {
			cmpCnt++;
			if(keys[i].compareTo(k) == 0)	return true;
		}
		return false;
	}
	
	private void resize(int m) {
		Key[] nkeys = (Key[])new Comparable[m];
		Value[] nvalues = (Value[])new Object[m];
		for (int i = 0; i < N; i++) {
			nkeys[i] = keys[i];
			nvalues[i] = vals[i];
		}
		keys = nkeys;
		vals = nvalues;
	}
	
	public Value get(Key key) {
		if(N == 0)	return null;
		int r = rank(key, 0, N - 1);
		cmpCnt++;
		if(r < N && keys[r].compareTo(key) == 0)	return vals[r];
		return null;
	}
	
	public void put(Key key, Value val) {
		int r = rank(key, 0, N - 1);
		if(r < N && keys[r].compareTo(key) == 0){
			vals[r] = val;
			cmpCnt++;
		}
		else{
			if(N == keys.length)	resize(2 * N);
			for (int i = N; i > r; i--) {
				keys[i] = keys[i - 1];
				vals[i] = vals[i - 1];
			}
			keys[r] = key;
			vals[r] = val;
			N++;
		}
		for (int i = 0; i < N; i++) {
			assert i == rank(select(i), 0, N - 1);
		}
	}
	
	public void delete(Key key) {
		if(N == 0){
			System.out.println("st is empty!");
			return;
		}
		int r = rank(key, 0, N - 1);
		if(r < N && keys[r].compareTo(key) == 0){
			for (int i = r; i < N - 1; i++) {
				keys[i] = keys[i + 1];
				vals[i] = vals[i + 1];
			}
			N--;
		}
		for (int i = 0; i < N; i++) {
			assert i == rank(select(i), 0, N - 1);
		}
	}
	
	public Key floor(Key key) {
		if(N == 0)	return null;
		int r = rank(key, 0, N - 1);
		if(r < N){
			if(keys[r].compareTo(key) == 0)	return key;
			else if(r > 0)	return keys[r - 1];
			else	return null;
		}else	return keys[N - 1];
	}
	
	public Key ceiling(Key key) {
		int r = rank(key, 0, N - 1);
		if(r < N)	return keys[r];
		return null;
	}
	
	public Key select(int k) {
		if(k < 0 || k >= N)	return null;
		return keys[k];
	}
	
	public void delMin() {
		delete(keys[0]);
	}
	
	public void delMax() {
		delete(keys[N - 1]);
	}
	
	public int cmpCnt() {
		return cmpCnt;
	}
	
	public void show() {
		StringBuffer br = new StringBuffer();
		for (int i = 0; i < N; i++) {
			br.append(keys[i]);
		}
		System.out.println(br.toString());
	}
	
	
	private int rank(Key key, int lo, int hi) {
		//left of lo less than key
		if(lo > hi)	return lo;
		int mid = (lo + hi) / 2;
		cmpCnt++;
		int cmp = keys[mid].compareTo(key);
		if(cmp == 0)	return mid;
		if(cmp < 0)	return rank(key, mid + 1, hi);
		else 	return rank(key, lo, mid - 1);
	}
	
	public Iterable<Key> keys() {
		Queue<Key> q = new Queue<Key>();
		for (int i = 0; i < N; i++) {
			q.enqueue(keys[i]);
		}
		return q;
	}
	
	public int size() {
		return N;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchST<String, Integer> sst = new BinarySearchST<String, Integer>(20);
		String s[] = {"E", "B", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
		for (int i = 0; i < s.length; i++) {
			sst.put(s[i], 0);
//			System.out.println(sst.cmpCnt);
		}
		sst.show();
		sst.delMin();
		sst.show();
		sst.delMin();
		sst.delMax();
		sst.show();
//		System.out.println(sst.floor("Z"));
//		System.out.println(sst.ceiling("S"));
//		System.out.println(sst.select(200));
//		sst.delete("E");
//		sst.show();
//		sst.delete("E");
//		sst.show();
//		sst.delete("Q");
//		sst.show();
//		System.out.println(sst.cmpCnt);
	}

}
