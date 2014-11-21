
public class Ex_1_1_31 {

	// public static void drawRandConn(int N, double p){
	// 	StdDraw.setCanvasSize();
	// 	StdDraw.setScale(-1, 1);
	// 	StdDraw.setPenRadius(0.015);
		
	// 	double[][] point = new double[N][2];
	// 	for (int i = 0; i < N; i++) {
	// 		point[i][0] = Math.cos(2 * Math.PI * i / N);
	// 		point[i][1] = Math.sin(2 * Math.PI * i / N);
	// 		StdDraw.point(point[i][0], point[i][1]);
	// 	}
		
	// 	StdDraw.setPenRadius();
	// 	for (int i = 0; i < N; i++) {
	// 		for (int j = i + 1; j < N; j++) {
	// 			if(StdRandom.bernoulli(p)) StdDraw.line(point[i][0], point[i][1], point[j][0], point[j][1]);
	// 		}
	// 	}
		
		
		
	// }
	
	public static void main(String[] args) {
		System.out.println("hello");
		// TODO Auto-generated method stub
		if(args.length != 2){
			StdOut.println("hello");
			return;
		}
		// drawRandConn(Integer.parseInt(args[0]), Double.parseDouble(args[1]));
	}

}
