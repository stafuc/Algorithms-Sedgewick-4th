import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;


public class LPT {

	private static class target{
		String name;
		int time;
	}
	
	private static class TargetDesendingOrder implements Comparator<target>{
		@Override
		public int compare(target o1, target o2) {
			// TODO Auto-generated method stub
			return o2.time - o1.time;
		}
	}
	
	private static class Machine implements Comparable<Machine>{
		int workload;

		@Override
		public int compareTo(Machine o) {
			// TODO Auto-generated method stub
			return workload - o.workload;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M = Integer.parseInt(args[0]);
		Scanner in = new Scanner(System.in);
		ArrayList<target> l = new ArrayList<LPT.target>();
		while(in.hasNext()){
			target t = new target();
			t.name = in.next();
			t.time = in.nextInt();
			l.add(t);
		}
		Collections.sort(l, new TargetDesendingOrder());
		MinPQ<Machine> pq = new MinPQ<LPT.Machine>();
		for (int i = 0; i < M; i++) {
			Machine m = new Machine();
			m.workload = 0;
			pq.insert(m);
		}
		for (int i = 0; i < l.size(); i++) {
			Machine m = pq.delMin();
			m.workload += l.get(i).time;
			pq.insert(m);
		}
		while (!pq.isEmpty()) {
			Machine m = pq.delMin();
			System.out.println("workload:" + m.workload);
		}
	}

}
