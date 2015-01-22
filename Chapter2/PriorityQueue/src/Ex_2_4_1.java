
public class Ex_2_4_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "PRIO*R**I*T*Y***QUE***U*E";
//		String str = "PRIO*R**I*";
		MaxPQ<Character> mpq = new MaxPQ<Character>();
		UnorderedArrayMaxPQ<Character> unarrpq = new UnorderedArrayMaxPQ<Character>(str.length());
		OrderedArrayMaxPQ<Character> arrpq = new OrderedArrayMaxPQ<>(str.length());
		UnorderedListMaxPQ<Character> unlistpq = new UnorderedListMaxPQ<Character>();
		OrderedListMaxPQ<Character> listpq = new OrderedListMaxPQ<>();
		ListMaxPQ<Character> lhpq = new ListMaxPQ<Character>();
		NoExchMaxPQ<Character> nepq = new NoExchMaxPQ<Character>();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '*'){
				System.out.println(mpq.delMax() + "," + unarrpq.delMax() + "," + arrpq.delMax() + 
						"," + unlistpq.delMax() + "," + listpq.delMax() + "," + lhpq.delMax() + 
						"," + nepq.delMax());
//				unlistpq.show();
			}
			else{
				mpq.insert(str.charAt(i));
				unarrpq.insert(str.charAt(i));
				arrpq.insert(str.charAt(i));
				unlistpq.insert(str.charAt(i));
				listpq.insert(str.charAt(i));
				lhpq.insert(str.charAt(i));
				nepq.insert(str.charAt(i));
			}
//			System.out.println(mpq.capacity());
		}
	}

}
