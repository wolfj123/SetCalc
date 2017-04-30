package setCalc;
import java.lang.Cloneable;

public abstract class Numeric implements Element{
	
	public abstract Numeric transformAdd(Numeric n);
	
	public abstract Numeric transformMul(Numeric n);
	
	public abstract double convertToDouble();
	
	public abstract Object clone();
	
	@Override
	public boolean equals(Object other){
		if(!(other instanceof Rational) & !(other instanceof Real))
			return false;
		else{
			Numeric otherNum = (Numeric) other;
			return convertToDouble()==otherNum.convertToDouble();
		}
	}
}
