
public class CopyStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> t = new Stack<Integer>();
		
		s.push(3);
		s.push(4);
		s.push(5);
		
		int N = s.size();
		Stack<Integer> p = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			p.push(s.pop());
		}
		
		for (int i = 0; i < N; i++) {
			int temp = p.pop();
			s.push(temp);
			t.push(temp);
		}
		
		s.push(2);
		t.push(6);
		
		for (Integer integer : s) {
			StdOut.println(integer);
		}
		
		StdOut.println("---------------");
		
		for (Integer integer : t) {
			StdOut.println(integer);
		}

	}

}
