package setCalc;

import java.io.File;
import java.io.IOException;
//import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

//import com.sun.org.apache.regexp.internal.REUtil;

//import sun.security.mscapi.KeyStore.MY;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

//import java.util.StringTokenizer;

public class Calculator {

	public static void main(String[] args) {
		System.out.println("Sets Calculator" +"\n" + "==========================");
		Scanner MyScanner = new Scanner(System.in);
	
		
		while(true){
			String instruction = MyScanner.nextLine();
			
			String output = calc(instruction);
			print(output);
		}
	}
	
	
	public static String calc(String instruction){		
		String[] commands = instruction.trim().split("\\s+");

		String output;
		switch(commands[0].toLowerCase()){
		case "size":
			output = size(commands);
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
			//TODO
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
		
		return output;
		//attempt calling the method by name
				/*
				try
				{
					Class[] args1 = new Class[1];
					Method m = Calculator.class.getMethod(commands[0], new Class[]{String[].class});
					output = (String) m.invoke(null, new Object[]{commands});
				}
				catch (Exception e)
		        {
					return ("Unknown command " + e.getMessage());
		        }
				
				*/
		
	}
	
	
	static public String size(String[] input){

		String setInput = convertArrToSet(input); // create string of supposed set input
		if ((input.length<1)||!isSet(setInput)){ // check if input is a set
			return "Illegal Parameters";
		}
		Set sizeSet = createSet(setInput);
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
		if ((input.length<1)){ // check if input is a set
			return "Illegal Parameters";
		}
		String [] updateInput = converToSetAndNum (input);
		if (!isSet(updateInput[0])| (!isNumeric(updateInput[1]))){
			return "Illegal Parameters";
		}
		Set setInput = createSet(updateInput[0]);
		Numeric num = createNumeric(updateInput[1]);
		if (setInput.member(num)){
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
		// TODO Auto-generated method stub
		return null;		
	}
	
	static public String insert(String[] input){
		if ((input.length<1)){ // check if input is a set
			return "Illegal Parameters";
		}
		String [] updateInput = converToSetAndNum (input);
		if (!isSet(updateInput[0])| (!isNumeric(updateInput[1]))){
			return "Illegal Parameters";
		}
		Set setInput = createSet(updateInput[0]);
		Numeric num = createNumeric(updateInput[1]);
		
		Set ans = setInput.insert(num);
		
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
		if ((input.length<1)){ // check if input is a set
			return "Illegal Parameters";
		}
		String [] updateInput = convertArrToTwoSets(input);
		if (!isSet(updateInput[0])| (!isSet(updateInput[1]))){
			return "Illegal Parameters";
		}
		// create sets
		Set set1 = createSet(updateInput[0]);
		Set set2 = createSet(updateInput[1]);
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
		String setInput = convertArrToSet(input); // create string of supposed set input
		if ((input.length<1)||!isSet(setInput)){ // check if input is a set
			return "Illegal Parameters";
		}
		Set powerSet = createSet(setInput);
		// calculate power 
		Set ans = powerSet.power();
		
		return ans.toString();		
	}
	
	static public String transformAdd(String[] input){
		//verify input
		if(input.length!=3 || !isSet(input[1]) || !isNumeric(input[2]))
			return "Illegal Parameters";
		//create elements
		Set set = createSet(input[1]);
		Numeric n = createNumeric(input[2]);
		
		return set.transformAdd(n).toString();		
	}
	
	static public String transformMul(String[] input){
		if ((input.length<1)){ // check if input is a set
			return "Illegal Parameters";
		}
		String [] updateInput = converToSetAndNum (input);
		if (!isSet(updateInput[0])| (!isNumeric(updateInput[1]))){
			return "Illegal Parameters";
		}
		Set setInput = createSet(updateInput[0]);
		Numeric num = createNumeric(updateInput[1]);
		//calculate multiplication
		Set ans = setInput.transformMul(num);
		
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
	
	
	// convert input string array into char array with no command
	static private char[] arrToCharArray (String [] input){
		
		String inputStr = "";
		for (int i=1; i<input.length ; i++){
			inputStr+=input[i];
		}
		
		
		char [] ans = new char [inputStr.length()];
		for (int i= 0; i< inputStr.length(); i++){
			ans[i]=inputStr.charAt(i);
		}
		
		
		return ans;
	}

	// converts string array input into one set String
	static private String convertArrToSet(String [] input){
		String ans=new String();
		char [] charInput = arrToCharArray(input);
		Stack<Integer> parenthesisStack = new Stack<Integer>(); // 0 - open parenthesis, 1- close parenthesis
		boolean balanced=true;
		// go through entire input
		for (int i=0;i<charInput.length & balanced;i++){
			ans+=charInput[i];
			// update parenthesis stack for balance
			if (charInput[i] =='{'){
				parenthesisStack.push(0);
			}
			if (charInput[i]=='}'){
				if ((!parenthesisStack.peek().equals(0))){ // check if unbalanced
					balanced=false;
					ans ="X";
				}
				else{
					parenthesisStack.pop();
				}
			}
		}
		if (!parenthesisStack.isEmpty()){
			return "X";
		}
		return ans;
	}
	// converts string array input into two sets Strings
	static private String [] convertArrToTwoSets(String [] input){
		String [] ans={"",""};
		char [] charInput = arrToCharArray(input);
		Stack<Integer> parenthesisStack = new Stack<Integer>(); // 0 - open parenthesis, 1- close parenthesis
		boolean balanced=true;
		int setNum =0;
		// go through input
		for (int i=0;i<charInput.length & balanced & setNum<ans.length;i++){
			
			if (charInput[i] =='{'){
				parenthesisStack.push(0);
				ans[setNum]+=charInput[i]; // put opening parenthesis to String
			}
			
			else if (charInput[i] =='}'){
				ans[setNum]+=charInput[i]; // put opening parenthesis to String
				if ((!parenthesisStack.peek().equals(0))){
					balanced=false;
					ans[setNum] ="X";
					setNum++; // unbalanced Set go to next one
				}
				else{
					parenthesisStack.pop();
				}
			}
			else {
				ans[setNum]+=charInput[i];
			}
			
			if (parenthesisStack.isEmpty()){ // stack empty means finish first set
				setNum++;
			}
		}

		
		return ans;
	}
	//converts  string array input into a set and a num Strings
	static private String [] converToSetAndNum (String [] input){
		String [] ans={"",""};
		char [] charInput = arrToCharArray(input);
		Stack<Integer> parenthesisStack = new Stack<Integer>(); // 0 - open parenthesis, 1- close parenthesis
		boolean finishedSet=false;
		int setNum =0;
		// go through input to create Set String
		for (int i=0;i<charInput.length  & setNum<ans.length;i++){
			if (!finishedSet){ // create Set String
				if (charInput[i] =='{'){
					parenthesisStack.push(0);
					ans[setNum]+=charInput[i]; // put opening parenthesis to String
				}
				
				else if (charInput[i] =='}'){
					ans[setNum]+=charInput[i]; // put opening parenthesis to String
					if ((!parenthesisStack.peek().equals(0))){
						finishedSet=false;
						ans[setNum] ="X";
						setNum++;
					}
					else{
						parenthesisStack.pop();
					}
				}
				else if (parenthesisStack.isEmpty()){ // stack empty means finish first set
					finishedSet=true;
					setNum++;
					ans[setNum]+=charInput[i];
				}
				else {
					ans[setNum]+=charInput[i];
				}
			}
			else{
				ans[setNum]+=charInput[i];
			}

		}
		
		
		
		return ans;
	}
}
