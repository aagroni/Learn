package IMS;

import java.util.*;
import java.util.stream.Collectors;

public class InventoryService {

    private final Map<String, Product> products = new HashMap<>();

    // Add product
    public void addProduct(Product product) {
        if (products.containsKey(product.getId())) {
            throw new DuplicateProductException("Product with ID already exists");
        }
        products.put(product.getId(), product);
    }

    // Remove product
    public void removeProduct(String id) {
        if (!products.containsKey(id)) {
            throw new ProductNotFoundException("Product not found");
        }
        products.remove(id);
    }

    // Get product
    public Product getProduct(String id) {
        Product product = products.get(id);
        if (product == null) {
            throw new ProductNotFoundException("Product not found");
        }
        return product;
    }

    // Update price
    public void updatePrice(String id, double newPrice) {
        getProduct(id).setPrice(newPrice);
    }

    // Increase stock
    public void increaseStock(String id, int amount) {
        getProduct(id).increaseStock(amount);
    }

    // Decrease stock
    public void decreaseStock(String id, int amount) {
        getProduct(id).decreaseStock(amount);
    }

    // List all
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    // Filter by stock
    public List<Product> getLowStockProducts(int threshold) {
        return products.values().stream()
                .filter(p -> p.getQuantity() < threshold)
                .collect(Collectors.toList());
    }

    // Filter by price range
    public List<Product> getProductsByPriceRange(double min, double max) {
        return products.values().stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .collect(Collectors.toList());
    }

    // Sort by price
    public List<Product> sortByPrice() {
        return products.values().stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }

    // Sort by quantity
    public List<Product> sortByQuantity() {
        return products.values().stream()
                .sorted(Comparator.comparingInt(Product::getQuantity))
                .collect(Collectors.toList());
    }

    // Total inventory value
    public double getTotalValue() {
        return products.values().stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }
}