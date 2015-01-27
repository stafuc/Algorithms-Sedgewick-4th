
public class QuickInsertMinPQ<Key extends Comparable> {
	private Key[] pq;
	private int N = 0;
	public QuickInsertMinPQ() {
		// TODO Auto-generated constructor stub
		pq = (Key[])new Comparable[1];
	}
	
	public void insert(Key v) {
		if(N + 1 == pq.length)	resize(2 * pq.length);
		pq[++N] = v;
		swim(N);
//		show();
	}
	
	public void show() {
		String s = "";
		for (int i = 1; i <= N; i++) {
			s += pq[i] + " ";
		}
		System.out.println(s);
	}
	
	private void sink(int i) {
		Key tmp = pq[i];
		while(2 * i <= N){
			int j = 2 * i;
			if(j + 1 <= N && less(pq[j + 1], pq[j]))	++j;
			if(less(tmp, pq[j]))	break;
			pq[i] =	pq[j];
			i = j;
		}
		pq[i] = tmp;
	}
	
	private void swim(int i) {
		Stack<Integer> s = new Stack<Integer>();
		Key tmp = pq[i];
		int it = i;
		i /= 2;
		while(i > 0){
			s.push(i);
			i /= 2;
		}
		int[] index = new int[s.size() + 1];
		for (int j = 0; j < index.length - 1; j++) {
			index[j] = s.pop();
		}
		index[index.length - 1] = it;
		int lo = 0, hi = index.length - 2;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(tmp.compareTo(pq[index[mid]]) < 0)	hi = mid - 1;
			else if(tmp.compareTo(pq[index[mid]]) == 0){
				lo = mid;
				break;
			}
			else	lo = mid + 1;
		}
		for (int j = index.length - 1; j > lo; j--) {
			pq[index[j]] = pq[index[j - 1]];
		}
		pq[index[lo]] = tmp;
	}
	
	
	
	private void resize(int M){
		Key[] t = (Key[])new Comparable[M];
		for (int i = 1; i <= N; i++) {
			t[i] = pq[i];
		}
		pq = t;
	}

	private boolean less(Comparable u, Comparable v){
		return u.compareTo(v) < 0;
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
		QuickInsertMinPQ<Integer> q = new QuickInsertMinPQ<Integer>();
		q.insert(3);
		q.insert(4);
		q.insert(5);
		q.insert(1);
		q.insert(0);
		q.insert(2);
		

	}

}
