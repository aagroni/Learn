package Inventory_System;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String id, int requested, int available) {
        super(String.format(
            "Insufficient stock for product '%s': requested %d but only %d available.",
            id, requested, available
        ));
    }
}
