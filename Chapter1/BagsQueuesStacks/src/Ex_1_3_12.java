
public class Ex_1_3_12 {
	
	public static Stack<String> copy(Stack<String> s){
		Stack<String> r = new Stack<String>();
		for (String string : s) {
			r.push(string);
		}
		return r;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
