package check.model.dao.impl;

import check.model.DiscountCard;
import check.model.dao.DiscountCardDao;
import check.model.dao.exception.DaoException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

public class DiscountCardDaoFile implements DiscountCardDao {
    private static final String BR = "\r\n";
    private static final String WHITESPACE = " ";
    private final String fileName;

    public DiscountCardDaoFile(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Optional<DiscountCard> findDiscountCardByNumber(int number) throws DaoException {
        Optional<DiscountCard> cardOptional = Optional.empty();
        try (FileInputStream file = new FileInputStream(fileName)) {
            DiscountCard card = new DiscountCard();
            byte[] bytes = file.readAllBytes();
            StringBuilder cardsListBuilder = new StringBuilder();
            for (byte b : bytes) {
                cardsListBuilder.append((char)b);
            }

            String cardsList = cardsListBuilder.toString();
            String[] cards = cardsList.split(BR);
            for (String c : cards) {
                String[] cardParams = c.split(WHITESPACE);
                if (Integer.parseInt(cardParams[1]) == number) {
                    card.setId(Integer.parseInt(cardParams[0]));
                    card.setNumber(Integer.parseInt(cardParams[1]));
                    card.setDiscount(Integer.parseInt(cardParams[2]));
                    cardOptional = Optional.of(card);
                    break;
                }
            }

            if (cardOptional.isEmpty()) {
                throw new DaoException("There's no such card with number = " + number);
            }

            return cardOptional;
        }
        catch (IOException e) {
            throw new DaoException(e);
        }
    }
}
