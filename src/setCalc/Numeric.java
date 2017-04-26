package setCalc;

public interface Numeric extends Element{
	
	public Numeric transformAdd(Numeric n);
	
	public Numeric transformMul(Numeric n);
	
	public double convertToDouble();
}
