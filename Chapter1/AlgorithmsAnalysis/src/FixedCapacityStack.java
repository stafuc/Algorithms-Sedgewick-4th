import java.util.Iterator;
import java.util.NoSuchElementException;


public class FixedCapacityStack<Item> implements Iterable<Item>{
	
	private Item[] a;
	private int N;
	
	public FixedCapacityStack(int cap) {
		// TODO Auto-generated constructor stub
		a = (Item[])new Object[cap];
	}
	
	/**
	 * Resize. warning not set max == 0
	 *
	 * @param max the max
	 */
	private void resize(int max){
		Item[] item = (Item[])new Object[max];
		for (int i = 0; i < N; i++) {
			item[i] = a[i];
		}
		a = item;
	}
	
	public void push(Item item){
		if(N == a.length)	resize(2 * a.length);
		a[N++] = item;
	}
	
	public Item peek(){
		if(N == 0) throw new NoSuchElementException();
		return a[N - 1];
	}
	
	public Item pop(){
		if(N == 0)	throw new NoSuchElementException();
		Item item = a[--N];
		a[N] = null;
		if(N > 0 && N == a.length / 4) resize(a.length / 2);
		return item;
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public boolean isFull(){
		return N == a.length;
	}
	
	public int size(){
		return N;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		FixedCapacityStack<Character> s = new FixedCapacityStack<Character>(1);
//		String str = StdIn.readString();
//		//			if(str.equals("-"))	s.pop();
//		//			else s.push(str);
//		for(int i = 0; i < str.length(); i++){
//			char c = str.charAt(i);
//			if(c == '(' || c == '[' || c == '{')
//				s.push(c);
//			else{
//				char t = s.pop();
//				if(c == ')' && t != '('){
//					StdOut.println("false");
//					return;
//				}
//				if(c == ']' && t != '['){
//					StdOut.println("false");
//					return;
//				}
//				if(c == '}' && t != '{'){
//					StdOut.println("false");
//					return;
//				}
//			}
//	
//		}
//		if(s.isEmpty())		
//			StdOut.println("true");
//		else
//			StdOut.println("false");
//		for (String str : s) {
//			StdOut.println(str);
//		}
//		StdOut.println(s.size() + " left in stack!");
		
		FixedCapacityStack<Integer> s = new FixedCapacityStack<Integer>(1);
		int N = Integer.parseInt(args[0]);
		while(N > 0){
			s.push(N % 2);
			N /= 2;
		}
		String res = "";
		while(!s.isEmpty()){
			res += s.pop();
		}
		StdOut.println(res);

	}
	
	private class ReverseArrayIterator implements Iterator<Item>{

		private int i = N;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i > 0;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return a[--i];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}
		
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}

}
