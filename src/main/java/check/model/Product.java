package check.model;

public class Product {
    private int id;
    private String name;
    private float price;

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public float getPrice() {
        return this.price;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Product product;

        public Builder() {
            product = new Product();
        }

        public Builder setId(int id) {
            this.product.setId(id);
            return this;
        }

        public Builder setName(String name) {
            this.product.setName(name);
            return this;
        }

        public Builder setPrice(float price) {
            this.product.setPrice(price);
            return this;
        }

        public Product build() {
            return this.product;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (object instanceof Product p) {
            return this.id == p.id;
        }

        return false;
    }
}
