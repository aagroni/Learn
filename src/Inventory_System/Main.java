package Inventory_System;


public class Main {

    public static void main(String[] args) {

        InventoryService inventory = new InventoryService(new ProductRepository());

        // ── 1. ADD PRODUCTS ──────────────────────────────────────────────────
        Printer.section("1. Adding Products");
        Product product = new Product("123","Kastraveca",2.55,100);
        inventory.addProduct(null, "Mechanical Keyboard",  89.99, 20);
        Printer.ok("Added: Mechanical Keyboard");

        inventory.addProduct("P002", "USB-C Hub",            34.50, 45);
        Printer.ok("Added: USB-C Hub");

        inventory.addProduct("P003", "27\" Monitor",        349.00,  8);
        Printer.ok("Added: 27\" Monitor");

        inventory.addProduct("P004", "Webcam HD",            59.99,  3);
        Printer.ok("Added: Webcam HD");

        inventory.addProduct("P005", "Desk Lamp",            24.99, 60);
        Printer.ok("Added: Desk Lamp");

        inventory.addProduct("P006", "Laptop Stand",         44.00, 12);
        Printer.ok("Added: Laptop Stand");

        // ── 2. LIST ALL ───────────────────────────────────────────────────────
        Printer.section("2. All Products");
        Printer.printList(inventory.listAll());

        // ── 3. RETRIEVE BY ID ─────────────────────────────────────────────────
        Printer.section("3. Retrieve Product by ID");
        Printer.printProduct(inventory.getProduct("P003"));

        // ── 4. UPDATE PRICE & QUANTITY ────────────────────────────────────────
        Printer.section("4. Update Price & Quantity");

        inventory.updatePrice("P001", 79.99);
        Printer.ok("Updated price of P001 to 79.99");

        inventory.updateQuantity("P002", 50);
        Printer.ok("Updated quantity of P002 to 50");

        // ── 5. STOCK MANAGEMENT ───────────────────────────────────────────────
        Printer.section("5. Stock Management");

        inventory.increaseStock("P005", 10);
        Printer.ok("Increased P005 stock by 10 → now " + inventory.getProduct("P005").getQuantity());

        inventory.decreaseStock("P004", 1);
        Printer.ok("Decreased P004 stock by 1 → now " + inventory.getProduct("P004").getQuantity());

        inventory.decreaseStock("P006", 9);
        Printer.ok("Decreased P006 stock by 9 → now " + inventory.getProduct("P006").getQuantity());

        // ── 6. SEARCH / FILTER ────────────────────────────────────────────────
        Printer.section("6. Search & Filter");

        Printer.subsection("Products with qty < 5");
        Printer.printList(inventory.listBelowStockLevel(5));

        Printer.subsection("Products priced between €30 and €100");
        Printer.printList(inventory.listInPriceRange(30, 100));

        // ── 7. SORTING ────────────────────────────────────────────────────────
        Printer.section("7. Sorting");

        Printer.subsection("Sorted by price (ascending)");
        Printer.printList(inventory.sortedByPrice(true));

        Printer.subsection("Sorted by quantity (descending)");
        Printer.printList(inventory.sortedByQuantity(false));

        // ── 8. REMOVE A PRODUCT ───────────────────────────────────────────────
        Printer.section("8. Remove Product");

        inventory.removeProduct("P005");
        Printer.ok("Removed P005 (Desk Lamp)");
        Printer.info("Products remaining: " + inventory.listAll().size());

        // ── 9. BONUS: TOTAL VALUE & LOW-STOCK ALERTS ─────────────────────────
        Printer.section("9. Bonus: Inventory Value & Low-Stock Alerts");

        Printer.info(String.format("Total inventory value: €%.2f", inventory.totalInventoryValue()));

        Printer.subsection("Low-stock alerts (threshold = 5 units)");
        var lowStock = inventory.getLowStockAlerts();
        if (lowStock.isEmpty()) {
            Printer.info("No low-stock items.");
        } else {
            Printer.printList(lowStock);
        }

        // ── 10. ERROR HANDLING DEMOS ──────────────────────────────────────────
        Printer.section("10. Error Handling");

        // Duplicate ID
        try {
            inventory.addProduct("P001", "Clone Keyboard", 50.00, 5);
        } catch (DuplicateProductException e) {
            Printer.error(e.getMessage());
        }

        // Duplicate name
        try {
            inventory.addProduct("P999", "USB-C Hub", 29.99, 10);
        } catch (DuplicateProductException e) {
            Printer.error(e.getMessage());
        }

        // Negative price
        try {
            inventory.addProduct("P100", "Ghost Product", -5.00, 1);
        } catch (InvalidProductDataException e) {
            Printer.error(e.getMessage());
        }

        // Update non-existent product
        try {
            inventory.updatePrice("GHOST", 9.99);
        } catch (ProductNotFoundException e) {
            Printer.error(e.getMessage());
        }

        // Remove non-existent product
        try {
            inventory.removeProduct("GHOST");
        } catch (ProductNotFoundException e) {
            Printer.error(e.getMessage());
        }

        // Stock below zero
        try {
            inventory.decreaseStock("P004", 100);
        } catch (InsufficientStockException e) {
            Printer.error(e.getMessage());
        }

        // Negative quantity on add
        try {
            inventory.addProduct("P200", "Bad Product", 10.00, -3);
        } catch (InvalidProductDataException e) {
            Printer.error(e.getMessage());
        }

        System.out.println("\n" + "═".repeat(60));
        System.out.println("  Demo complete.");
        System.out.println("═".repeat(60) + "\n");
    }
}
