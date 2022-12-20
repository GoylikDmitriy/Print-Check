package check.model;

public class Purchase {
    private Product product;
    private int quantity;

    public void setProduct(Product product) {
        this.product = product;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return this.product;
    }
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (object instanceof Purchase p) {
            return this.product.equals(p.product) && this.quantity == p.quantity;
        }

        return false;
    }

}
