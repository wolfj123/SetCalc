package setCalcTest;

import setCalc.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void SetString() {
		String[] correctStrings = new String[] {
			"{}",
			"{1}",
			"{{}}",
			"{{1}}",
			"{1,2}",
			"{1,{1/2},{{}}}"
		};
		
		for(String s : correctStrings){
			Assert.assertEquals("Did not recgonize "+ s,true, Set.isValidString(s));
		}
		
		String[] incorrectStrings = new String[] {
			" {}",
			"{1}}",
			"{ 2}",
			"{,,}",
			"{1,}",
			"{,1 , }",
			};
		
		for(String s : incorrectStrings){
			Assert.assertEquals("Did not recgonize "+ s,false, Set.isValidString(s));
		}
	}
	
	
	@Test
	public void RealString() {
		String[] correctStrings = new String[] {
			"0",
			"1",
			"12",
			"1.5",
			"1.55",
			"0.60"
		};
		
		for(String s : correctStrings){
			Assert.assertEquals("Did not recgonize "+ s,true, Real.isValidString(s));
		}
		
		String[] incorrectStrings = new String[] {
			" 0",
			"0 ",
			"1.5.6",
			"18 9",
			"1..4",
			".5",
			};
		
		for(String s : incorrectStrings){
			Assert.assertEquals("Did not recgonize "+ s,false, Real.isValidString(s));
		}
	}
	
	@Test
	public void RationalString() {
		String[] correctStrings = new String[] {
			"0/2",
			"1/1",
			"0/2",
			"00/2",
			"123/123",
			"0/12313"
		};
		
		for(String s : correctStrings){
			Assert.assertEquals("Did not recgonize "+ s,true, Rational.isValidString(s));
		}
		
		String[] incorrectStrings = new String[] {
			" 0/2",
			"6 ",
			"1.5.6",
			"18 9",
			"1..4",
			".5",
			};
		
		for(String s : incorrectStrings){
			Assert.assertEquals("Did not recgonize "+ s,false, Rational.isValidString(s));
		}
	}

}
