package Discounts_Engine_Gemini;

public class Main {
    public static void main(String[] args) {
        //My Product
        Product samsungTv = new Product("Samsung Tv", 650);

        DiscountStrategy tax18 = new TaxStrategy(18);
        DiscountStrategy tenOff = new PercentageDiscount(10);

        System.out.println(samsungTv.getFinalPrice());
        samsungTv.displayPricing();
        samsungTv.addDiscount(tenOff);
        samsungTv.addDiscount(tax18);
        samsungTv.displayPricing();

        // Product 1: Gaming Mouse with a Percentage Discount
        Product mouse = new Product("Gaming Mouse", 100.0);
        mouse.addDiscount(new PercentageDiscount(10)); // 10% off
        mouse.displayPricing();


        // Product 2: Mechanical Keyboard with Sequential Discounts
        // Order matters: 10% off $200 is $180, then -$20 is $160.
        Product keyboard = new Product("Mechanical Keyboard", 200.0);
        keyboard.addDiscount(new PercentageDiscount(10));
        keyboard.addDiscount(new FixedAmountDiscount(20));
        keyboard.displayPricing();

        // Bonus: Condition-based Discount (implemented via an anonymous class or separate class)
        Product monitor = new Product("UltraWide Monitor", 500.0);
        monitor.addDiscount(new DiscountStrategy() {
            @Override
            public double apply(double currentPrice) {
                return (currentPrice > 400) ? currentPrice - 50 : currentPrice;
            }
            @Override
            public String getName() { return "Bulk Order Bonus ($50 off over $400)"; }
        });
        monitor.displayPricing();
    }
}