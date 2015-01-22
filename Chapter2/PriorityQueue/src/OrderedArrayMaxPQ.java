
public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	
	public OrderedArrayMaxPQ(int N){
		pq = (Key[])new Comparable[N];
	}
	
	public void insert(Key v) {
		pq[N++] = v;
		int j = N - 1;
		while(j > 0 && less(j, j - 1)){
			exch(j, j - 1);
			--j;
		}
	}
	
	public Key delMax() {
		Key max = pq[N - 1];
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
