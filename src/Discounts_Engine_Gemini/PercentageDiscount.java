package Discounts_Engine_Gemini;

public class PercentageDiscount implements DiscountStrategy {
    private final double percentage;

    public PercentageDiscount(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }
        this.percentage = percentage;
    }

    @Override
    public double apply(double currentPrice) {
        return currentPrice * (1 - (percentage / 100));
    }

    @Override
    public String getName() {
        return percentage + "% Off";
    }
}