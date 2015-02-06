import java.util.Arrays;
import java.util.HashSet;


public class Ex_2_5_32 {
	private static SET<String> sh;
	private static class Node implements Comparable<Node>{
		int[] a;
		int step;
		Node pre;
		public Node(int[] na, int s) {
			// TODO Auto-generated constructor stub
			a = na;
			step = s;
			pre = null;
		}
		
		int misCount(){
			int cnt = 0;
			for (int i = 0; i < a.length; i++) {
				if(a[i] == 0)	continue;
				if(a[i] != i + 1)	++cnt;
			}
			return cnt;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return (misCount() + step) - (o.misCount() + o.step);
		}
		
		public boolean finish() {
			return misCount() == 0;
		}
		
		public String toString() {
			String s = "";
			for (int i = 0; i < a.length; i++) {
				s += a[i] + " ";
				if(i % 3 == 2)	s += "\n";
			}
			s += "step:" + step;
			return s;
		}
		
		public int score() {
			return misCount() + step;
		}
	}
	
	
	
	private static void exch(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[9];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		a[8] = 0;
		sh = new SET<String>();
		StdRandom.shuffle(a);
		MinPQ<Node> pq = new MinPQ<Ex_2_5_32.Node>();
		sh.add(Arrays.toString(a).replaceAll("[\\[\\],\\s]", ""));
		Node n = new Node(a, 0);
		System.out.println(n.toString());
		System.out.println("------------------------");
		pq.insert(n);
		Node last = null;
		while(!pq.isEmpty()){
			Node mn = pq.delMin();
//			System.out.println(mn.score());
			if(mn.finish()){
				last = mn;
				break;
			}
			for (int i = 0; i < mn.a.length; i++) {
				if(mn.a[i] == 0){
					if(i - 3 >= 0){
						int[] ta = Arrays.copyOf(mn.a, mn.a.length);
						exch(ta, i, i - 3);
						String stage = Arrays.toString(ta).replaceAll("[\\[\\],\\s]", "");
						if(!sh.contains(stage)){
							Node tn = new Node(ta, mn.step + 1);
							tn.pre = mn;
							pq.insert(tn);	
							sh.add(stage);
						}
						
					}
					if(i % 3 != 2){
						int[] ta = Arrays.copyOf(mn.a, mn.a.length);
						exch(ta, i, i + 1);
						String stage = Arrays.toString(ta).replaceAll("[\\[\\],\\s]", "");
						if(!sh.contains(stage)){
							Node tn = new Node(ta, mn.step + 1);
							tn.pre = mn;
							pq.insert(tn);
							sh.add(stage);
						}
						
					}
					if(i + 3 < mn.a.length){
						int[] ta = Arrays.copyOf(mn.a, mn.a.length);
						exch(ta, i, i + 3);
						String stage = Arrays.toString(ta).replaceAll("[\\[\\],\\s]", "");
						if(!sh.contains(stage)){
							Node tn = new Node(ta, mn.step + 1);
							tn.pre = mn;
							pq.insert(tn);
							sh.add(stage);
						}
						
					}
					if(i % 3 != 0){
						int[] ta = Arrays.copyOf(mn.a, mn.a.length);
						exch(ta, i, i - 1);
						String stage = Arrays.toString(ta).replaceAll("[\\[\\],\\s]", "");
						if(!sh.contains(stage)){
							Node tn = new Node(ta, mn.step + 1);
							tn.pre = mn;
							pq.insert(tn);
							sh.add(stage);
						}
					}
					break;
				}
			}
		}
		Stack<Node> sn = new Stack<Ex_2_5_32.Node>();
		while(last != null){
			sn.push(last);
			last = last.pre;
		}
		while (!sn.isEmpty()) {
			Node tmp = sn.pop();
			System.out.println(tmp.toString());
		}
	}

}
