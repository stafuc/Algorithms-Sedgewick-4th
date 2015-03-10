import java.util.Scanner;


public class ArrayST_ForwardCoding <Key extends Comparable<Key>, Value>{

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
	
	private void moveForward(int i){
		Key k = keys[i];
		for (int j = i - 1; j >= 0; j--) {
			keys[j + 1] = keys[j];
		}
		keys[0] = k;
		
		Value v = values[i];
		for (int j = i - 1; j >= 0; j--) {
			values[j + 1] = values[j];
		}
		values[0] = v;
	}
	
	public ArrayST_ForwardCoding(){
		// TODO Auto-generated constructor stub
		this(1);
	}
	
	public ArrayST_ForwardCoding(int capacity) {
		// TODO Auto-generated constructor stub
		keys = (Key[])new Comparable[capacity];
		values = (Value[])new Comparable[capacity];
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
				moveForward(i);
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
		ArrayST_ForwardCoding<Character, Integer> ast_fc = new ArrayST_ForwardCoding<Character, Integer>(30);
		ArrayST<Character, Integer> ast = new ArrayST<Character, Integer>(30);
//		System.out.println('a' + 1);
		for (int i = 0; i < 26; i++) {
			ast_fc.put(new Character((char)('a' + i)), i + 1);
			ast.put(new Character((char)('a' + i)), i + 1);
		}
		for (int N = 100; N < 1e6; N += N) {
			for (int i = 0; i < N; i += 2) {
				int r = StdRandom.uniform(0, 25);
				ast_fc.get((char)('a' + r));
				ast.get((char)('a' + r));	
				ast_fc.get((char)('a' + r));
				ast.get((char)('a' + r));
			}
			System.out.println("N:" + N + " cnt:" + ast.getComCnt() + " cnt_fc:" + ast_fc.getComCnt());
		}
	}

}
