
public class QuickFindUF {

	private int[] id;
	private int count;
	private int visitCnt;
	
	public QuickFindUF(int N) {
		// TODO Auto-generated constructor stub
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
		count = N;
		visitCnt = 0;
	}
	
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if(pID == qID)	return;
		for (int i = 0; i < id.length; i++) {
			++visitCnt;
			if(id[i] == pID){
				id[i] = qID;
				++visitCnt;
			}
		}
		--count;
	}
	
	public int find(int p) {
		++visitCnt;
		return id[p];
	}
	
	public boolean connected(int p, int q){
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
		QuickFindUF qu = new QuickFindUF(N);
//		StopWatch sw = new StopWatch();
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(qu.connected(p, q))	continue;
			qu.union(p, q);
			StdOut.println("id:" + qu.toString());
			StdOut.println("visit cnt:" + qu.visitCount());
			
		}
//		StdOut.printf("%d components, %.3f\n", qu.count, sw.elapsedTime());

	}

}
