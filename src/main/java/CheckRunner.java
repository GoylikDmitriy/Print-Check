import check.io.printer.Printer;
import check.io.printer.PrinterProvider;
import check.io.printer.PrinterType;
import check.io.reader.Reader;
import check.io.reader.exception.ReadException;
import check.model.Purchase;
import check.io.parser.Parser;
import check.io.parser.exception.ParseException;
import check.io.parser.impl.InputParser;
import check.model.service.CheckService;
import check.model.service.exception.ServiceException;

import java.util.List;

public class CheckRunner {
    private static final PrinterProvider printerProvider = new PrinterProvider();
    private static final Parser parser = new InputParser();

    public static void main(String[] args) {
        try {
            System.out.print("Where to print a check?(console by default.)\n1.Console.\n2.File.\n");
            int id = new java.util.Scanner(System.in).nextInt();
            Printer printer = printerProvider.getPrinter(PrinterType.getPrinterType(id));
            Reader reader = parser.parse(args);
            List<Purchase> purchases = reader.read();
            CheckService.addAllPurchases(purchases);
            CheckService.printCheck(printer);
        }
        catch (ServiceException | ParseException | ReadException e) {
            System.out.println(e.getMessage());
        }
    }
}