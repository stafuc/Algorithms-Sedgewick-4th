
public class Ex_1_1_32 {
	
	public static void histogram(double[] v, int N, double l, double r) {
		int[] count = new int[N + 1];
		for (int i = 0; i < v.length; i++) {
			int k = intervals(v[i], N, l, r);
			if(k != -1) count[k]++;
		}
		
		int maxCount = StdStats.max(count);
		StdDraw.setCanvasSize(512, 512);
		StdDraw.setXscale(l, r);
		StdDraw.setYscale(0, maxCount);
		double w = (r - l) / N;
		for (int i = 0; i < count.length; i++) {
			StdDraw.filledRectangle(l + (i + 0.5) * w, count[i] / 2.0, w / 2, count[i] / 2.0);
		}
		
		
		
	}
	
	private static int intervals(double v, int N, double l, double r){
		if(v < l || v >= r) return -1;
		return (int) ((v - l) * N / (r - l));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		double l = Double.parseDouble(args[1]),
			   r = Double.parseDouble(args[2]);
		double[] v = In.readDoubles();
//		String str = "";
//		for (int i = 0; i < v.length; i++) {
//			str += v[i];
//		}
//		StdOut.println(str);
//		StdOut.println(v.length);
		histogram(v, N, l, r);

	}

}
