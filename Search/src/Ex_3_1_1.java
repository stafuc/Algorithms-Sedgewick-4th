import java.util.Scanner;


public class Ex_3_1_1 {
	private Node head = null;
	private int N = 0;
	private static class Node{
		public Node(String l, double s, Node n) {
			// TODO Auto-generated constructor stub
			level = l;
			score = s;
			next = n;
		}
		String level;
		double score;
		Node next;
	}
	
	public void put(String l, double s) {
		head = new Node(l, s, head);
		N++;
	}
	
	public double get(String l) {
		Node temp = head;
		while(temp != null){
			if(temp.level.equals(l))	return temp.score;
			temp = temp.next;
		}
		return -1.0;
	}
	
	public int size() {
		return N;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex_3_1_1 ssST = new Ex_3_1_1();
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 11; i++) {
			ssST.put(in.next(), in.nextDouble());
		}
		while(in.hasNext()){
			System.out.println(ssST.get(in.next()));
		}
	}

}
