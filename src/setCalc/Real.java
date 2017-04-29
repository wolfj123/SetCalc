package setCalc;
import java.util.regex.Pattern;

public class Real extends Numeric {
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
		//TODO - fix not writing 0
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
		Double ans;
		if (n instanceof Real)// in case of two real numbers
			ans=((Real)(n)).get_value()*_value;
		else
		{
			double num=n.convertToDouble();
			ans=_value*num;
		}
		return new Real(ans);
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
	
	public Object Clone(){
		return new Real (_value);
	}

}
