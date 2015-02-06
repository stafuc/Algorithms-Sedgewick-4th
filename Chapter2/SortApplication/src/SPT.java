import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class SPT {
	private static class target implements Comparable<target>{
		String name;
		int time;
		@Override
		public int compareTo(target o) {
			// TODO Auto-generated method stub
			if(time < o.time)	return -1;
			else if(time == o.time)	return 0;
			else	return 1;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		ArrayList<target> l = new ArrayList<SPT.target>();
		while(in.hasNext()){
			target t = new target();
			t.name = in.next();
			t.time = in.nextInt();
			l.add(t);
		}
		Collections.sort(l);
		for (target target : l) {
			System.out.println(target.name + " " + target.time);
		}
	}

}
