package check.io.parser;

import check.io.reader.Reader;
import check.io.parser.exception.ParseException;

public interface Parser {
    Reader parse(String[] args) throws ParseException;
}