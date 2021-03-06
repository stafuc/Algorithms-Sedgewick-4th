import java.util.Scanner;


public class ArrayST <Key extends Comparable<Key>, Value>{

	private Key[] keys;
	private Value[] values;
	private int size;
	private int cmpCnt;
	

	private void resize(int m) {
		Key[] nkeys = (Key[])new Comparable[m];
		Value[] nvalues = (Value[])new Object[m];
		for (int i = 0; i < size; i++) {
			nkeys[i] = keys[i];
			nvalues[i] = values[i];
		}
		keys = nkeys;
		values = nvalues;
	}
	
	public ArrayST() {
		// TODO Auto-generated constructor stub
		this(1);
	}
	
	public ArrayST(int capacity) {
		// TODO Auto-generated constructor stub
		keys = (Key[])new Comparable[capacity];
		values = (Value[])new Object[capacity];
		size = 0;
	}
	

	public boolean contain(Key k) {
		for (int i = 0; i < size; i++) {
			if(keys[i].compareTo(k) == 0)	return true;
		}
		return false;
	}
	
	public Value get(Key k){
		for (int i = 0; i < keys.length; i++) {
			cmpCnt++;
			if(keys[i].compareTo(k) == 0){
				Value v = values[i];
				return v;
			}
		}
		return null;
	}
	
	public void put(Key k, Value v) {
		for (int i = 0; i < size; i++) {
			cmpCnt++;
			if(keys[i].compareTo(k) == 0){
				values[i] = v;
				return;
			}
		}
		if(size == keys.length)	resize(2 * size);
		keys[size] = k;
		values[size++] = v;
	}
	
	public int size() {
		return size;
	}
	
	public int getComCnt() {
		return cmpCnt;
	}
	
	public Iterable<Key> keys() {
		Queue<Key> q = new Queue<Key>();
		for (int i = 0; i < size; i++) {
			q.enqueue(keys[i]);
		}
		return q;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayST<String, Double> ast = new ArrayST<String, Double>(11);
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 11; i++) {
			ast.put(in.next(), in.nextDouble());
		}
		while(in.hasNext()){
			System.out.println(ast.get(in.next()));
		}
	}

}
