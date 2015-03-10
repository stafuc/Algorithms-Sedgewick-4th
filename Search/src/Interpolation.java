
public class Interpolation{
	private int[] keys;
	private int[] vals;
	private int N;
	private int cmpCnt;
	
	public Interpolation() {
		// TODO Auto-generated constructor stub
		this(1);
	}
	
	public Interpolation(int capacity){
		keys = new int[capacity];
		vals = new int[capacity];
	}
	
	public boolean contain(int k) {
		for (int i = 0; i < N; i++) {
			cmpCnt++;
			if(keys[i] == k)	return true;
		}
		return false;
	}
	
	private void resize(int m) {
		int[] nkeys = new int[m];
		int[] nvalues = new int[m];
		for (int i = 0; i < N; i++) {
			nkeys[i] = keys[i];
			nvalues[i] = vals[i];
		}
		keys = nkeys;
		vals = nvalues;
	}
	
	public int get(int key) {
		if(N == 0)	return -1;
		int r = rank(key, 0, N - 1);
		cmpCnt++;
		if(r < N && keys[r] == key)	return vals[r];
		return -1;
	}
	
	public void put(int key, int val) {
		int r = rank(key, 0, N - 1);
		if(r < N && keys[r] == key){
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
	}
	
	public void delete(int key) {
		if(N == 0){
			System.out.println("st is empty!");
			return;
		}
		int r = rank(key, 0, N - 1);
		if(r < N && keys[r] == key){
			for (int i = r; i < N - 1; i++) {
				keys[i] = keys[i + 1];
				vals[i] = vals[i + 1];
			}
			N--;
			if(N > 0 && N <= keys.length / 4)	resize(keys.length / 2);
		}
	}
	
	public int floor(int key) {
		if(N == 0)	return -1;
		int r = rank(key, 0, N - 1);
		if(r < N){
			if(keys[r] == key)	return key;
			else if(r > 0)	return keys[r - 1];
			else	return -1;
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
	
	
	private int rank(int key, int lo, int hi) {
		//left of lo less than key
		System.out.println(key + " " + lo + " " + hi);
		if(lo > hi)	return lo;
		int mid = (int)(lo + (key - keys[lo]) * 1.0 / (keys[hi] - keys[lo]) * (hi - lo));
		if(mid < lo)	mid = lo;
		if(mid > hi)	mid = hi;
		cmpCnt++;
		int cmp = keys[mid] - key;
		if(cmp == 0)	return mid;
		if(cmp < 0)	return rank(key, mid + 1, hi);
		else 	return rank(key, lo, mid - 1);
	}
	
	public Iterable<Integer> keys() {
		Queue<Integer> q = new Queue<Integer>();
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
		Interpolation st = new Interpolation();
		st.put(1, 1);
		st.put(2, 2);
		st.put(100, 100);
		st.put(200, 200);
		st.get(300);
//		BinarySearchST<Integer, Integer> st2 = new BinarySearchST<>();
//		for (int i = 0; i < 20; i++) {
//			int k = StdRandom.uniform(10000);
//			System.out.println(k);
//			st.put(k, k * 100);
////			st2.put(k, k * 100);
//		}
		
//		for(Integer i : st2.keys()){
//			System.out.printf(i + ",");
//		}
//		System.out.println();
//		for(int i = 0; i < 100; i++){
//			int k = StdRandom.uniform(100);
//			if(st.contain(k)){
//				st.get(k);
////				st2.get(k);
//			}
//		}
//		System.out.println(st.cmpCnt + " " + st2.cmpCnt());

	}

}
