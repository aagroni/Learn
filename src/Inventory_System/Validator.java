package Inventory_System;


public class Validator {

    private Validator() {}

    public static void requireNonBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new InvalidProductDataException(fieldName + " must not be blank.");
        }
    }

    public static void requireNonNegativePrice(double price) {
        if (price < 0) {
            throw new InvalidProductDataException("Price must not be negative. Got: " + price);
        }
    }

    public static void requireNonNegativeQuantity(int quantity) {
        if (quantity < 0) {
            throw new InvalidProductDataException("Quantity must not be negative. Got: " + quantity);
        }
    }

    public static void requirePositiveAmount(int amount, String operation) {
        if (amount <= 0) {
            throw new InvalidProductDataException(operation + " amount must be positive. Got: " + amount);
        }
    }
}
