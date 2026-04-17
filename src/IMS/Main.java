package IMS;

public class Main {
    public static void main(String[] args) {

        InventoryService service = new InventoryService();

        // Add products
        service.addProduct(new Product("1", "Laptop", 1000, 5));
        service.addProduct(new Product("2", "Mouse", 25, 50));
        service.addProduct(new Product("3", "Keyboard", 75, 20));

        // Update
        service.updatePrice("1", 950);
        service.increaseStock("2", 10);
        service.decreaseStock("3", 5);

        // List all
        System.out.println("All products:");
        service.getAllProducts().forEach(System.out::println);

        // Low stock
        System.out.println("\nLow stock (<10):");
        service.getLowStockProducts(10).forEach(System.out::println);

        // Price range
        System.out.println("\nPrice range (50 - 1000):");
        service.getProductsByPriceRange(50, 1000).forEach(System.out::println);

        // Sorting
        System.out.println("\nSorted by price:");
        service.sortByPrice().forEach(System.out::println);

        System.out.println("\nSorted by quantity:");
        service.sortByQuantity().forEach(System.out::println);

        // Total value
        System.out.println("\nTotal inventory value: " + service.getTotalValue());

        // Error case
        try {
            service.removeProduct("99");
        } catch (ProductNotFoundException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}