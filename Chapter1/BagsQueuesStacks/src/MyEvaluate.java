import javax.management.RuntimeErrorException;


public class MyEvaluate {
	
	private static boolean isNumeric(char c){
		return c >= '0' && c <= '9';
	}
	
	private static int isNumeric(String s, int i){
		if(isNumeric(s.charAt(i))){
			int j = i + 1;
			while(j < s.length() && isNumeric(s.charAt(j))){
				j++;
			}
			return j;
		}else return -1;
	}
	
	private static boolean opHigher(char op1, char op2){
		if(op1 == '*' || op1 == '/'){
			if(op2 == '+' || op2 == '-')	return true;
		}
		return false;
	}
	
	private static double calc(double v1, double v2, char op){
		if(op == '+')	return v1 + v2;
		if(op == '-')	return v1 - v2;
		if(op == '*')	return v1 * v2;
		if(op == '/')	return v1 / v2;
		else throw new RuntimeException("invalid op");
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> ops = new Stack<Character>();
		Stack<Double> vals = new Stack<Double>();
		while(!StdIn.isEmpty()){
			String s = StdIn.readLine();
//			StdOut.println(s);
			int i = 0;
			while(i < s.length()){
//				StdOut.println(i);
				if(s.charAt(i) == ' '){
					i++;
					continue;
				}
				int j = isNumeric(s, i);
				if(j != -1){
					double v = Double.parseDouble(s.substring(i, j));
					vals.push(v);
					i = j;
				}else{
					char currOpt = s.charAt(i);
					if(!ops.isEmpty()){
						char lastOpt = ops.peek();
						if(!opHigher(currOpt, lastOpt)){
							ops.pop();
							double v1 = vals.pop(), v2 = vals.pop();
							vals.push(calc(v2, v1, lastOpt));
							ops.push(currOpt);
						}else{
							ops.push(currOpt);
						}	
					}else	ops.push(currOpt);
					i++;
					
				}
			}
//			assert ops.size() == 1 : "ops size != 1";
//			assert vals.size() == 2 : "vals size != 2";
			while(!ops.isEmpty()){
				double v1 = vals.pop(), v2 = vals.pop();
				char op = ops.pop();
				vals.push(calc(v2, v1, op));
			}
			StdOut.println(vals.peek());
		}

	}

}
