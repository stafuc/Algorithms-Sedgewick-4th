
public class WeightedHeightQuickUnionUF {

	private int id[];
	private int height[];
	private int count;
	private int visitCount;
	
	public WeightedHeightQuickUnionUF(int N) {
		// TODO Auto-generated constructor stub
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)	id[i] = i;
		height = new int[N];
		for (int i = 0; i < N; i++)	height[i] = 0;
		visitCount = 0;
	}
	
	public void union(int p, int q) {
		int pID = find(p);
		int qID = find(q);
		if(pID == qID)	return;
		visitCount += 2;
		int h1 = height[pID], h2 = height[qID];
		if(h1 < h2){
			id[pID] = qID;
			++visitCount;
		}else{
			id[qID] = pID;
			++visitCount;
			if(h1 == h2){
				++height[pID];
				++visitCount;
			}
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
		WeightedHeightQuickUnionUF whqu = new WeightedHeightQuickUnionUF(N);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if(whqu.connected(p, q))	continue;
			whqu.union(p, q);
			StdOut.println("id:" + whqu.toString());
			StdOut.println("visit cnt:" + whqu.visitCount());
		}
//		StdOut.printf("%d components\n", wqu.count);

	}

}
