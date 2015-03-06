import java.util.Scanner;


public class OrderedSequentialSearchST <Key extends Comparable<Key>, Value> {
	private Node head = null;
	private int N = 0;
	private class Node{
		public Node(Key k, Value v, Node n) {
			// TODO Auto-generated constructor stub
			key = k;
			value = v;
			next = n;
		}
		Key key;
		Value value;
		Node next;
	}
	
	public Value get(Key k) {
		Node temp = head;
		while(temp != null){
			if(temp.key.compareTo(k) == 0)	return temp.value;
			if(temp.key.compareTo(k) > 0)	return null;
			temp = temp.next;
		}
		return null;
	}
	
	public void put(Key k, Value v) {
		Node cur = head, pre = null;
		while(cur != null && cur.key.compareTo(k) < 0){
			pre = cur;
			cur = cur.next;
		}
		if(pre == null)	head = new Node(k, v, head);
		else	pre.next = new Node(k, v, pre.next);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderedSequentialSearchST<String, Double> ost = new OrderedSequentialSearchST<String, Double>();
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 11; i++) {
			ost.put(in.next(), in.nextDouble());
		}
		while(in.hasNext()){
			System.out.println(ost.get(in.next()));
		}
	}

}
