import java.util.Iterator;
import java.util.NoSuchElementException;


public class Buffer{
	
	private	Stack<Character> left = new Stack<Character>();
	private Stack<Character> right = new Stack<Character>();
	private int leftN = 0;
	private int rightN = 0;

	public void insert(char c){
		left.push(c);
		leftN++;
	}
	
	public char delete(){
		if(leftN == 0)	throw new NoSuchElementException();
		char c = left.pop();
		leftN--;
		return c;
	}
	
	public void left(int k){
		if(leftN < k)	throw new NoSuchElementException();
		for (int i = 0; i < k; i++) {
			char c = left.pop();
			right.push(c);
		}
		leftN -= k;
		rightN += k;
	}
	
	public void right(int k){
		if(rightN < k)	throw new NoSuchElementException();
		for (int i = 0; i < k; i++) {
			char c = right.pop();
			left.push(c);
		}
		rightN -= k;
		leftN += k;
	}
	
	public int size(){
		return leftN + rightN;
	}
	
	public String toString(){
		return new StringBuilder(left.toString()).reverse().toString() + right.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer b = new Buffer();
		b.insert('a');
		b.insert('b');
		b.left(1);
		b.insert('c');
		b.insert('d');
		b.left(3);
		b.insert('e');
		b.right(2);
		b.insert('f');
		b.right(2);
		b.insert('g');
		b.right(1);
		StdOut.println(b.toString());
		StdOut.println(b.size());

	}

}
