import java.util.NoSuchElementException;


public class HotterorColder {

	private int x;
	private int lastGuess = -1;
	
	public HotterorColder(int N) {
		// TODO Auto-generated constructor stub
		x = StdRandom.uniform(1, N + 1);
	}
	
	
	/**
	 * Guess.
	 *
	 * @param m the m
	 * @return the int 0 guess right, 1 hotter, 2 colder, -1 first guess
	 */
	public int guess(int m){
		if(m == x)	return 0;
		if(lastGuess == -1){
			lastGuess = m;
			return -1;
		}
		int last = lastGuess;
		lastGuess = m;
		if(Math.abs(m - x) < Math.abs(last - x))	return 1;
		return 2;
	}
	
	public int lastGuess() {
		return lastGuess;
	}
	
	public static int find(int N) {
		HotterorColder h = new HotterorColder(N);
		StdOut.printf("goal: %3d\n", h.x);
		return find(1, N, h);
	}
	
	private static int find(int lo, int hi, HotterorColder h) {
		if(lo > hi)	return -1;
		int mid = (lo + hi) / 2;
		int last = h.lastGuess();
//		StdOut.printf("last:%3d cur:%3d\n", last, mid);
		int ret = h.guess(mid);
		if(ret == 0)	return mid;
		if(ret == 1){
			if(last < mid){
				int r = find(Math.max(lo, (last + mid) / 2), mid - 1, h);
				if(r != -1)	return r;
				return find(mid + 1, hi, h);
			}else{
				int r = find(lo, mid - 1, h);
				if(r != -1)	return r;
				return find(mid + 1, Math.min(hi, (mid + last) / 2), h);
			}
		}else if(ret == 2){
			if(last < mid)	return find(lo, (last + mid) / 2, h);
			else{
				int temp = (last + mid) / 2;
				return find(temp == mid ? temp + 1 : temp, hi, h);
			}
		}
		int r = find(lo, mid - 1, h);
		if(r != -1)	return r;
		return find(mid + 1, hi, h);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int N = 10; N < 1000000000; N += N) {
			StopWatch s = new StopWatch();
			StdOut.println(find(N));
			StdOut.println(s.elapsedTime());
		}
	}

}
