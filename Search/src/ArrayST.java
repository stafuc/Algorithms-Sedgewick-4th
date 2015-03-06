import java.util.Scanner;


public class ArrayST <Key extends Comparable<Key>, Value>{

	private Key[] keys;
	private Value[] values;
	private int size;
	
	public ArrayST(int capacity) {
		// TODO Auto-generated constructor stub
		keys = (Key[])new Comparable[capacity];
		values = (Value[])new Comparable[capacity];
		size = 0;
	}
	
	public Value get(Key k){
		for (int i = 0; i < keys.length; i++) {
			if(keys[i].compareTo(k) == 0)	return values[i];
		}
		return null;
	}
	
	public void put(Key k, Value v) {
		for (int i = 0; i < size; i++) {
			if(keys[i].compareTo(k) == 0){
				values[i] = v;
				return;
			}
		}
		if(size < keys.length){
			keys[size] = k;
			values[size++] = v;
		}
	}
	
	public int size() {
		return size;
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
