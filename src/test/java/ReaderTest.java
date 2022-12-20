import check.io.reader.Reader;
import check.io.reader.exception.ReadException;
import check.io.reader.impl.ConsoleReader;
import check.io.reader.impl.FileReader;
import check.model.Product;
import check.model.Purchase;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class ReaderTest {
    private final Reader consoleReader = new ConsoleReader();
    private Reader fileReader;
    private final String PRODUCTS_FILE = "data/products.txt";
    private final String CARDS_FILE = "data/cards.txt";
    private final String NOTFOUND = "notfound.txt";
    private final Purchase purchase = new Purchase();
    private final List<Purchase> purchases = new ArrayList<>();

    @Test
    public void consoleReaderPurchaseWithExistingProduct() {
        consoleReader.setParams(new String[] { "1-1" });
        purchase.setProduct(Product.builder()
                .setId(1)
                .setName("Bread")
                .setPrice(1.09f)
                .build()
        );

        purchase.setQuantity(1);
        purchases.add(purchase);
        List<Purchase> purchaseList;
        try {
            purchaseList = consoleReader.read();
            Assertions.assertEquals(1, purchaseList.size());
            Assertions.assertEquals(purchases.get(0), purchaseList.get(0));
        } catch (ReadException e) {
            Assertions.fail("Unexpected exception.");
        }
    }

    @Test
    public void consoleReaderPurchaseWhereProductIdNotFound() {
        consoleReader.setParams(new String[] { "11-1" });
        try {
            consoleReader.read();
            Assertions.fail("ReadException expected.");
        }
        catch (ReadException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void consoleReaderPurchaseWhereQuantityZero() {
        consoleReader.setParams(new String[] { "1-0" });
        try {
            Assertions.assertEquals(0, consoleReader.read().size());
        }
        catch (ReadException e) {
            Assertions.fail("Unexpected exception.");
        }
    }

    @Test
    public void consoleReaderPurchaseWithDiscountCard() {
        consoleReader.setParams(new String[] {"1-1", "card-1234"});
        try {
            Assertions.assertEquals(1, consoleReader.read().size());
        }
        catch (ReadException e) {
            Assertions.fail("Unexpected exception.");
        }
    }

    @Test
    public void consoleReaderWrongProduct() {
        consoleReader.setParams(new String[] {"q-1"});
        try {
            consoleReader.read();
            Assertions.fail("ReadException expected.");
        }
        catch (ReadException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void consoleReaderWrongData() {
        consoleReader.setParams(new String[] {""});
        try {
            consoleReader.read();
            Assertions.fail("ReadException expected.");
        }
        catch (ReadException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void fileReaderCardsFileNotFound() {
        fileReader = new FileReader(PRODUCTS_FILE, NOTFOUND);
        fileReader.setParams(new String[] {"card-1234"});
        try {
            fileReader.read();
            Assertions.fail("ReadException expected.");
        }
        catch (ReadException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void fileReaderProductsFileNotFound() {
        fileReader = new FileReader(NOTFOUND, CARDS_FILE);
        fileReader.setParams(new String[] {"1-1"});
        try {
            fileReader.read();
            Assertions.fail("ReadException expected.");
        }
        catch (ReadException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void readFromFile() {
        fileReader = new FileReader(PRODUCTS_FILE, CARDS_FILE);
        fileReader.setParams(new String[] {"1-1"});
        purchase.setProduct(Product.builder()
                .setId(1)
                .setName("Bread")
                .setPrice(1.09f)
                .build()
        );

        purchase.setQuantity(1);
        purchases.add(purchase);
        List<Purchase> purchaseList;
        try {
            purchaseList = fileReader.read();
            Assertions.assertEquals(1, purchaseList.size());
            Assertions.assertEquals(purchases.get(0), purchaseList.get(0));
        } catch (ReadException e) {
            Assertions.fail("Unexpected exception.");
        }
    }

    @Test
    public void readFromFileWrongProduct() {
        fileReader = new FileReader(PRODUCTS_FILE, CARDS_FILE);
        fileReader.setParams(new String[] {"p-3"});
        try {
            fileReader.read();
            Assertions.fail("ReadException expected.");
        }
        catch (ReadException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void readFromFileWrongData() {
        fileReader = new FileReader(PRODUCTS_FILE, CARDS_FILE);
        fileReader.setParams(new String[] {""});
        try {
            fileReader.read();
            Assertions.fail("ReadException expected.");
        }
        catch (ReadException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }
}