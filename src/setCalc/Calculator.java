package setCalc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;


public class Calculator {

	public static void main(String[] args) {
		System.out.println("Sets Calculator" +"\n" + "==========================");
		System.out.println(help(null));
		Scanner MyScanner = new Scanner(System.in);
	
		
		while(true){
			String instruction = MyScanner.nextLine();
			
			//String output = calc(instruction);
			calc(instruction);
			//print(output);
		}
	}
	
	
	public static void calc(String instruction){		
		String[] commands = instruction.trim().split("\\s+");

		String output;
		switch(commands[0]){
		case "size":
			output = size(commands);
			print(output);
			break;
			
		case "contains":
			output = contains(commands);
			break;
			
		case "member":
			output = member(commands);
			break;
			
		case "deepexistance":
			output = deepexistance(commands);
			break;
			
		case "equals":
			output = equals(commands);
			break;
			
		case "insert":
			output = insert(commands);
			break;
			
		case "remove":
			output = remove(commands);
			break;
			
		case "union":
			output = union(commands);
			break;
			
		case "intersect":
			output = intersect(commands);
			break;
			
		case "difference":
			output = difference(commands);
			break;
			
		case "power":
			output = power(commands);
			break;
			
		case "transformAdd":
			output = transformAdd(commands);
			break;
			
		case "transformMul":
			output = transformMul(commands);
			break;
			
		case "help":
			output = help(commands);
			break;
			
		case "bonus":
			try{
				output = bonus(commands);
			}
			catch (Exception e) {
				output = e.getMessage();
			}
			break;
			
		case "exit":
			output = exit(commands);
			break;
			
		default:
			output = "Unknown command";
			break;
			
		}
		
		print(output);	
	}
	
	
	static public String size(String[] input){
		if ((input.length!=2)||!isSet(input[1])){ // check if input is a set
			return "Illegal Parameters";
		}
		Set sizeSet = createSet(input[1]);
		Integer size = sizeSet.size();
		return size.toString();
	}
	
	static public String contains(String[] input){
		//verify input
		if(input.length!=3 || !isSet(input[1]) || !isSet(input[2]))
			return "Illegal Parameters";
		//create elements
		Set set1 = createSet(input[1]);
		Set set2 = createSet(input[2]);
		
		boolean output = set1.contains(set2);	
		if(output)
			return "True";
		else return "False";
	}
	
	static public String member(String[] input){
		if ((input.length!=3)|| (!isSet(input[1])| (!isElement(input[2])))){ // check if input is a set
			return "Illegal Parameters";
		}
		
		Set set = createSet(input[1]);
		Element mem = createElement(input[2]);
		if (set.member(mem)){
			return "True";
		}
		else {
			return "False";
		}
	}
	
	static public String deepexistance(String[] input){
		//verify input
		if(input.length!=3 || !isSet(input[1]) || !isElement(input[2]))
			return "Illegal Parameters";
		//create elements
		Set set = createSet(input[1]);
		Element e = createElement(input[2]);
		
		boolean output = set.deepExistence(e);	
		if(output)
			return "True";
		else return "False";
	}
	
	static public String equals(String[] input){
		if ((input .length<3)|| (!isElement(input[1])| (!isElement(input[2])))){
			return "Illegal Parameters";
		}
		Element e1= createElement(input[1]);
		Element e2= createElement(input[2]);
		if (e1.equals(e2)){
			return "True";
		}
		else {
			return "False";
		}
	}
	
	static public String insert(String[] input){
		if ((input.length!=3) || (!isElement(input[1]) | (!isElement(input[2]) )) ){ // check if input is a set
			return "Illegal Parameters";
		}

		Set setInput = createSet(input[1]);
		Element toInsert = createElement(input[2]);
		
		Set ans = setInput.insert(toInsert);
		
		return ans.toString();		
	}
	
	static public String union(String[] input){
		//verify input
		if(input.length!=3 || !isSet(input[1]) || !isSet(input[2]))
			return "Illegal Parameters";
		//create elements
		Set set1 = createSet(input[1]);
		Set set2 = createSet(input[2]);
		
		return set1.union(set2).toString();		
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
		if ((input.length!=3) || (!isSet(input[1])) | (!isSet(input[2])) ){ // check if input is a set
			return "Illegal Parameters";
		}

		Set set1 = createSet(input[1]);
		Set set2 = createSet(input[2]);
		//intersect
		Set ans = set1.intersect(set2);
		
		return ans.toString();		
	}
	
	static public String difference(String[] input){
		//verify input
		if(input.length!=3 || !isSet(input[1]) || !isSet(input[2]))
			return "Illegal Parameters";
		//create elements
		Set set1 = createSet(input[1]);
		Set set2 = createSet(input[2]);
		
		return set1.difference(set2).toString();			
	}
	
	static public String power(String[] input){
		
		if ((input.length!=2)||!isSet(input[1])){ // check if input is a set
			return "Illegal Parameters";
		}
		Set powerSet = createSet(input[1]);
		// calculate power 
		Set ans = powerSet.power();
		
		return ans.toString();		
	}
	
	static public String transformAdd(String[] input){
		//verify input
		if(input.length!=3 || !isElement(input[1]) || !isNumeric(input[2]))
			return "Illegal Parameters";
		//create elements
		Element element = createElement(input[1]);
		Numeric n = createNumeric(input[2]);
		
		return element.transformAdd(n).toString();		
	}
	
	static public String transformMul(String[] input){
		if ((input.length!=3) || (!isElement(input[1])) | (!isElement(input[2])) ){ // check if input is a set
			return "Illegal Parameters";
		}
		

		Element e1 = createElement(input[1]);
		Numeric e2 = createNumeric(input[2]);
		//calculate multiplication
		Element ans = e1.transformMul(e2);
		
		return ans.toString();		
	}
	
	static public String help(String[] input){

		String print = "size <set>" + "\n" + "contains <set> <set>"+ "\n" + "member <set> <element>" + "\n" +
		"deepexistance <set> <element> " + "\n" + "equals <element> <element>" + "\n" + "insert <set> <element>" + "\n" +
				"remove <set> <element>" + "\n" + "union <set> <set>" + "\n" + "intersect <set> <set>" + "\n" +
		"difference <set> <set>" + "\n" + "power <set>"+ "\n" + "transformAdd <element> <numeric>"+ "\n" +
				"transformMul <element> <numeric>" + "\n" +"help"+ "\n" +"bonus" + "\n" +"exit";
		return print;		
	}
	
	static public String bonus(String[] input) throws IOException {	
		//TODO
	    String content = new String(Files.readAllBytes(Paths.get("bonus.txt")));

		return content;
	}
	
	static public String exit(String[] input){
		System.exit(0);
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
		return Set.createElementFromString(s);
	}
	
}
