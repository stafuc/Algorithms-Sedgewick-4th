
public class WeightedQuickUnionUF {

	private int id[];
	private int sz[];
	private int count;
	private int visitCount;
	
	public WeightedQuickUnionUF(int N) {
		// TODO Auto-generated constructor stub
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)	id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++)	sz[i] = 1;
		visitCount = 0;
	}
	
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if(pID == qID)	return;
		visitCount += 2;
		if(sz[pID] < sz[qID]){
			id[pID] = qID;
			sz[qID] += sz[pID];
			visitCount += 3;
		}else{
			id[qID] = pID;
			sz[pID] += sz[qID];
			visitCount += 3;
		}
		count--;
	}
	
	public int find(int p) {
		++visitCount;
		while(id[p] != p){
			p = id[p];
			visitCount += 2;
		}
		return p;
	}
	
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	public int count() {
		return count;
	}
	
	public int visitCount() {
		return visitCount;
	}
	
	public String toString() {
		String s = "";
		for (int i : id) {
			s += i + " ";
		}
		return s;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = StdIn.readInt();
//		StdOut.println(N);
		WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(wqu.connected(p, q))	continue;
			wqu.union(p, q);
//			StdOut.println("id:" + wqu.toString());
//			StdOut.println("visit cnt:" + wqu.visitCount());
		}
		StdOut.printf("%d components\n", wqu.count);

	}

}
