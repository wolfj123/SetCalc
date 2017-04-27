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
	}
	
	private boolean isValidString(String s){
		if(s == null || s.length()==0) //is empty or null
			return false;
		
		if(s.charAt(0)!='{' || s.charAt(s.length()-1)!='}') //is enclosed in {}
			return false;
		
		String elements[] = s.substring(1, s.length()-2).split(",");
		for (String e : elements){ //does not have legal elements
			if()	
		}

		
		
		return true;
	}

}
