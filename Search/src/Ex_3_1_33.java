
public class Ex_3_1_33 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 1000; N < 1e6; N *= 10) {
			long t1 = System.currentTimeMillis();
			ArrayST_ForwardCoding<Integer, Integer> st = new ArrayST_ForwardCoding<>(N);
			for (int i = 1; i <= N; i++) {
				st.put(i, i);
			}
			for (int i = 0; i < 10 * N; i++) {
				double r = StdRandom.uniform();
				double p = 0;
				for (int j = 1; j <= N; j++) {
					p += 1 / Math.pow(2, j);
					if(r < p){
						st.get(j);
//						System.out.println(j);
						break;
					}
				}
			}
			long t2 = System.currentTimeMillis();
			ArrayST<Integer, Integer> st1 = new ArrayST<>(N);
			for (int i = 1; i <= N; i++) {
				st1.put(i, i);
			}
			for (int i = 0; i < 10 * N; i++) {
				double r = StdRandom.uniform();
				double p = 0;
				for (int j = 1; j <= N; j++) {
					p += 1 / Math.pow(2, j);
					if(r < p){
						st1.get(j);
//						System.out.println(j);
						break;
					}
				}
			}
			long t3 = System.currentTimeMillis();
			System.out.println(N + ":" + (t2 - t1) / 1000.0 + "," + (t3 - t2) / 1000.0);
		}

	}

}
