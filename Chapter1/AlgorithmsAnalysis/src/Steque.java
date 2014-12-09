import java.util.NoSuchElementException;


public class Steque<Item> {

	private Stack<Item> left;
	private Stack<Item> right;
	
	public Steque() {
		// TODO Auto-generated constructor stub
		left = new Stack<Item>();
		right = new Stack<Item>();
	}
	
	public void push(Item item) {
		right.push(item);
	}
	
	public Item pop() {
		if(right.isEmpty()){
			if(left.isEmpty())	throw new NoSuchElementException("underflow");
			while(!left.isEmpty()){
				right.push(left.pop());
			}
		}
		return right.pop();
	}
	
	public void enqueue(Item item) {
		left.push(item);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Steque<Integer> s = new Steque<Integer>();
		for (int i = 0; i < 10; i++) {
			double r = StdRandom.uniform();
			int temp = StdRandom.uniform(100);
			if(r <= 0.3){
				s.push(temp);
				StdOut.printf("push %3d\n", temp);
			}
			else if(r <= 0.7){	
				int t = s.pop();
				StdOut.printf("pop %3d\n", t);
			}else{
				s.enqueue(temp);
				StdOut.printf("enqueue %3d\n", temp);
			}
		}
	}

}
