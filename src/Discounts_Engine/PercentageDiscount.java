package Discounts_Engine;

public class PercentageDiscount  implements DiscountStrategy {

    private double percentage;
    public PercentageDiscount(double percentage) {
        if (percentage <= 0 || percentage >= 100) {throw new IllegalArgumentException("Percentage must be between 0.1 and 99");}
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * percentage / 100);
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
