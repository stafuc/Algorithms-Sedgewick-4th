
public class BinarySearchST <Key extends Comparable<Key>, Value>{
	private Key[] keys;
	private Value[] vals;
	private int N;
	private int cmpCnt;
	
	public BinarySearchST(int capacity){
		keys = (Key[])new Comparable[capacity];
		vals = (Value[])new Comparable[capacity];
	}
	
	public Value get(Key key) {
		if(N == 0)	return null;
		int r = rank(key, 0, N - 1);
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
			for (int i = N; i > r; i--) {
				keys[i] = keys[i - 1];
				vals[i] = vals[i - 1];
			}
			keys[r] = key;
			vals[r] = val;
			N++;
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
		System.out.println(sst.floor("Z"));
//		sst.delete("E");
//		sst.show();
//		sst.delete("E");
//		sst.show();
//		sst.delete("Q");
//		sst.show();
//		System.out.println(sst.cmpCnt);
	}

}
