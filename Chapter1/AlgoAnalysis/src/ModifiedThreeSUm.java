
public class ModifiedThreeSUm {

	public static int add(int a, int b) throws Exception{ 
		if(a > 0 && b > 0 && a > Integer.MAX_VALUE - b)	throw new Exception("overflow");			
		if(a < 0 && b < 0 && a < Integer.MIN_VALUE - b) throw new Exception("overflow");
		return a + b;
	}
	
	public static int count(int[] a){
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = j + 1; k < a.length; k++) {
					try {
						int temp = add(a[i], a[j]);
						if(add(temp, a[k]) == 0)	cnt++;
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		}
		return cnt;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = In.readInts(args[0]);
		StdOut.println(count(a));
		StdOut.println(Integer.MAX_VALUE);
	}

}
