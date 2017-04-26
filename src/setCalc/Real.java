package setCalc;

class Real implements Numeric {
	private double _value;
	
	public Real(double value){
		this._value = value;
	}
	
	@Override
	public Real transformAdd(Numeric n) {
		_value = _value + n.convertToDouble();
		return this;
	}

	@Override
	public Real transformMul(Numeric n) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public double convertToDouble(){
		return getValue();
	}
	
	public double getValue(){
		return _value;
	}
	
	public void setValue(double value){
		this._value = value;
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
