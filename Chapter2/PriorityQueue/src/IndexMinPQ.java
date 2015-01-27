
public class IndexMinPQ<Key extends Comparable> {
	private int pq[];	//存储索引
	private int qp[];	//索引在pq中的位置
	private Key[] keys;
	private int N = 0;
	
	public IndexMinPQ() {
		// TODO Auto-generated constructor stub
		pq = new int[100];
		qp = new int[100];
		keys = (Key[])new Comparable[100];
		for (int i = 0; i < qp.length; i++) {
			qp[i] = -1;
		}
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void insert(int i, Key v) {
		pq[++N] = i;
		keys[i] = v;
		swim(N);
	}
	
	public Key min() {
		return keys[pq[1]];
	}
	
	public int indexOfMin() {
		return pq[1];
	}
	
	public void change(int k, Key v) {
		keys[k] = v;
		swim(qp[k]);
		sink(qp[k]);
	}
	
	public void delete(int k) {
		int i = qp[k];
		exch(i, N--);
		swim(i);
		sink(i);
		keys[k] = null;
		qp[k] = -1;
	}
	
	public int delMin() {
		int indexOfMin = pq[1];
		exch(1, N--);
		keys[indexOfMin] = null;
		sink(1);
		return indexOfMin;
	}
	
	private void sink(int i) {
		while(2 * i <= N){
			int j = 2 * i;
			if(j + 1 <= N && less(j + 1, j))	++j;
			if(less(i, j))	break;
			exch(i, j);
			i = j;
		}
	}
	
	private void swim(int i) {
		while(i > 1 && less(i, i / 2)){
			exch(i, i / 2);
			i /= 2;
		}
	}
	
	private boolean less(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
	}
	
	private void exch(int i, int j) {
		int tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = tmp;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IndexMinPQ<Integer> pq = new IndexMinPQ<Integer>();
		pq.insert(1, 3);
		System.out.println(pq.min());
		pq.insert(2, 2);
		System.out.println(pq.min());
		pq.insert(4, 1);
		System.out.println(pq.min());
	}
}
