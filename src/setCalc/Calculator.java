package setCalc;

import java.lang.reflect.Method;
import java.util.Scanner;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

//import java.util.StringTokenizer;

public class Calculator {

	public static void main(String[] args) {
		
		Scanner MyScanner = new Scanner(System.in);
	
		while(true){
			String instruction = MyScanner.nextLine();
			
			String output = calc(instruction);
			print(output);
		}
	}
	
	
	public static String calc(String instruction){		
		String[] commands = instruction.trim().split("\\s+");

		String output = "Unknown command";
		
		
		//attempt calling the method by name
		try
		{
			Class[] args1 = new Class[1];
	        args1[0] = String[].class;
			Method m = Calculator.class.getMethod(commands[0], new Class[]{String[].class});
			output = (String) m.invoke(null, new Object[]{commands});
		}
		catch (Exception e)
        {
			return ("Unknown command" + e.getMessage());
        }
		
		return output;
		
	}
	
	
	static public String size(String[] input){
		// TODO Auto-generated method stub
		return null;
	}
	
	static public String contains(String[] input){
		// TODO Auto-generated method stub
		return null;
	}
	
	static public String member(String[] input){
		// TODO Auto-generated method stub
		return null;
	}
	
	static public String deepexistance(String[] input){
		// TODO Auto-generated method stub
				return null;
	}
	
	static public String equals(String[] input){
		// TODO Auto-generated method stub
		return null;		
	}
	
	static public String insert(String[] input){
		// TODO Auto-generated method stub
		return null;		
	}
	
	static public String union(String[] input){
		// TODO Auto-generated method stub
		return null;		
	}
	
	static public String remove(String[] input){
		//verify input
		if(input.length!=3 || !isSet(input[1]) || !isElement(input[2]))
			return "Illegal Parameters";
		//create elements
		Set set = createSet(input[1]);
		Element e = createElement(input[2]);
		
		return set.remove(e).toString();		
	}
	
	static public String intersect(String[] input){
		// TODO Auto-generated method stub
		return null;		
	}
	
	static public String difference(String[] input){
		// TODO Auto-generated method stub
		return null;		
	}
	
	static public String power(String[] input){
		// TODO Auto-generated method stub
		return null;		
	}
	
	static public String transformAdd(String[] input){
		// TODO Auto-generated method stub
		return null;		
	}
	
	static public String transformMul(String[] input){
		// TODO Auto-generated method stub
		return null;		
	}
	
	static public String help(String[] input){
		// TODO Auto-generated method stub
		return null;		
	}
	
	static public String bonus(String[] input){
		// TODO Auto-generated method stub
		//print("test");
		return "test";
	}
	
	static public String exit(String[] input){
		// TODO Auto-generated method stub
		return "Goodbye!";
	}
	
	
	
	static private void print(String s){
		System.out.println(s);
	}
	
	static private boolean isSet(String s){
		return Set.isValidString(s);
	}

	static private boolean isElement(String s){
		return (Set.isValidString(s) | Real.isValidString(s) | Rational.isValidString(s));
	}

	static private boolean isNumeric(String s){
		return (Real.isValidString(s) | Rational.isValidString(s));
	}
	
	static private Set createSet(String s){
		if(!isSet(s))
			return null;
		
		return new Set(s);
	}
	
	static private Numeric createNumeric(String s){
		
		if(Real.isValidString(s))
			return new Real(s);
		if(Rational.isValidString(s))
			return new Rational(s);

		return null;
	}
	
	static private Element createElement(String s){
		if(isNumeric(s))
			return createNumeric(s);
		if(isSet(s))
			return createSet(s);
	
		return null;
	}
	

}
