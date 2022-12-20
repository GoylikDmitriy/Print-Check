package check.io.printer.impl;

import check.io.printer.Printer;
import check.io.printer.exception.PrintException;
import check.model.Check;

import java.io.FileOutputStream;
import java.io.IOException;

public class FilePrinter implements Printer {
    private static final String FILE_NAME = "check.txt";
    @Override
    public void print(Check check) throws PrintException {
        try (FileOutputStream file = new FileOutputStream(FILE_NAME)) {
            file.write(Printer.prepareToPrint(check).getBytes());
        }
        catch (IOException e) {
            throw new PrintException(e);
        }
    }
}