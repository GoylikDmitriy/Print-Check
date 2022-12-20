package check.model.service;

import check.io.printer.Printer;
import check.io.printer.StringFormat;
import check.io.printer.exception.PrintException;
import check.model.Check;
import check.model.Purchase;
import check.model.service.exception.ServiceException;

import java.util.List;

public final class CheckService {
    private static final Check check = new Check();

    public static void addAllPurchases(List<Purchase> purchases) {
        for (Purchase p : purchases) {
            addToTotalPrice(computePrice(p.getProduct().getPrice(), p.getQuantity()));
        }

        check.getPurchases().addAll(purchases);
    }

    public static void printCheck(Printer printer) throws ServiceException {
        try {
            if (check.getPurchases().size() > 0) {
                printer.print(check);
            }
            else {
                throw new ServiceException("No purchases found.");
            }
        }
        catch (PrintException e) {
            throw new ServiceException(e);
        }
    }

    public static void setDiscount(int discount) {
        check.setDiscount(discount);
    }

    public static List<Purchase> getPurchases() {
        return check.getPurchases();
    }

    private static void addToTotalPrice(float price) {
        check.setTotalPrice(check.getTotalPrice() + price);
    }
    private static float computePrice(float price, int quantity) {
        float totalPrice = price * quantity;
        if (quantity > StringFormat.QUANTITY_FOR_DISCOUNT) {
            totalPrice -= totalPrice * StringFormat.DISCOUNT / 100;
        }

        return totalPrice;
    }
}