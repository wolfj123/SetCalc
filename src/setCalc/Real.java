package setCalc;

import java.util.regex.Pattern;

public class Real implements Numeric {
	private double _value;
	
	public Real(double value){
		this._value = value;
	}
	
	
	public Real(String s){
		if(!isValidString(s))
			throw new IllegalArgumentException("Invalid String for Real");

		_value = Double.parseDouble(s);
	}
	
	static public String getRegEx(){
		//non java:  "(^[1-9]\d*+$)|(^[1-9]\d*\.\d+$)"
		return "(^[1-9]\\d*+$)|(^[1-9]\\d*\\.\\d+$)";
	}

	static public boolean isValidString(String s){
		return Pattern.matches(getRegEx(), s);
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
