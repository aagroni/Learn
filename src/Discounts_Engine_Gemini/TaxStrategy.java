package Discounts_Engine_Gemini;
//just to test the concept of polymoriphsm and loose copeling
public class TaxStrategy implements DiscountStrategy {

    double taxPercentage;
    public TaxStrategy(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
    @Override
    public double apply(double currentPrice) {
        return currentPrice * (1+(taxPercentage / 100));
    }
    public String getName() {
        return "Tax :"+ taxPercentage + "%";
    }
}
