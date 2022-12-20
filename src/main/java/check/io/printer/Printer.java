package check.io.printer;

import check.io.printer.exception.PrintException;
import check.model.Check;
import check.model.Purchase;

public interface Printer {
    void print(Check check) throws PrintException;
    static String prepareToPrint(Check check) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringFormat.HEADER);
        for (Purchase p : check.getPurchases()) {
            stringBuilder.append(StringFormat.purchaseToString(p));
            if (p.getQuantity() > StringFormat.QUANTITY_FOR_DISCOUNT) {
                stringBuilder.append(StringFormat.discountQuantityToString(p));
            }
        }

        stringBuilder.append(StringFormat.HR);
        if (check.getDiscount() != 0) {
            stringBuilder.append(StringFormat.totalPriceDiscountToString(check));
        }

        stringBuilder.append(StringFormat.totalPriceToString(check));
        return stringBuilder.toString();
    }
}