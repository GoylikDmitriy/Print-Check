import check.io.parser.Parser;
import check.io.parser.exception.ParseException;
import check.io.parser.impl.InputParser;
import check.io.reader.Reader;
import check.io.reader.impl.ConsoleReader;
import check.io.reader.impl.FileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTest {
    Parser parser = new InputParser();
    private final String PRODUCTS_FILE = "data/products.txt";
    private final String CARDS_FILE = "data/cards.txt";

    @Test
    public void emptyStringInArgs() {
        try {
            parser.parse(new String[] {});
            Assertions.fail("ParseException expected.");
        }
        catch (ParseException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void secondParamIsNotFile() {
        try {
            parser.parse(new String[]{PRODUCTS_FILE, "1-1"});
            Assertions.fail("ParseException expected.");
        }
        catch (ParseException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void returnFileReader() throws ParseException {
        Reader r = parser.parse(new String[] {PRODUCTS_FILE, CARDS_FILE});
        Assertions.assertEquals(FileReader.class, r.getClass());
    }

    @Test
    public void returnConsoleReader() throws ParseException {
        Reader r = parser.parse(new String[] {"1-1"});
        Assertions.assertEquals(ConsoleReader.class, r.getClass());
    }
}
