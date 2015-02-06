import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class FreeTime {
	private static class Target implements Comparable<Target>{
		int t1, t2;

		@Override
		public int compareTo(Target o) {
			// TODO Auto-generated method stub
			if(t1 < o.t1)	return -1;
			else if(t1 > o.t1)	return 1;
			else	return t2 - o.t2;
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		ArrayList<Target> l = new ArrayList<FreeTime.Target>();
		while(in.hasNext()){
			Target t = new Target();
			t.t1 = in.nextInt();
			t.t2 = in.nextInt();
			l.add(t);
		}
		Collections.sort(l);
		for (Target target : l) {
			System.out.println("target:" + target.t1 + " " + target.t2);
		}
		int maxFree = -1, maxBusy = -1;
		int left = 0, right = 0;
		for (Target target : l) {
			if(target.t2 > right){
				if(target.t1 <= right)	right = target.t2;
				else{
					if(right - left > maxBusy)	maxBusy = right - left;
					if(target.t1 - right > maxFree)	maxFree = target.t1 - right;
					left = target.t1;
					right = target.t2;
				}
			}
		}
		if(right - left > maxBusy)	maxBusy = right - left;
		System.out.println("free:" + maxFree + ", busy:" + maxBusy);
	}

}
