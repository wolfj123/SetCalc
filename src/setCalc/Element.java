package setCalc;
import java.lang.Cloneable;
public interface Element extends Cloneable {
	
	public Element transformAdd(Numeric n);
	
	public Element transformMul(Numeric n);
	
	public Object Clone();
}
