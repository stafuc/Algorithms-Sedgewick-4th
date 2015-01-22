
public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N = 0;
	
	public UnorderedArrayMaxPQ(int N) {
		// TODO Auto-generated constructor stub
		pq = (Key[])new Comparable[N];
	}
	
	public void insert(Key v) {
		pq[N++] = v;
	}
	
	public Key delMax() {
		int index = 0;
		for (int i = 1; i < N; i++) {
			if(less(index, i))	index = i;
		}
		Key max = pq[index];
		for (int i = index; i < N - 1; i++) {
			pq[i] = pq[i + 1];
		}
		pq[--N] = null;
		return max;
	}
	private boolean less(int i, int j){
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j) {
		Key k = pq[i];
		pq[i] = pq[j];
		pq[j] = k;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
