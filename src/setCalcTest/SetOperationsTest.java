package setCalcTest;

import setCalc.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.ws.util.ReadAllStream;

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
			originalSet.insert(n);
		} 
		
		Assert.assertEquals("Insert: duplicate insert should not affect Set",originalSet.toString(),_set.toString() );
	}

	@Test
	public void testRemove() {
		Set answerSet = new Set ();
		Numeric[] numbers = new Numeric[]{
				new Real(0),
				
				new Rational(5,1)
			};
		_set.remove(new Rational(1,2));
		_set.remove(new Real(1));
		_set.remove(new Real(4));
		
		for (Numeric n : numbers){
			answerSet.insert(n);
		} 
		
		Assert.assertEquals("the set sholuden't have 1, 1/2",answerSet.toString(), _set.toString());

	}

	@Test
	public void testSize() {
		Assert.assertEquals("Size: size should be 4", 4, _set.size());
	}

	@Test
	public void testUnion() {
		// sets to unify
		Set set1 = new Set (new Real (1));
		Set set2 = new Set (new Rational(7, 2));
		Set set3 = new Set (new Set ());
		// unify sets
		_set.union(set1);
		_set.union(set2);
		_set.union(set3);
		// create right answer
		Set answerSet = new Set ();
		Numeric[] numbers = new Numeric[]{
				new Real(0),
				new Real(1),
				new Rational(1,2),
				new Rational(2,4),
				new Rational(5,1),
				new Rational(7, 2)
			};
		for (Numeric n : numbers){
			answerSet.insert(n);
		} 
		answerSet.insert(new Set ());
		
		Assert.assertEquals("the union set shuld be: ",answerSet.toString(),_set.toString());
	}
	


	@Test
	public void testIntersect() {
		Set newSet = new Set();
		Numeric[] numbers = new Numeric[]{
				new Real(3),
				new Rational(5,10),
				new Rational(6,4),
			};
			
		for (Numeric n : numbers){
			newSet.insert(n);
		} 
		
		
		Set finalSet = new Set();
		numbers = new Numeric[]{
				new Rational(2,4),
			};
			
		for (Numeric n : numbers){
			finalSet.insert(n);
		} 
		Assert.assertEquals("Intersection: _set should only contain 1/2",finalSet ,_set.intersect(newSet));
	}

	@Test
	public void testDifference() {
		Set correctAnsewerSet = new Set();
		Numeric[] numbers = new Numeric[]{
				new Real(0),
				new Rational(1,2),
				new Rational(5,1)
			};
			
		for (Numeric n : numbers){
			correctAnsewerSet.insert(n);
		} 
		
		Set differSet = new Set ();
		differSet.insert(new Real (1));
		differSet.insert(new Rational (7,2));
		differSet.insert(new Real (4));
		
		Set answerDiffer = _set.difference(differSet);
		
		Assert.assertEquals("the diiference dosen't work - answer should be "+ correctAnsewerSet + " actual answer is: "+ answerDiffer ,correctAnsewerSet, answerDiffer);

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
		Set subSet3 = new Set(); subSet3.insert(new Rational(1,1));	//{1}
		Set subSet4 = new Set(); subSet4.insert(new Real(0)); subSet2.insert(new Rational(1,1)); //{0,1}
		
		powerSet.insert(subSet1); powerSet.insert(subSet2); powerSet.insert(subSet3); powerSet.insert(subSet4);
		
		System.out.println(powerSet);
		System.out.println(newSet.power());
		
		Assert.assertEquals("Powerset: sets should be equal", powerSet, newSet.power());
	}

	@Test
	public void testContains() {
		
		Set check = new Set ();
		Numeric[] numbers = new Numeric[]{
				new Real(0),
				new Rational(1,2),
				new Rational(5,1)
			};
			
		for (Numeric n : numbers){
			check.insert(n);
		} 
		
		Assert.assertEquals("answer should be true", true ,_set.contains(check));
	}

	@Test
	public void testMember() {
		Element member = new Real(1);
		Assert.assertEquals("Member: 1 should be a member of the set",true,_set.member(member));
	}

	@Test
	public void testDeepExistence() {
		_set.insert(new Set(new Real(3)));
		
		Assert.assertEquals("answer should be true", true, _set.deepExistence(new Real (3)));
	}

	@Test
	public void testTransformAdd() {
		Set answerSet = new Set();

		Numeric[] numbersForAnswer = new Numeric[]{
				new Real(1),
				new Real(2),
				new Real(1.5),
			};
		
		for (Element e : numbersForAnswer){
			answerSet.insert(e);
		}
		
		_set = null;
		_set = new Set();
		Numeric[] numbers = new Numeric[]{
				new Real(0),
				new Real(1),
				new Rational(1,2),
			};
		
		for (Element e : numbers){
			_set.insert(e);
		}
		
		Assert.assertEquals("add dosen't work. answer should be "+answerSet +"" ,answerSet ,_set.transformAdd(new Real (1)));
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
				finalSet.insert(n);
			}
		
		Assert.assertEquals("TransformMul: set should be equal", finalSet,_set.transformMul(new Real(4)));
	}

}
