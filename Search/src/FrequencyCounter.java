
public class FrequencyCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int minlen = Integer.parseInt(args[0]);
		ArrayST<String, Integer> st = new ArrayST<String, Integer>();
		ArrayST_ForwardCoding<String, Integer> st1 = new ArrayST_ForwardCoding<>();
		BinarySearchST<String, Integer> st2 = new BinarySearchST<>();
		while(!StdIn.isEmpty()){
			String word = StdIn.readString();
			if(word.length() < minlen)	continue;
			if(!st.contain(word)){
				st.put(word, 1);
				st1.put(word, 1);
				st2.put(word, 1);
			}
			else{
				st.put(word, st.get(word) + 1);
				st1.put(word, st1.get(word) + 1);
				st2.put(word, st2.get(word) + 1);
			}
		}
		
		System.out.println(st.getComCnt() + "," + st1.getComCnt() + "," + st2.cmpCnt());
		
//		String max = " ";
//		st2.put(max, 0);
//		for (String s : st2.keys()) {
//			if(st2.get(s) > st2.get(max))	max = s;
//		}
//		System.out.println(max + " " + st2.get(max));
	}

}
