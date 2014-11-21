
public class VisualCounter {
	
	private int count;
	private int N;
	private int max;
	private int opCnt;
	
	public VisualCounter(int N, int max) {
		// TODO Auto-generated constructor stub
		this.N = N;
		this.max = max;
	}
	
	public void increment(){
		if(opCnt < N){
			if(count < max)
				count++;
			opCnt++;
		}else{
			StdOut.println("can't operate any more!");
		}
	}
	
	public void decrement(){
		if(opCnt < N){
			if(count > -max)
				count--;
			opCnt++;
		}else{
			StdOut.println("can't operate any more!");
		}
	}
	
	public int tally(){
		return count;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		int max = Integer.parseInt(args[1]);
		VisualCounter vc = new VisualCounter(N, max);
		StdDraw.setXscale(0, 2 * N);
		StdDraw.setYscale(-max, max);
		StdDraw.setPenRadius(0.015);
		for (int i = 0; i < 2 * N; i++) {
			if(StdRandom.uniform() < 0.5) vc.increment();
			else vc.decrement();
			StdDraw.point(i, vc.tally());
		}
	}

}
