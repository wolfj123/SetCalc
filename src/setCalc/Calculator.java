package setCalc;

import java.lang.reflect.Method;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

//import java.util.StringTokenizer;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set _testSet = new Set (new Set());
		System.out.println(_testSet);
		Set _secondSet = new Set ((new Real(1)));
		_secondSet.insert((new Real(2)));
		System.out.println(_secondSet);
		System.out.println("----------------");
		System.out.println(_secondSet.union(_secondSet));
		System.out.println(new Set().equals(new Real(1)));
		System.out.println(_secondSet.power());
		
		//ask for user input and call calc(String instruction)

	}
	
	
	public void calc(String instruction){
		//StringTokenizer input = new StringTokenizer(instruction, " ");
		
		String[] commands = instruction.trim().split("\\s+");
		
		/*THIS IS FOR FUN :) */
		
		Method m=this.getClass().getMethod(commands[0], String[]);
		
		
		/*END OF FUN :( */
		
		
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
		}
		
	}
	
	
	public void size(String[] input){
		
	}
	
	public void contains(String[] input){
		
	}
	
	public void member(String[] input){
		
	}
	
	public void deepexistance(String[] input){
		
	}
	
	public void equals(String[] input){
		
	}
	
	public void insert(String[] input){
		
	}
	
	public void union(String[] input){
		
	}
	
	public void remove(String[] input){
		
	}
	
	public void intersect(String[] input){
		
	}
	
	public void difference(String[] input){
		
	}
	
	public void power(String[] input){
		
	}
	
	public void transformAdd(String[] input){
		
	}
	
	public void transformMul(String[] input){
		
	}
	
	public void help(String[] input){
		
	}
	
	public void bonus(String[] input){
		
	}
	
	public void exit(String[] input){
		
	}
	
	
	
	private void print(String s){
		System.out.println(s);
	}
	


}
