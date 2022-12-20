package check.io.printer;

import check.model.Check;
import check.model.Purchase;

public final class StringFormat {
    public static final int QUANTITY_FOR_DISCOUNT = 5;
    public static final int DISCOUNT = 10;
    public static final String HEADER = "QTY " + " DESCRIPTION    " + "    PRICE" + "    TOTAL\n";
    public static final String HR = "======================================";

    public static String purchaseToString(Purchase p) {
        return String.format("%-4d %-15s %7.2f$ %7.2f$\n",
                p.getQuantity(),
                p.getProduct().getName(),
                p.getProduct().getPrice(),
                p.getProduct().getPrice() * p.getQuantity()
        );
    }

    public static String discountQuantityToString(Purchase p) {
        return String.format(
                "%28d%% %7.2f$\n",
                DISCOUNT,
                (p.getProduct().getPrice() - p.getProduct().getPrice() * DISCOUNT / 100) * p.getQuantity()
        );
    }

    public static String totalPriceDiscountToString(Check check) {
        return String.format(
                "\nTAXABLE TOT. %24.2f$\nDISCOUNT %2d%% %24.2f$",
                check.getTotalPrice(),
                check.getDiscount(),
                check.getTotalPrice() * check.getDiscount() / 100
        );
    }

    public static String totalPriceToString(Check check) {
        return String.format(
                "\nTOTAL %31.2f$",
                check.getTotalPrice() - check.getTotalPrice() * check.getDiscount() / 100
        );
    }
}
