package check.model.dao.impl;

import check.model.Product;
import check.model.dao.ProductDao;
import check.model.dao.exception.DaoException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

public class ProductDaoFile implements ProductDao {
    private static final String BR = "\r\n";
    private static final String WHITESPACE = " ";
    private final String fileName;

    public ProductDaoFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Optional<Product> findProductById(int id) throws DaoException {
        Optional<Product> productOptional = Optional.empty();
        try (FileInputStream file = new FileInputStream(fileName)) {
            Product product = new Product();
            byte[] bytes = file.readAllBytes();
            StringBuilder productsListBuilder = new StringBuilder();
            for (byte b : bytes) {
                productsListBuilder.append((char)b);
            }

            String productsList = productsListBuilder.toString();
            String[] products = productsList.split(BR);
            for (String p : products) {
                String[] productParams = p.split(WHITESPACE);
                if (Integer.parseInt(productParams[0]) == id) {
                    product.setId(id);
                    product.setName(productParams[1]);
                    product.setPrice(Float.parseFloat(productParams[2]));
                    productOptional = Optional.of(product);
                    break;
                }
            }

            if (productOptional.isEmpty()) {
                throw new DaoException("There's no such product with id = " + id);
            }

            return productOptional;
        }
        catch (IOException e) {
            throw new DaoException(e);
        }
    }
}