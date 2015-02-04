import java.util.Arrays;


public class Ex_2_5_2 {

	public static void find(String[] words) {
		Arrays.sort(words);
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < i; j++) {
				if(words[i].startsWith(words[j])){
					String remained = words[i].substring(words[j].length());
					if(find(words, remained) != -1){
						System.out.printf("find %s:%s %s\n", words[i], words[j], remained);
						break;
					}
				}
			}
			System.out.println(words[i]);
		}
		
	}
	
	private static int find(String[] s, String w) {
		int lo = 0, hi = s.length - 1;
		while(lo <= hi){
			int mid = (lo + hi) / 2;
			if(w.equals(s[mid]))	return mid;
			else if(w.compareTo(s[mid]) < 0)	hi = mid - 2;
			else	lo = mid + 1;
		}
		return -1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"after", "thought", "afterthought", "noon", "good", "hello", "world", "afternoon", "goodafternoon", 
				 "helloworld"};
		find(s);
	}

}
