
public class PathCprWeightedQuickUnionUF {
	
	private int id[];
	private int sz[];
	private int count;
	private int visitCnt;
	
	public PathCprWeightedQuickUnionUF(int N) {
		// TODO Auto-generated constructor stub
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)	id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++)	sz[i] = 1;
		visitCnt = 0;
	}
	
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if(pID == qID)	return;
		visitCnt += 2;
		if(sz[pID] < sz[qID]){
			id[pID] = qID;
			sz[qID] += sz[pID];
			visitCnt += 3;
		}else{
			id[qID] = pID;
			sz[pID] += sz[qID];
			visitCnt += 3;
		}
		count--;
	}
	
	public int find(int p) {
		Stack<Integer> s = new Stack<Integer>();
		++visitCnt;
		while(id[p] != p){
			s.push(p);
			p = id[p];
			visitCnt += 2;
		}
		while(!s.isEmpty()){
			id[s.pop()] = p;
			++visitCnt;
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
		return visitCnt;
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
		PathCprWeightedQuickUnionUF pwqu = new PathCprWeightedQuickUnionUF(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(pwqu.connected(p, q))	continue;
			pwqu.union(p, q);
			StdOut.println("id:" + pwqu.toString());
			StdOut.println("visit cnt:" + pwqu.visitCount());
		}

	}

}
