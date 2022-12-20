package check.model.dao;

import check.model.dao.exception.DaoException;
import check.model.Product;

import java.util.Optional;

public interface ProductDao {
    Optional<Product> findProductById(int id) throws DaoException;
}
