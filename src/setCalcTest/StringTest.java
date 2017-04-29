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
			//Assert.assertEquals("Did not recgonize "+ s,true, Set.isValidString(s));
		}
		
		String[] incorrectStrings = new String[] {
		//" {}",
		//"{1}}",
		//"{ 2}",
		"{,,}",
		"{1,}",
		"{,1}",
			};
		
		for(String s : incorrectStrings){
			Assert.assertEquals("Did not recgonize "+ s,false, Set.isValidString(s));
		}
	}

}
