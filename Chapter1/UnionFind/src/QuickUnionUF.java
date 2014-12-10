
public class QuickUnionUF {

	private int[] id;
	private int count;
	private int visitCount;
	
	public QuickUnionUF(int N) {
		// TODO Auto-generated constructor stub
		id = new int[N];
		count = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
		visitCount = 0;
	}
	
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if(pID == qID)	return;
		id[pID] = qID;
		--count;
		++visitCount;
	}
	
	public int find(int p) {
		++visitCount;
		while(id[p] != p){
			p = id[p];
			visitCount += 2;
		}
		return p;
	}
	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	public int count() {
		return count;
	}
	
	public int visitCount() {
		return visitCount;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = StdIn.readInt();
//		StdOut.println(N);
		QuickUnionUF qu = new QuickUnionUF(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(qu.connected(p, q))	continue;
			qu.union(p, q);
//			StdOut.println("id:" + qu.toString());
			StdOut.println("visit cnt:" + qu.visitCount());
		}
//		StdOut.printf("%d components\n", qu.count);

	}

}
