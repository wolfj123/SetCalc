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
		
		Assert.assertEquals("Insert: duplicate insert should not affect Set",originalSet.toString(),_set.toString() );
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testSize() {
		Assert.assertEquals("Size: size should be 5", 5, _set.size());
	}

	@Test
	public void testUnion() {
		Set emtpySet = new Set();
		Set set1 = new Set(); set1.insert(new Real(1));
		
		Set expectedUnionSet = new Set(); 
		expectedUnionSet.insert(emtpySet); expectedUnionSet.insert(set1); 
		
		Set containEmpty = new Set(); containEmpty.insert(emtpySet);
		
		Assert.assertEquals("Union: sets should match",  expectedUnionSet, containEmpty.union(expectedUnionSet));
		System.out.println("test");
	}

	@Test
	public void testIntersect() {
		Set newSet = new Set();
		Numeric[] numbers = new Numeric[]{
				new Real(3),
				new Real(5),
				new Rational(1,2),
				new Rational(6,4),
			};
			
		for (Numeric n : numbers){
			_set.insert(n);
		} 
		
		
		Set finalSet = new Set();
		numbers = new Numeric[]{
				new Rational(2,4),
			};
			
		for (Numeric n : numbers){
			_set.insert(n);
		} 
		
		Assert.assertEquals("Intersection: _set should only contain 1/2",finalSet ,_set.intersect(newSet));
		
	}

	@Test
	public void testDifference() {
		fail("Not yet implemented");
	}

	@Test
	public void testPower() {
		Set newSet = new Set();
		Numeric[] numbers = new Numeric[]{
				new Real(0),
				new Rational(1,1),
			};
			
		for (Numeric n : numbers){
			newSet.insert(n);
		} 
		
		Set powerSet = new Set();
		Set subSet1 = new Set(); //empty set
		Set subSet2 = new Set(); subSet2.insert(new Real(0));	//{0}
		Set subSet3 = new Set(); subSet2.insert(new Rational(1,1));	//{1}
		Set subSet4 = new Set(); subSet2.insert(new Real(0)); subSet2.insert(new Rational(1,1)); //{0,1}
		
		powerSet.insert(subSet1); powerSet.insert(subSet2); powerSet.insert(subSet3); powerSet.insert(subSet4);
		
		Assert.assertEquals("Powerset: sets should be equal", powerSet, newSet);
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	@Test
	public void testMember() {
		Element member = new Real(1);
		Assert.assertEquals("Member: 1 should be a member of the set",true,_set.member(member));
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
		Set finalSet = new Set();
		Numeric[] numbers = new Numeric[]{
				new Real(0),
				new Real(4),
				new Rational(4,2),
				new Rational(20,1)
			};
			
			for (Numeric n : numbers){
				_set.insert(n);
			}
		
		Assert.assertEquals("TransformMul: set should be equal", finalSet,_set.transformMul(new Real(4)));
	}

}
