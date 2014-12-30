
public class Ex_2_3_5 {

	public static void sort(Comparable[] a) {
		int i = 0, j = a.length - 1;
		while(i < j){
			if(i == 0 || a[i] == a[i - 1])	i++;
			else{
				exch(a, i, j--);
			}
		}
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void show(Comparable[] a) {
		String s = "";
		for (Comparable c : a) {
			s += c + " ";
		}
		StdOut.println(s);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = new Integer[10];
		for (int i = 0; i < a.length; i++) {
			if(StdRandom.uniform() < 0.5)	a[i] = 1;
			else a[i] = 2;
		}
		sort(a);
		show(a);
	}

}
