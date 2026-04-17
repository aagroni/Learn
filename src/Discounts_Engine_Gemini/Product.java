package Discounts_Engine_Gemini;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private final String name;
    private final double basePrice;
    private final List<DiscountStrategy> discounts;

    public Product(String name, double basePrice) {
        if (basePrice < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.name = name;
        this.basePrice = basePrice;
        this.discounts = new ArrayList<>();
    }

    public void addDiscount(DiscountStrategy discount) {
        this.discounts.add(discount);
    }

    public double getFinalPrice() {
        double finalPrice = basePrice;
        for (DiscountStrategy discount : discounts) {
            finalPrice = discount.apply(finalPrice);
        }
        return finalPrice;
    }

    public void displayPricing() {
        System.out.println("Product: " + name);
        System.out.println("Original Price: $" + basePrice);

        if (discounts.isEmpty()) {
            System.out.println("Discounts: None");
        } else {
            System.out.print("Discounts Applied: ");
            for (int i = 0; i < discounts.size(); i++) {
                System.out.print(discounts.get(i).getName() + (i < discounts.size() - 1 ? " -> " : ""));
            }
            System.out.println();
        }

        System.out.println("Final Price: $" + getFinalPrice());
        System.out.println("---");
    }
}