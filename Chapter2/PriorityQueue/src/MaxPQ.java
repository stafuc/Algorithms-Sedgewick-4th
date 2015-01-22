import java.util.Arrays;


public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	private Key min = null; 
	
	public MaxPQ() {
		// TODO Auto-generated constructor stub
		pq = (Key[])new Comparable[1];
	}
	
	public MaxPQ(int maxN){
		pq = (Key[])new Comparable[maxN + 1];
	}
	
	public MaxPQ(Key[] k) {
		// TODO Auto-generated constructor stub
		pq = (Key[])new Comparable[k.length + 1];
		System.arraycopy(k, 0, pq, 1, k.length);
		N = pq.length - 1;
//		System.out.println(N);
		for (int i = N / 2; i >= 1; --i) {
			sink(i);
		}
		if(!Ex_2_4_15.isMaxHeap(pq))
			System.out.println("error!");
//		for (int i = 1; i < pq.length; i++) {
//			System.out.print(pq[i] + " ");
//		}
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public int capacity() {
		return pq.length;
	}
	
	public void insert(Key v) {
		if(N + 1 == pq.length)	resize(2 * pq.length);
		pq[++N] = v;
		swim(N);
		if(min == null || v.compareTo(min) < 0)	min = v;
	}
	
	public Key delMax() {
		Key max = pq[1];
		exch(1, N);
		pq[N--] = null;
		sink(1);
		if(pq.length > 1 && N <= pq.length / 4)	resize(pq.length / 2);
		if(N == 0)	min = null;
		return max;
	}
	
	public Key min() {
		return min;
	}
	
	private void resize(int M){
		Key[] t = (Key[])new Comparable[M];
		for (int i = 1; i <= N; i++) {
			t[i] = pq[i];
		}
		pq = t;
	}
	
	private boolean less(int i, int j){
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	private void exch(int i, int j) {
		Key k = pq[i];
		pq[i] = pq[j];
		pq[j] = k;
	}
	
	private void swim(int k) {
		while(k > 1 && less(k / 2, k)){
			exch(k / 2, k);
			k /= 2;
		}
	}
	
	private void sink(int k) {
		while(2 * k <= N){
			int j = 2 * k;
			if(j + 1 <= N && less(j, j + 1))	++j;
			if(!less(k, j))	break;
			exch(k, j);
			k = j;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPQ<Integer> pq = new MaxPQ<Integer>();
		for (int i = 0; i < 100; i++) {
			if(pq.size() > 0 && StdRandom.uniform() < 0.5)	pq.delMax();
			else	pq.insert(i);
			System.out.println(pq.min());
		}
//		int MAX = 10000;
//		for (int N = 100; N < 1e7; N += N) {
//			Integer[] a = new Integer[N];
//			for (int i = 0; i < a.length; i++) {
//				a[i] = StdRandom.uniform(-MAX, MAX);
//			}
//			MaxPQ<Integer> pq = new MaxPQ<Integer>(a);	
//		}
		
	}

}
