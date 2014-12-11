
public class Ex_1_5_16 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = StdIn.readInt();
//		QuickFindUF f = new QuickFindUF(N);
		QuickUnionUF u = new QuickUnionUF(N);
//		WeightedQuickUnionUF wu = new WeightedQuickUnionUF(N);
//		WeightedHeightQuickUnionUF whu = new WeightedHeightQuickUnionUF(N);
//		PathCprWeightedQuickUnionUF pwu = new PathCprWeightedQuickUnionUF(N);
		int pre = 0, cnt = 0;
		StdDraw.setPenRadius(0.01);
		StdDraw.setXscale(0, 1000);
		StdDraw.setYscale(0, 1300);
		while(!StdIn.isEmpty()){
			int p = StdIn.readInt(), q = StdIn.readInt();
			u.union(p, q);
			int total = u.visitCount();
			++cnt;
			StdDraw.setPenColor(StdDraw.GRAY);
			StdDraw.point(cnt, total - pre);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(cnt, total / 1.0 / cnt);
			pre = total;
		}
//		QuickUnionUF u = new QuickUnionUF(N);

	}

}
