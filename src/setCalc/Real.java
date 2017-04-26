package setCalc;

public class Real implements Numeric {
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
		Real ans;
		if (n instanceof Real)// in case of two real numbers
			_value*=((Real)(n)).get_value();
		else
		{
			double num=n.convertToDouble();
			_value*=num;
		}
		return this;
	}
	
	public double convertToDouble(){
		return get_value();
	}
	
	public double get_value(){
		return _value;
	}
	
	public void set_value(double value){
		this._value = value;
	}
	
	
	@Override
	public String toString(){
		return String.valueOf(_value);
	}
	
	@Override
	public boolean equals(Object other){
		if(!(other instanceof Real))
			return false;
		Real otherReal = (Real) other;
		return get_value()==otherReal.get_value();
	}
}
