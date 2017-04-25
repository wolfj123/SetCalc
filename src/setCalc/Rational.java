package setCalc;

class Rational implements Numeric {
	private int a;
	private int b;
	
	public Rational(int a, int b){
		if(b==0)
			throw new IllegalArgumentException("Rational cannot have 0 as denominator");
		
		int gcd = gcd(a,b);
		this.a = a/gcd;
		this.b = b/gcd;
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
	
	private Real transformAdd(Real n) {
		return n.transformAdd(this);
	}

	private Real transformMul(Real n) {
		return n.transformMul(this);
	}
	
	private Rational transformAdd(Rational n) {
		return new Rational(getNumerator() + n.getNumerator(), 
				getDenominator() + n.getDenominator());
	}

	private Rational transformMul(Rational n) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public double convertToDouble(){
		return (double)a/(double)b;
	}
	
	public int getNumerator(){
		return a;
	}
	
	public int getDenominator(){
		return b;
	}
	
	
	@Override
	public String toString(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object other){
		// TODO Auto-generated method stub
		return false;
	}
	
	private int gcd(int a, int b) {
		if (b==0) return a;
		return gcd(b,a%b);
	}
	
}
