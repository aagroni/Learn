package Discounts_Engine_Gemini;

public interface DiscountStrategy {
    double apply(double currentPrice);
    String getName(); // Helpful for printing which discounts were applied
}