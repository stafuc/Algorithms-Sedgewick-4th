import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class Frequency {

	private static class Node implements Comparable<Node>{
		String s;
		int cnt = 0;
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if(cnt > o.cnt) return -1;
			else if(cnt == o.cnt) return 0;
			else	return 1;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"hello", "abc", "world", "fuck", "after", "abc", "fuck", "hello", "hello"};
		Arrays.sort(s);
		ArrayList<Node> l = new ArrayList<Node>();
		int i = 0;
		while(i < s.length){
			int j = i + 1;
			while(j < s.length && s[j].equals(s[i]))	++j;
			Node n = new Node();
			n.s = s[i];
			n.cnt = j - i;
			l.add(n);
			i = j;
		}
		Collections.sort(l);
		for (Node node : l) {
			System.out.println(node.s + " " + node.cnt);
		}

	}

}
