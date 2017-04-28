package setCalcTest;

import setCalc.*;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class NumericTest {

	@Test
	public void equals1() {
		Real real1=new Real(1);
		Rational rational1 = new Rational(1,1);
	
		Assert.assertEquals(true , real1.equals(rational1));
		Assert.assertEquals(true , rational1.equals(real1));
		
		Real real2=new Real(0.5);
		Rational rational2 = new Rational(1,2);
		Rational rational3 = new Rational(2,4);
		
		Assert.assertEquals(true , real2.equals(rational2));
		Assert.assertEquals(true , rational2.equals(rational3));
	}

	
	@Test
	public void equals2() {
		Real real2=new Real(0.5);
		Rational rational2 = new Rational(1,2);
		Rational rational3 = new Rational(2,4);
		
		Assert.assertEquals(true , real2.equals(rational2));
		Assert.assertEquals(true , rational2.equals(rational3));
	}
}
