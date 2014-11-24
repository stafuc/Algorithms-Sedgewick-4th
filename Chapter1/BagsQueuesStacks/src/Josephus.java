
public class Josephus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		Queue<Integer> q = new Queue<Integer>();
		for (int i = 0; i < N; i++) {
			q.enqueue(i);
		}
		
		int k = 1;
		while(!q.isEmpty()){
			int temp = q.dequeue();
			if(k++ % M == 0)	StdOut.print(temp + " ");
			else	q.enqueue(temp);
		}
		StdOut.println();
	}

}
