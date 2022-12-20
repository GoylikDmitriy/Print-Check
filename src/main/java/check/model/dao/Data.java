package check.model.dao;

import check.model.DiscountCard;
import check.model.Product;

public record Data() {
    private static final Product[] products = {
            Product.builder()
                    .setId(1)
                    .setName("Bread")
                    .setPrice(1.09f)
                    .build(),

            Product.builder()
                    .setId(2)
                    .setName("Sausage")
                    .setPrice(2.15f)
                    .build(),

            Product.builder()
                    .setId(3)
                    .setName("Water")
                    .setPrice(0.99f)
                    .build(),

            Product.builder()
                    .setId(4)
                    .setName("Chocolate")
                    .setPrice(1.39f)
                    .build(),

            Product.builder()
                    .setId(5)
                    .setName("Apple")
                    .setPrice(0.79f)
                    .build(),

            Product.builder()
                    .setId(6)
                    .setName("Cheese")
                    .setPrice(2.49f)
                    .build(),

            Product.builder()
                    .setId(7)
                    .setName("Ice-cream")
                    .setPrice(1.00f)
                    .build(),

            Product.builder()
                    .setId(8)
                    .setName("Soda")
                    .setPrice(1.21f)
                    .build(),

            Product.builder()
                    .setId(9)
                    .setName("Juice")
                    .setPrice(1.99f)
                    .build(),

            Product.builder()
                    .setId(10)
                    .setName("Salad")
                    .setPrice(2.01f)
                    .build(),
    };

    private static final DiscountCard[] cards = {
            DiscountCard.builder()
                    .setId(1)
                    .setNumber(1234)
                    .setDiscount(5)
                    .build(),

            DiscountCard.builder()
                    .setId(2)
                    .setNumber(4321)
                    .setDiscount(10)
                    .build(),

            DiscountCard.builder()
                    .setId(3)
                    .setNumber(2023)
                    .setDiscount(50)
                    .build(),
    };

    public static Product[] getProducts() {
        return products;
    }
    public static DiscountCard[] getCards() {
        return cards;
    }
}
