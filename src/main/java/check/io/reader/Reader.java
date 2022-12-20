package check.io.reader;

import check.io.reader.exception.ReadException;
import check.model.DiscountCard;
import check.model.Product;
import check.model.Purchase;
import check.model.dao.DiscountCardDao;
import check.model.dao.ProductDao;
import check.model.dao.exception.DaoException;
import check.model.service.CheckService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Reader {
    public static final String CARD = "card";
    public static final String SEPARATOR = "-";
    protected String[] params;
    public void setParams(String[] params) {
        this.params = params;
    }


    public abstract List<Purchase> read() throws ReadException;

    protected List<Purchase> read(ProductDao productDao, DiscountCardDao cardDao) throws ReadException {
        List<Purchase> purchases = new ArrayList<>();
        try {
            for (String a : params) {
                String[] values = a.split(SEPARATOR);
                if (values.length != 2) {
                    throw new ReadException("Wrong input data.");
                }

                int number = Integer.parseInt(values[1]);
                if (Character.isDigit(values[0].charAt(0))) {
                    int quantity = number;
                    int id = Integer.parseInt(values[0]);
                    Optional<Product> product = productDao.findProductById(id);
                    if (product.isPresent() && quantity > 0) {
                        Purchase purchase = new Purchase();
                        purchase.setProduct(product.get());
                        purchase.setQuantity(quantity);
                        purchases.add(purchase);
                    }
                } else if (values[0].equals(CARD)) {
                    Optional<DiscountCard> card = cardDao.findDiscountCardByNumber(number);
                    card.ifPresent(discountCard -> CheckService.setDiscount(discountCard.getDiscount()));
                } else {
                    throw new ReadException("Invalid product.");
                }
            }

            return purchases;
        }
        catch (NumberFormatException e) {
            throw new ReadException("Cant parse string to number." + e.getMessage(), e);
        }
        catch (DaoException e) {
            throw new ReadException(e);
        }
    }
}