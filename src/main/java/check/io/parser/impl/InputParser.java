package check.io.parser.impl;

import check.io.parser.exception.ParseException;
import check.io.reader.Reader;
import check.io.reader.impl.ConsoleReader;
import check.io.reader.impl.FileReader;
import check.io.parser.Parser;
public class InputParser implements Parser {
    private static final String DOT = ".";
    private static final String DASH = "-";
    private static final String DATABASE = "database";
    @Override
    public Reader parse(String[] args) throws ParseException {
        if (args.length == 0) {
            throw new ParseException("No purchases found.");
        }
        String[] params;
        Reader reader;
        if (args.length > 1 && args[0].contains(DOT) && args[1].contains(DOT)) {
            reader = new FileReader(args[0], args[1]);
            params = new String[args.length - 2];
            System.arraycopy(args, 2, params, 0, args.length - 2);
        }
        else if (args[0].equals(DATABASE)) {
            reader = null;
            params = null;
        }
        else if (args[0].contains(DASH)) {
            reader = new ConsoleReader();
            params = args;
        }
        else {
            throw new ParseException("Can't return reader. Incorrect input data.");
        }

        reader.setParams(params);
        return reader;
    }
}