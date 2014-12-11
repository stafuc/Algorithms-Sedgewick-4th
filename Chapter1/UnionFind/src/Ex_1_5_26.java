
public class Ex_1_5_26 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
//		QuickFindUF qf = new QuickFindUF(N);
//		QuickUnionUF qu = new QuickUnionUF(N);
//		WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(N);
//		WeightedHeightQuickUnionUF whqu = new WeightedHeightQuickUnionUF(N);
		PathCprWeightedQuickUnionUF pcwqu = new PathCprWeightedQuickUnionUF(N);
		StdDraw.setXscale(0, 5 * N);
		StdDraw.setYscale(0, 2 * N);
		StdDraw.setPenRadius(0.005);
		int pre = 0;
		int index = 0;
		while(pcwqu.count() > 1){
			int p = StdRandom.uniform(N), q = StdRandom.uniform(N);
			pcwqu.union(p, q);
			int total = pcwqu.visitCount();
			++index;
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.point(index, total - pre);
			
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(index, total / 1.0 / index);
			pre = total;
		}

	}

}
