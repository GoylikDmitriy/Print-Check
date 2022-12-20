package check.io.printer;

import check.io.printer.impl.ConsolePrinter;
import check.io.printer.impl.FilePrinter;

import java.util.HashMap;
import java.util.Map;

public class PrinterProvider {
    private final Map<PrinterType, Printer> printers = new HashMap<>();
    public PrinterProvider() {
        this.printers.put(PrinterType.CONSOLE, new ConsolePrinter());
        this.printers.put(PrinterType.FILE, new FilePrinter());
    }

    public Printer getPrinter(PrinterType printerType) {
        return this.printers.get(printerType);
    }
}
