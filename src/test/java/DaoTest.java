import check.model.DiscountCard;
import check.model.Product;
import check.model.dao.DiscountCardDao;
import check.model.dao.ProductDao;
import check.model.dao.exception.DaoException;
import check.model.dao.impl.DiscountCardDaoConsole;
import check.model.dao.impl.DiscountCardDaoFile;
import check.model.dao.impl.ProductDaoConsole;
import check.model.dao.impl.ProductDaoFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DaoTest {
    private final String NOTFOUND = "notfound.txt";
    private final String FILE_PRODUCTS_NAME = "data/products.txt";
    private final String FILE_CARDS_NAME = "data/cards.txt";
    private final ProductDao productDaoFile = new ProductDaoFile(FILE_PRODUCTS_NAME);
    private final ProductDao productDaoConsole = new ProductDaoConsole();
    private final DiscountCardDao cardDaoConsole = new DiscountCardDaoConsole();
    private final DiscountCardDao cardDaoFile = new DiscountCardDaoFile(FILE_CARDS_NAME);


    @Test
    public void consoleProductDaoReturnProductById() {
        try {
            Product product = productDaoConsole.findProductById(1).get();
            Product expected = Product.builder()
                    .setId(1)
                    .setName("Bread")
                    .setPrice(1.09f)
                    .build();

            Assertions.assertEquals(expected, product);
        }
        catch (DaoException e) {
            Assertions.fail("Unexpected exception.");
        }
    }

    @Test
    public void consoleProductDaoNonexistentProductException() {
        try {
            productDaoConsole.findProductById(111111);
            Assertions.fail("DaoException expected.");
        }
        catch (DaoException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void fileProductDaoReturnProductById() {
        try {
            Product product = productDaoFile.findProductById(1).get();
            Product expected = Product.builder()
                    .setId(1)
                    .setName("Bread")
                    .setPrice(1.09f)
                    .build();

            Assertions.assertEquals(expected, product);
        }
        catch (DaoException e) {
            Assertions.fail("Unexpected exception.");
        }
    }

    @Test
    public void fileProductDaoNonexistentProductException() {
        try {
            productDaoFile.findProductById(111111);
            Assertions.fail("DaoException expected.");
        }
        catch (DaoException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void fileProductDaoFileNotFoundException() {
        try {
            ProductDaoFile productDao = new ProductDaoFile(NOTFOUND);
            productDao.findProductById(1);
            Assertions.fail("DaoException expected.");
        }
        catch (DaoException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void consoleCardDaoReturnCardByNumber() {
        try {
            DiscountCard card = cardDaoConsole.findDiscountCardByNumber(1234).get();
            DiscountCard expected = DiscountCard.builder()
                    .setId(1)
                    .setNumber(1234)
                    .setDiscount(5)
                    .build();

            Assertions.assertEquals(expected, card);
        }
        catch (DaoException e) {
            Assertions.fail("Unexpected exception.");
        }
    }

    @Test
    public void consoleCardDaoNonexistentCardException() {
        try {
            cardDaoConsole.findDiscountCardByNumber(666);
            Assertions.fail("DaoException expected.");
        }
        catch (DaoException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void fileCardDaoReturnCardByNumber() {
        try {
            DiscountCard card = cardDaoFile.findDiscountCardByNumber(1234).get();
            DiscountCard expected = DiscountCard.builder()
                    .setId(1)
                    .setNumber(1234)
                    .setDiscount(5)
                    .build();

            Assertions.assertEquals(expected, card);
        }
        catch (DaoException e) {
            Assertions.fail("Unexpected exception.");
        }
    }

    @Test
    public void fileCardDaoNonexistentCardException() {
        try {
            cardDaoFile.findDiscountCardByNumber(666);
            Assertions.fail("DaoException expected.");
        }
        catch (DaoException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }

    @Test
    public void fileCardDaoFileNotFoundException() {
        try {
            DiscountCardDao discountCardDao = new DiscountCardDaoFile(NOTFOUND);
            discountCardDao.findDiscountCardByNumber(1234);
            Assertions.fail("DaoException expected.");
        }
        catch (DaoException e) {
            Assertions.assertNotEquals("", e.getMessage());
        }
    }
}