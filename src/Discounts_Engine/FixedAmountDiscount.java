package Discounts_Engine;

public class FixedAmountDiscount implements DiscountStrategy {

    private double amount;

    public FixedAmountDiscount(double amount) {
        if (amount <= 0) {throw  new IllegalArgumentException("Amount must be greater than zero");}
        this.amount = amount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - this.amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount <= 0) {throw  new IllegalArgumentException("Amount must be greater than zero");}
        this.amount = amount;
    }
}
