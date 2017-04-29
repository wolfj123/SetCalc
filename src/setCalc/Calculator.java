package setCalc;

import java.lang.reflect.Method;
import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

//import java.util.StringTokenizer;

public class Calculator {

	public static void main(String[] args) {
		
		Scanner MyScanner = new Scanner(System.in);
	
		while(true){
			String instruction = MyScanner.next();
			
			calc(instruction);
		}
			
		
		
		
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

