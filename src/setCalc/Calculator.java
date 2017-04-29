package setCalc;

import java.lang.reflect.Method;
import java.util.Scanner;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

//import java.util.StringTokenizer;

public class Calculator {

	public static void main(String[] args) {
		
		Scanner MyScanner = new Scanner(System.in);
	
		while(true){
			String instruction = MyScanner.next();
			
			String output = calc(instruction);
			print(output);
		}
	}
	
	
	public static String calc(String instruction){		
		String[] commands = instruction.trim().split("\\s+");
		String output = "Unknown command";
		
		try
		{
			Class[] args1 = new Class[1];
	        args1[0] = String[].class;
			Method m = Calculator.class.getMethod(commands[0], new Class[]{String[].class});
			output = (String) m.invoke(null, new Object[]{commands});
		}
		catch (Exception e)
        {
			return ("Unknown command");
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
	


}
