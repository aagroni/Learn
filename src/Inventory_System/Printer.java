package Inventory_System;


import java.util.List;

public class Printer {

    private static final String DIVIDER = "─".repeat(60);
    private static final String HEADER  = "═".repeat(60);

    private Printer() {}

    public static void section(String title) {
        System.out.println("\n" + HEADER);
        System.out.println("  " + title);
        System.out.println(HEADER);
    }

    public static void subsection(String label) {
        System.out.println("\n" + DIVIDER);
        System.out.println("  " + label);
        System.out.println(DIVIDER);
    }

    public static void printList(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("  (no products)");
            return;
        }
        System.out.printf("  %-8s %-22s %10s %8s%n", "ID", "Name", "Price (€)", "Qty");
        System.out.println("  " + "·".repeat(54));
        for (Product p : products) {
            System.out.printf("  %-8s %-22s %10.2f %8d%n",
                    p.getId(), p.getName(), p.getPrice(), p.getQuantity());
        }
    }

    public static void printProduct(Product p) {
        System.out.println("  " + p);
    }

    public static void ok(String msg) {
        System.out.println("  ✔  " + msg);
    }

    public static void error(String msg) {
        System.out.println("  ✘  ERROR → " + msg);
    }

    public static void info(String msg) {
        System.out.println("  ℹ  " + msg);
    }
}
