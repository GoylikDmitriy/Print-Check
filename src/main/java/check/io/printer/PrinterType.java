package check.io.printer;

public enum PrinterType {
    CONSOLE, FILE, DATABASE;
    public static PrinterType getPrinterType(int id) {
        return switch (id) {
            case 1 -> PrinterType.CONSOLE;
            case 2 -> PrinterType.FILE;
            case 3 -> PrinterType.DATABASE;
            default -> PrinterType.CONSOLE;
        };
    }
}
