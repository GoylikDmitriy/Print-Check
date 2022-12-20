package check.io.reader.exception;

public class ReadException extends Exception {
    public ReadException(String message) {
        super(message);
    }
    public ReadException(Exception e) {
        super(e);
    }
    public ReadException(String message, Exception e) {
        super(message, e);
    }
}
