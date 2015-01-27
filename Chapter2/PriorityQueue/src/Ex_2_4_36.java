
public class Ex_2_4_36 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 100; N < 1e6; N += N) {
			int Max = 100000;
			MaxPQ<Integer> pq = new MaxPQ<Integer>(N);
			StopWatch sw = new StopWatch();
			for (int i = 0; i < N; i++) {
				pq.insert(StdRandom.uniform(-Max, Max));
			}
			while (pq.size() > N / 2) {
				pq.delMax();
			}
			while(pq.size() < N){
				pq.insert(StdRandom.uniform(-Max, Max));
			}
			while(!pq.isEmpty()){
				pq.delMax();
			}
			System.out.printf("N:%d, time:%f\n", N, sw.elapsedTime());
		}
		
	}

}
