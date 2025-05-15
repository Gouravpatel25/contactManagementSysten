package exceptions;

public class IncorrectNameFormatException extends Exception {
    static String message = " Enter a correct name,  no special characters allowed";

    public IncorrectNameFormatException() {
        super(message);
    }
}
