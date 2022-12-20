package check.io.parser.exception;

public class ParseException extends Exception {
    public ParseException(String message) {
        super(message);
    }
    public ParseException(Exception e) {
        super(e);
    }
    public ParseException(String message, Exception e) {
        super(message, e);
    }
}
