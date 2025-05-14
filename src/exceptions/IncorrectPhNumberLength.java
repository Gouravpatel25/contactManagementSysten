package exceptions;

public class IncorrectPhNumberLength extends Exception {
static String message = "The Phone number is not of correct length";
	
	public IncorrectPhNumberLength() {
		//super(message);
		System.out.println(message);
	}
}
