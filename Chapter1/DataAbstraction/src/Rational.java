
public class Rational {
	
	private final long numerator;
	private final long denominator;
	
	private static long gcd(long a, long b){
		if(b == 0) return a;
		return gcd(b, a % b);
	}
	
	public Rational(int numerator, int denominator){
		this((long)numerator, (long)denominator);
	}
	
	
	private Rational(long numerator, long denominator){
		assert Math.abs(numerator) < Integer.MAX_VALUE : "overflow";
		assert Math.abs(denominator) < Integer.MAX_VALUE : "overflow";
		
		if(numerator > Integer.MAX_VALUE){
			StdOut.println(Integer.MAX_VALUE);
			StdOut.println(numerator);
				
		}
		
		if(denominator == 0) throw new RuntimeException("denominator == 0!");
		
		if(denominator < 0){
			numerator = -numerator;
			denominator = -denominator;
		}
		
		long c = gcd(numerator, denominator);
		this.numerator = numerator / c;
		this.denominator = denominator / c;
	}
	
	public Rational plus(Rational b){
		return new Rational(this.numerator * b.denominator + this.denominator * b.numerator, this.denominator * b.denominator);
	}
	
	public Rational minus(Rational b){
		return new Rational(this.numerator * b.denominator - this.denominator * b.numerator, this.denominator * b.denominator);
	}
	
	public Rational times(Rational b){
		return new Rational(this.numerator * b.numerator, this.denominator * b.denominator);
	}
	
	public Rational divides(Rational b){
		return new Rational(this.numerator * b.denominator, this.denominator * b.numerator);
	}
	
	public boolean equals(Rational that){
		if(this == that) return true;
		if(that == null) return false;
		if(numerator != that.numerator) return false;
		if(denominator != that.denominator) return false;
		return true;
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rational a = new Rational(Integer.MAX_VALUE, 1);
		Rational b = new Rational(Integer.MAX_VALUE, 1);
		StdOut.println(a.times(b));

	}

}
