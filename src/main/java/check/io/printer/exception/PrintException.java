package check.io.printer.exception;

public class PrintException extends Exception {
    public PrintException(String message) {
        super(message);
    }
    public PrintException(Exception e) {
        super(e);
    }
    public PrintException(String message, Exception e) {
        super(message, e);
    }
}
