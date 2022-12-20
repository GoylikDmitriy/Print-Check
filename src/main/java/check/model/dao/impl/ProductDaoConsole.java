package check.model.dao.impl;

import check.model.dao.Data;
import check.model.dao.ProductDao;
import check.model.dao.exception.DaoException;
import check.model.Product;

import java.util.Optional;

public class ProductDaoConsole implements ProductDao {
    @Override
    public Optional<Product> findProductById(int id) throws DaoException {
        Optional<Product> product = Optional.empty();
        Product[] products = Data.getProducts();
        for (Product p : products) {
            if (p.getId() == id) {
                product = Optional.of(p);
                break;
            }
        }

        if (product.isEmpty()) {
            throw new DaoException("There's no such product with id = " + id);
        }

        return product;
    }
}
