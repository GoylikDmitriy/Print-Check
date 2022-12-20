package check.model;

public class DiscountCard {
    private int id;
    private int number;
    private int discount;

    public void setId(int id) {
        this.id = id;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getId() {
        return this.id;
    }
    public int getNumber() {
        return this.number;
    }
    public int getDiscount() {
        return this.discount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final DiscountCard card;

        public Builder() {
            card = new DiscountCard();
        }

        public Builder setId(int id) {
            this.card.setId(id);
            return this;
        }

        public Builder setNumber(int number) {
            this.card.setNumber(number);
            return this;
        }

        public Builder setDiscount(int discount) {
            this.card.setDiscount(discount);
            return this;
        }

        public DiscountCard build() {
            return this.card;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (object instanceof DiscountCard card) {
            return this.number == card.number;
        }

        return false;
    }
}