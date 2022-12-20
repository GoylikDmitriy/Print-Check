package check.model;

import java.util.ArrayList;
import java.util.List;

public class Check {
    private List<Purchase> purchases = new ArrayList<>();
    private float totalPrice;
    private int discount = 0;

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public List<Purchase> getPurchases() {
        return this.purchases;
    }
    public float getTotalPrice() {
        return this.totalPrice;
    }
    public int getDiscount() {
        return this.discount;
    }
}