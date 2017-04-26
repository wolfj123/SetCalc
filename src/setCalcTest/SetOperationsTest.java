package setCalcTest;

import setCalc.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetOperationsTest {
	private Set _set;
	
	
	@Before
	public void setUp() throws Exception {
		_set = new Set();
		Numeric[] numbers = new Numeric[]{
			new Real(0),
			new Real(1),
			new Rational(1,2),
			new Rational(2,4),
			new Rational(5,1)
		};
		
		for (Numeric n : numbers){
			_set.insert(n);
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		Numeric toInsert = new Rational(1,2);
		_set.insert(toInsert);
		
		Set originalSet = new Set();
		Numeric[] numbers = new Numeric[]{
				new Real(0),
				new Real(1),
				new Rational(1,2),
				new Rational(2,4),
				new Rational(5,1)
			};
			
			for (Numeric n : numbers){
				_set.insert(n);
			} 
		
		Assert.assertEquals("duplicate insert should not affect Set",_set.toString(),originalSet.toString() );
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnion() {
		fail("Not yet implemented");
	}

	@Test
	public void testIntersect() {
		fail("Not yet implemented");
	}

	@Test
	public void testDifference() {
		fail("Not yet implemented");
	}

	@Test
	public void testPower() {
		fail("Not yet implemented");
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	@Test
	public void testMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeepExistence() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransformAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransformMul() {
		fail("Not yet implemented");
	}

}
