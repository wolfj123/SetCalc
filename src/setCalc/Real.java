package setCalc;

class Real implements Numeric {
	private double value;
	
	public Real(double value){
		this.value = value;
	}
	
	@Override
	public Real transformAdd(Numeric n) {
		return new Real(value + n.convertToDouble());
	}

	@Override
	public Real transformMul(Numeric n) {
		Real ans;
		if (n instanceof Real)// in case of two real numbers
			ans = new Real(this.getValue()*((Real)(n)).getValue());
		else
		{
			double num=n.convertToDouble();
			ans = new Real(this.getValue()*num);
		}
		return ans;
	}
	
	public double convertToDouble(){
		return getValue();
	}
	
	public double getValue(){
		return value;
	}
	
	public void setValue(double value){
		this.value = value;
	}
	
	
	@Override
	public String toString(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object other){
		if(!(other instanceof Real))
			return false;
		Real otherReal = (Real) other;
		return getValue()==otherReal.getValue();
	}
}
