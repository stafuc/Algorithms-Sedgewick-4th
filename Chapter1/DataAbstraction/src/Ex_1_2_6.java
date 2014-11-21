
public class Ex_1_2_6 {
	
	public static boolean circularRotation(String str1, String str2){
		if(str1.length() != str2.length()) return false;
		return (str1 + str1).indexOf(str2) != -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = args[0], str2 = args[1];
		if(circularRotation(str1, str2)) StdOut.println("yes!");
		else StdOut.println("No!");
		

	}

}
