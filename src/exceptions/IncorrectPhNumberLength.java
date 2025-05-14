package exceptions;

public class IncorrectPhNumberLength extends Exception {
    static String message = "Enter a valid Phone number of 10 digits";

    public IncorrectPhNumberLength() {
        super(message);
    }
}
