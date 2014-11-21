
public class Ex_1_3_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<String> ops = new Stack<String>(),
					  vals = new Stack<String>();
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(s.equals("("))				   	   ;
			else if(s.equals("+"))		ops.push(s);
			else if(s.equals("-"))		ops.push(s);
			else if(s.equals("*"))		ops.push(s);
			else if(s.equals("/"))		ops.push(s);
			else if(s.equals("sqrt"))	ops.push(s);
			else if(s.equals(")")){
				String v = vals.pop();
				String op = ops.pop();
				if(op.equals("sqrt")) v = String.format("( %s %s )", op, v);
				else v = String.format("( %s %s %s )", vals.pop(), op, v);
				vals.push(v);
			}
			else	vals.push(s);
		}
		StdOut.println(vals.pop());

	}

}
