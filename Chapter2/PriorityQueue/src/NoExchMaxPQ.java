
public class NoExchMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	
	public NoExchMaxPQ() {
		// TODO Auto-generated constructor stub
		pq = (Key[])new Comparable[1];
	}
	
	public void insert(Key v) {
		if(N + 1 == pq.length)	resize(2 * pq.length);
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax() {
		Key max = pq[1];
		exch(1, N);
		pq[N--] = null;
		sink(1);
		if(pq.length > 1 && (N + 1) <= pq.length / 4)	resize(pq.length / 2);
		return max;
	}
	
	private void resize(int M) {
		Key[] t = (Key[])new Comparable[M];
		for (int i = 1; i <= N; i++) {
			t[i] = pq[i];
		}
		pq = t;
	}
	
	private boolean less(Key k1, Key k2) {
		return k1.compareTo(k2) < 0;
	}
	
	private void exch(int i, int j) {
		Key tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = tmp;
	}
	
	private void sink(int i) {
		Key tmp = pq[i];
		while(2 * i <= N){
			int j = 2 * i;
			if(j + 1 <= N && less(pq[j], pq[j + 1]))	++j;
			if(!less(tmp, pq[j]))	break;
			pq[i] = pq[j];
			i = j;
		}
		pq[i] = tmp;
	}
	
	private void swim(int i) {
		Key tmp = pq[i];
		while(i > 1 && less(pq[i / 2], tmp)){
			pq[i] = pq[i / 2];
			i /= 2;
		}
		pq[i] = tmp;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
