package Discounts_Engine;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Apple", 1.59);
        Product product2 = new Product("Banana", 1.80);
        Product product3 = new Product("Orange", 1.99);
        Product product4 = new Product("Samsung Tv", 460);

        DiscountStrategy discount1 = new PercentageDiscount(10);
        DiscountStrategy discount2 = new FixedAmountDiscount(4);
        DiscountStrategy discount3 = new PercentageDiscount(33);

        //Apply mulitple discounts in one product
        List<DiscountStrategy> discounts = new ArrayList<>();
        discounts.add(discount1);
        discounts.add(discount2);

        double finalPriceP4 = product4.getPrice();
        for(DiscountStrategy discount: discounts) {
            finalPriceP4 = discount.applyDiscount(finalPriceP4);
        }
        System.out.println("For Loop: "+finalPriceP4);

        System.out.println(product1.getPriceWithDiscount(discount1));
        System.out.println(product2.getPriceWithDiscount(discount1));
        System.out.println(product3.getPriceWithDiscount(discount1));
        double finalPrice = product4.getPriceWithDiscount(discount3);
        System.out.println(finalPrice);
        System.out.println(product4.getPriceWithDiscount(discount2));
    }
}
