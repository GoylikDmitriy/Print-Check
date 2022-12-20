package check.model.dao;

import check.model.dao.exception.DaoException;
import check.model.DiscountCard;

import java.util.Optional;

public interface DiscountCardDao {
    Optional<DiscountCard> findDiscountCardByNumber(int number) throws DaoException;
}
