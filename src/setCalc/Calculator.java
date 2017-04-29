package setCalc;

import java.lang.reflect.Method;
import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

//import java.util.StringTokenizer;

public class Calculator {

	public static void main(String[] args) {
		
		/*Scanner MyScanner = new Scanner(System.in);
	
		while(true){
			String instruction = MyScanner.next();
			
			calc(instruction);
		}*/
			
		/*
		 * Ariel's tests
		*
		*/
		 
		
		Set testSet = new Set();
		testSet.insert(new Real (1));
		testSet.insert(new Real (2));
		testSet.insert(new Real (3));
		testSet.insert(new Rational (1,3));
		/*Set insert = new Set();
		testSet.insert(insert);
		Set another = new Set();
		another.insert(new Set (new Real(3)));
		another.insert(new Real(1));
		another.insert(new Real(2));
		another.insert(insert);*/
		
		System.out.println(testSet);
		/*System.out.println(another);
		System.out.println(testSet.equals(another));*/
		
		//testSet.insert(new Rational (4,5));
		//System.out.println(testSet);
		System.out.println(testSet.power().size());	
		 /**/
		/*Set ratSet1 = new Set();
		ratSet1.insert(new Rational(1,2));ratSet1.insert(new Set ());ratSet1.insert(new Rational(3,2));ratSet1.insert(new Rational(4,2));ratSet1.insert(new Real(2));
		Set ratSet2 = new Set();
		ratSet2.insert(new Rational(3,2));ratSet2.insert(new Rational(1,2));ratSet2.insert(new Real(2));ratSet2.insert(new Set());
		System.out.println(ratSet1);
		System.out.println(ratSet2);
		System.out.println(ratSet1.equals(ratSet2));
		
		
		Set powerSet = new Set();
		Set subSet1 = new Set(); //empty set
		Set subSet2 = new Set(); subSet2.insert(new Real(0));	//{0}
		Set subSet3 = new Set(); subSet3.insert(new Rational(1,1));	//{1}
		Set subSet4 = new Set(); subSet4.insert(new Real(0)); subSet4.insert(new Rational(1,1)); //{0,1}
		powerSet.insert(subSet1); powerSet.insert(subSet2); powerSet.insert(subSet3); powerSet.insert(subSet4);
		
		
		Set newSet = new Set();
		Numeric[] numbers = new Numeric[]{
				new Real(0),
				new Rational(1,1),
			};
			
		for (Numeric n : numbers){
			newSet.insert(n);
		} 
		
		System.out.println(powerSet);
		Set ans = (newSet.power());
		System.out.println(ans);
		System.out.println(powerSet.equals(ans));*/
		
		
	}
	
	
	public static void calc(String instruction){		
		String[] commands = instruction.trim().split("\\s+");
		
		try
		{
			Class[] args1 = new Class[1];
	        args1[0] = String[].class;
			Method m = Calculator.class.getMethod(commands[0], new Class[]{String[].class});
			m.invoke(null, new Object[]{commands});
		}
		catch (Exception e)
        {
			print("Unknown command");
        }
		

		//END OF FUN :( 
		
		/*
		switch(commands[0].toLowerCase()){
		case "size":
			break;
			
		case "contains":
			break;
			
		case "member":
			break;
			
		case "deepexistance":
			break;
			
		case "equals":
			break;
			
		case "insert":
			break;
			
		case "remove":
			break;
			
		case "union":
			break;
			
		case "intersect":
			break;
			
		case "difference":
			break;
			
		case "power":
			break;
			
		case "transformAdd":
			break;
			
		case "transformMul":
			break;
			
		case "help":
			break;
			
		case "bonus":
			break;
			
		case "exit":
			break;
			
		default:
			print("Unknown command");
			break;
			
		}*/
		
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
		// TODO Auto-generated method stub
		return null;		
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
		print("test");
		return "test";
	}
	
	static public void exit(String[] input){
		
	}
	
	
	
	static private void print(String s){
		System.out.println(s);
	}
	


}

