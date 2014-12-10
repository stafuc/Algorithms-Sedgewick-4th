
public class ResizingWeightedQuickUnionUF {

	private int id[];
	private int sz[];
	
	/** The count. current number of union*/
	private int count;
	
	/** The visit count. current times of visiting arrays*/
	private int visitCount;
	
	/** The n. current number of nodes*/
	private int N;
	
	public ResizingWeightedQuickUnionUF() {
		// TODO Auto-generated constructor stub
		count = 1;
		N = -1;
		id = new int[1];
		id[0] = 0;
		sz = new int[1];
		sz[0] = 1;
		visitCount = 0;
	}
	
	private void resize(int size) {
		int[] nid = new int[size];
		for (int i = 0; i < size; i++) {
			if(i < id.length){
				nid[i] = id[i];
				visitCount += 2;
			}
			else{
				nid[i] = i;
				++visitCount;
			}
		}
		
		int[] nsz = new int[size];
		for (int i = 0; i < size; i++) {
			if(i < sz.length){
				nsz[i] = sz[i];
				visitCount += 2;
			}
			else{
				nsz[i] = 1;
				++visitCount;
			}
		}
		
		count += size - id.length;
		id = nid;
		sz = nsz;
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
		if(p > this.N)	this.N = p;
		int len = id.length;
		if(p >= len){
			while(p >= len)	len *= 2;
			resize(len);	
		}
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
//		StdOut.println(count);
		return count - (id.length - N - 1);
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
		ResizingWeightedQuickUnionUF rwqu = new ResizingWeightedQuickUnionUF();
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(rwqu.connected(p, q))	continue;
			rwqu.union(p, q);
//			StdOut.println("id:" + rwqu.toString());
//			StdOut.println("visit cnt:" + rwqu.visitCount());
//			StdOut.println(rwqu.count());
		}
		StdOut.printf("%d components\n", rwqu.count());

	}

}
