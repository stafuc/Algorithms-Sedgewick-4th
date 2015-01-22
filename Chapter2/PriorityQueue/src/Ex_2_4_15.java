
public class Ex_2_4_15 {

	public static boolean isMinHeap(Comparable[] t) {
		for (int i = 1; 2 * i < t.length; i++) {
			int j = 2 * i;
			if(j + 1 < t.length && t[j].compareTo(t[j + 1]) > 0)	++j;
			if(t[i].compareTo(t[j]) > 0)	return false;
		}
		return true;
	}
	
	public static boolean isMaxHeap(Comparable[] t) {
		for (int i = 1; 2 * i < t.length; i++) {
			int j = 2 * i;
			if(j + 1 < t.length && t[j].compareTo(t[j + 1]) < 0)	++j;
			if(t[i].compareTo(t[j]) < 0)	return false;
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {1,2 ,3, 4, 5, 6, 7, 8};
		System.out.println(isMinHeap(a));

	}

}
