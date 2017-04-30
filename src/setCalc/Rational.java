package setCalc;


public class Rational extends Numeric {
	private int _a;
	private int _b;
	
	public Rational(int a, int b){
		if(b==0)
			throw new IllegalArgumentException("Rational cannot have 0 as denominator");
		
		int gcd = gcd(a,b);
		this._a = a/gcd;
		this._b = b/gcd;
	}
	
	
	public Rational(String s){
		if(!isValidString(s))
			throw new IllegalArgumentException("Invalid String for Rational");
		
		String contents[] = s.split("/");
		_a = Integer.parseInt(contents[0]);
		_b = Integer.parseInt(contents[1]);
	}
	
	static public String getRegEx(){
		//non java: "^[0-9]+\d*[\/][1-9]+\d*$"
		
		return "^[0-9]+\\d*[\\/][1-9]+\\d*$";
	}
	
	static public boolean isValidString(String s){
		//return Pattern.matches(getRegEx(), s);
		return s.matches(getRegEx());
	}
	
	@Override
	public Numeric transformAdd(Numeric n) {
		if(n instanceof Rational)
			return transformAdd((Rational)n);
		else
			return transformAdd((Real)n);
	}

	@Override
	public Numeric transformMul(Numeric n) {
		if(n instanceof Rational)
			return transformMul((Rational)n);
		else
			return transformMul((Real)n);
	}
	
	//This method does not change "this". it create a new Real and returns it
	private Real transformAdd(Real n) {
		return n.transformAdd(this);
	}

	//This method does not change "this". it create a new Real and returns it
	private Real transformMul(Real n) {
		return n.transformMul(this);
	}
	
	private Rational transformAdd(Rational n) {
		_a = getNumerator() + n.getNumerator(); 
		_b = getDenominator() + n.getDenominator();
		return new Rational(_a,_b);
	}

	private Rational transformMul(Rational n) {
		int ansA = getNumerator()*n.getNumerator(); // calculate numerator
		int ansB = getDenominator()*n.getDenominator(); // calculate denominator
		
		return new Rational (ansA,ansB);
	}
	
	@Override
	public double convertToDouble(){
		return (double)_a/(double)_b;
	}
	
	public int getNumerator(){
		return _a;
	}
	
	public int getDenominator(){
		return _b;
	}
	
	
	@Override
	public String toString(){
		if (_b!=1)
			return (_a+"/"+_b);
		else
			return (String.valueOf(_a));
	}
	
	
	private int gcd(int a, int b) {
		if (b==0) return a;
		return gcd(b,a%b);
	}
	
	public Object clone(){
		
		return new Rational(_a,_b); 
	}
	
}
