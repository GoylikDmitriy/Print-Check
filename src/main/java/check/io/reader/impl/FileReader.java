package check.io.reader.impl;

import check.io.reader.Reader;
import check.io.reader.exception.ReadException;
import check.model.Purchase;
import check.model.dao.impl.DiscountCardDaoFile;
import check.model.dao.impl.ProductDaoFile;

import java.util.List;

public class FileReader extends Reader {
    private final String productsFile;
    private final String cardsFile;

    public FileReader(String productFile, String cardsFile) {
        this.productsFile = productFile;
        this.cardsFile = cardsFile;
    }

    @Override
    public List<Purchase> read() throws ReadException {
        return read(new ProductDaoFile(productsFile), new DiscountCardDaoFile(cardsFile));
    }
}
