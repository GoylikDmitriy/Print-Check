package check.model.dao.impl;

import check.model.dao.Data;
import check.model.dao.DiscountCardDao;
import check.model.dao.exception.DaoException;
import check.model.DiscountCard;

import java.util.Optional;

public class DiscountCardDaoConsole implements DiscountCardDao {
    @Override
    public Optional<DiscountCard> findDiscountCardByNumber(int number) throws DaoException {
        Optional<DiscountCard> card = Optional.empty();
        DiscountCard[] cards = Data.getCards();
        for (DiscountCard c : cards) {
            if (c.getNumber() == number) {
                card = Optional.of(c);
                break;
            }
        }

        if (card.isEmpty()) {
            throw new DaoException("There's no such card with number = " + number);
        }

        return card;
    }
}
