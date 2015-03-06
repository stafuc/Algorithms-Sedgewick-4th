import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SequentialSearchST <Key extends Comparable<Key>, Value> {
	private Node first = null;
	private int N = 0;
	private int cmpCnt = 0;
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
		for (Node x = first; x != null; x = x.next) {
			if(x.key.equals(k))	return	x.value; 
		}
		return null;
	}
	
	public void put(Key key, Value val) {
		for (Node x = first; x != null; x = x.next) {
			cmpCnt++;
			if(x.key.equals(key)){
				x.value = val;
				return;
			}
		}
		first = new Node(key, val, first);
		N++;
	}
	
	public int size() {
		return N;
	}
	
	public int cmpCnt() {
		return cmpCnt;
	}
	
	void delete(Key key){
		if(N == 0){
			System.out.println("st is empty!");
			return;
		}
		Node pre = null, cur = first;
		while(cur != null){
			if(cur.key.equals(key)){
				if(pre == null)	first = first.next;
				else	pre.next = cur.next;
				System.out.println("del " + key);
				N--;
			}
			pre = cur;
			cur = cur.next;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SequentialSearchST<String, Integer> sst = new SequentialSearchST<String, Integer>();
		String s[] = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
		sst.delete("U");
		for (int i = 0; i < s.length; i++) {
			sst.put(s[i], 0);
		}
		sst.delete("E");
		System.out.println(sst.get("E"));
		System.out.println(sst.cmpCnt);
	}

}
