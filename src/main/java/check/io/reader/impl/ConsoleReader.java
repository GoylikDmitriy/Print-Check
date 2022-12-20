package check.io.reader.impl;

import check.io.reader.Reader;
import check.io.reader.exception.ReadException;
import check.model.Purchase;
import check.model.dao.impl.DiscountCardDaoConsole;
import check.model.dao.impl.ProductDaoConsole;

import java.util.List;

public class ConsoleReader extends Reader {
    @Override
    public List<Purchase> read() throws ReadException {
        return read(new ProductDaoConsole(), new DiscountCardDaoConsole());
    }
}