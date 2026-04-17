package Discounts_Engine_Gemini;

public class FixedAmountDiscount implements DiscountStrategy {
    private final double amount;

    public FixedAmountDiscount(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Discount amount cannot be negative");
        this.amount = amount;
    }

    @Override
    public double apply(double currentPrice) {
        // Validation: Ensure we don't drop price below zero
        return Math.max(0, currentPrice - amount);
    }

    @Override
    public String getName() {
        return "$" + amount + " Fixed Discount";
    }
}