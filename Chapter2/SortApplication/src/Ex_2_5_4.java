import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Ex_2_5_4 {
	public static String[] dedup(String[] a) {
		Arrays.sort(a);
		ArrayList<String> l = new ArrayList<String>();
		for (int i = 0; i < a.length; i++) {
			if(i == 0 || !a[i].equals(a[i - 1]))
				l.add(a[i]);
		}
		
		String[] b = l.toArray(new String[l.size()]);
		return b;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"hello", "abc", "world", "fuck", "after", "abc", "fuck", "hello"};
		String[] s = dedup(a);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

}
