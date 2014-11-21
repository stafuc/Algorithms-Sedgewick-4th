
public class Evaluate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> ops = new Stack<String>();
		Stack<Double> vals = new Stack<Double>();
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(s.equals("("))				   	   ;
			else if(s.equals("+"))		ops.push(s);
			else if(s.equals("-"))		ops.push(s);
			else if(s.equals("*"))		ops.push(s);
			else if(s.equals("/"))		ops.push(s);
			else if(s.equals("sqrt"))	ops.push(s);
			else if(s.equals(")")){
				double v = vals.pop();
				String op = ops.pop();
				if(op.equals("+"))		v = vals.pop() + v;
				else if(op.equals("-"))	v = vals.pop() - v;
				else if(op.equals("*"))	v = vals.pop() * v;
				else if(op.equals("/"))	v = vals.pop() / v;
				else if(op.equals("sqrt"))	v = Math.sqrt(v);
				vals.push(v);
			}
			else	vals.push(Double.parseDouble(s));
		}
		StdOut.println(vals.pop());
	}

}
