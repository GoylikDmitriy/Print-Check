import check.io.printer.StringFormat;
import check.model.Product;
import check.model.Purchase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PrinterTest {
    private static final Purchase purchase = new Purchase();

    @BeforeAll
    static void setup() {
        purchase.setProduct(
                Product.builder()
                        .setId(1)
                        .setName("Bread")
                        .setPrice(1.09f)
                        .build()
        );
    }

    @Test
    public void returnCorrectPurchaseToString() {
        purchase.setQuantity(1);
        String actual = StringFormat.purchaseToString(purchase);
        String expected = String.format("%-4d %-15s %7.2f$ %7.2f$\n", 1, "Bread", 1.09f, 1.09f);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void returnCorrectDiscountQuantityToString() {
        purchase.setQuantity(7);
        String actual = StringFormat.discountQuantityToString(purchase);
        String expected = String.format("%28d%% %7.2f$\n", 10, 6.87f);
        Assertions.assertEquals(expected, actual);
    }
}