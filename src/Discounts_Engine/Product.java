package Discounts_Engine;

public class Product {
    private String productName;
    private double price;

    public Product(String productName, double price) {
        if(productName == null  || productName.isBlank()) {throw new IllegalArgumentException("Product name cannot be null or blank");}
        if(price <= 0) {throw new IllegalArgumentException("Product price cannot be 0 or negative");}
        this.productName = productName;
        this.price = price;
    }

    public double getPriceWithDiscount(DiscountStrategy discountStrategy) {
        return discountStrategy.applyDiscount(price);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if(productName == null  || productName.isBlank()) {throw new IllegalArgumentException("Product name cannot be null or blank");}
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0) {throw new IllegalArgumentException("Product price cannot be 0 or negative");}
        this.price = price;
    }
}
