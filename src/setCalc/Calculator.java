package setCalc;

//import java.util.StringTokenizer;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ask for user input and call calc(String instruction)

	}
	
	
	public void calc(String instruction){
		//StringTokenizer input = new StringTokenizer(instruction, " ");
		String[] commands = instruction.trim().split("\\s+");
		
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
	
	
	
	
	
	
	private void print(String s){
		System.out.println(s);
	}
	


}
