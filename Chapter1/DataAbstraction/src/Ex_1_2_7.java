
public class Ex_1_2_7 {
	
	public static String mystery(String s){
		int N = s.length();
		if(N <= 1) return s;
		String s1 = s.substring(0, N / 2);
		String s2 = s.substring(N / 2, N);
		return mystery(s2) + mystery(s1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = args[0];
		StdOut.println(mystery(s));

	}

}
