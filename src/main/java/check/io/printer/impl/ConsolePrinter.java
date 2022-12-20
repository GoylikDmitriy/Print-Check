package check.io.printer.impl;

import check.io.printer.Printer;
import check.model.Check;

public class ConsolePrinter implements Printer {
    @Override
    public void print(Check check) {
        System.out.print(Printer.prepareToPrint(check));
    }
}