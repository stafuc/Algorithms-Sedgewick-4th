
public class SmartDate {
	private final int month;
	private final int day;
	private final int year;
	private static int[] DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	private static boolean isValid(int m, int d, int y){
		if(m < 1 || m > 12) return false;
		if(d < 1 || d > DAYS[m]) return false;
		if(m == 2 && d == 29 && !isLeapYear(y)) return false;
		return true;
	}
	
	private static boolean isLeapYear(int y){
		if(y % 400 == 0) return true;
		if(y % 100 == 0) return false;
		return y % 4 == 0;
	}
	
	public SmartDate(int m, int d, int y){
		if(!isValid(m, d, y)) throw new RuntimeException("invalid date!");
		month = m;
		day = d;
		year = y;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmartDate sd = new SmartDate(2, 29, 2003);
	}

}
