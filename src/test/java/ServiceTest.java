import check.model.Product;
import check.model.Purchase;
import check.model.service.CheckService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ServiceTest {
    @Test
    public void addPurchaseToCheck() {
        Purchase purchase = new Purchase();
        purchase.setProduct(
                Product.builder()
                        .setId(1)
                        .setName("Bread")
                        .setPrice(1.09f)
                        .build()
        );

        purchase.setQuantity(1);
        List<Purchase> purchases = new ArrayList<>();
        purchases.add(purchase);
        CheckService.getPurchases().clear();
        CheckService.addAllPurchases(purchases);

        Assertions.assertEquals(1, CheckService.getPurchases().size());
    }

    @Test
    public void samePurchaseAdded() {
        Purchase purchase = new Purchase();
        purchase.setProduct(
                Product.builder()
                        .setId(1)
                        .setName("Bread")
                        .setPrice(1.09f)
                        .build()
        );

        purchase.setQuantity(1);
        List<Purchase> purchases = new ArrayList<>();
        purchases.add(purchase);
        CheckService.getPurchases().clear();
        CheckService.addAllPurchases(purchases);

        Assertions.assertEquals(purchase, purchases.get(0));
    }
}