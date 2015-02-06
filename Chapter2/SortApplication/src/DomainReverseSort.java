import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class DomainReverseSort {

	private static class Domain implements Comparable<Domain>{
		String name;
		String reverse(){
			String[] s = name.split("\\.");
			for (int i = 0, j = s.length - 1; i < j; i++, j--) {
				String tmp = s[i];
				s[i] = s[j];
				s[j] = tmp;
			}
			String tmp = "";
			for (int i = 0; i < s.length; i++) {
				tmp += s[i] + ".";
			}
			return tmp.substring(0, tmp.length() - 1);
		}
		@Override
		public int compareTo(Domain o) {
			// TODO Auto-generated method stub
			return reverse().compareTo(o.reverse());
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Domain d1 = new Domain();
		d1.name = "www.baidu.com";
		Domain d2 = new Domain();
		d2.name = "www.google.com";
		Domain d3 = new Domain();
		d3.name = "www.taobao.com";
		Domain d4 = new Domain();
		d4.name = "www.facebook.com";
		ArrayList<Domain> l = new ArrayList<DomainReverseSort.Domain>();
		l.add(d1);
		l.add(d2);
		l.add(d3);
		l.add(d4);
		Collections.sort(l);
		for (Domain domain : l) {
			System.out.println(domain.reverse());
		}
//		for (int i = 0; i < s.length; i++) {
//			System.out.println(s[i]);
//		}
	}

}
