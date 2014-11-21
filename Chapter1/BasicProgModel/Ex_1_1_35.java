
public class Ex_1_1_35 {
	
	private static double[] dis = new double[13];
	
	public static void initDist()
	{
		int SIDES = 6;
		for (int i = 1; i <= SIDES ; i++) {
			for (int j = 1; j <= SIDES; j++) {
				dis[i + j] += 1;
			}
		}
		
		String str = "";
		for (int i = 0; i < dis.length; i++) {
			dis[i] /= 36.0;
			str += dis[i] + " ";
		}
		
//		StdOut.println(str);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		initDist();
		int[] count = new int[13];
		int N = 0;
		double EXP = 0.001;
		while(true){
			int a = StdRandom.uniform(6) + 1,
				b = StdRandom.uniform(6) + 1;
//			StdOut.println(a + b);
			count[a + b] += 1;
			N++;
			double[] pos = new double[13];
			double error = 0;
			String str = "";
			for (int i = 0; i < pos.length; i++) {
				pos[i] = count[i] / 1.0 / N;
				str += pos[i] + " ";
				error += Math.abs(pos[i] - dis[i]); 
			}
//			StdOut.println(str);
			if(error / 13.0 < EXP) break;
		}
		StdOut.println(N);
		
		

	}

}
