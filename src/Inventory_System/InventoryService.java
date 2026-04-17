package Inventory_System;


import java.util.Comparator;
import java.util.List;

/**
 * Core business logic for inventory management.
 * All validation happens here; the repository is kept dumb.
 */
public class InventoryService {

    private static final int LOW_STOCK_THRESHOLD = 5;

    private final ProductRepository repository;

    public InventoryService(ProductRepository repository) {
        this.repository = repository;
    }

    // ── CRUD ────────────────────────────────────────────────────────────────

    public void addProduct(String id, String name, double price, int quantity) {
        Validator.requireNonBlank(id, "ID");
        Validator.requireNonBlank(name, "Name");
        Validator.requireNonNegativePrice(price);
        Validator.requireNonNegativeQuantity(quantity);

        if (repository.existsById(id)) {
            throw new DuplicateProductException("A product with ID '" + id + "' already exists.");
        }
        if (repository.existsByName(name)) {
            throw new DuplicateProductException("A product named '" + name + "' already exists.");
        }

        repository.save(new Product(id, name, price, quantity));
    }

    public void removeProduct(String id) {
        repository.deleteById(id); // throws ProductNotFoundException if absent
    }

    public Product getProduct(String id) {
        return repository.getById(id);
    }

    public List<Product> listAll() {
        return List.copyOf(repository.findAll());
    }

    // ── UPDATES ─────────────────────────────────────────────────────────────

    public void updatePrice(String id, double newPrice) {
        Validator.requireNonNegativePrice(newPrice);
        repository.getById(id).setPrice(newPrice);
    }

    public void updateQuantity(String id, int newQuantity) {
        Validator.requireNonNegativeQuantity(newQuantity);
        repository.getById(id).setQuantity(newQuantity);
    }

    // ── STOCK MANAGEMENT ────────────────────────────────────────────────────

    public void increaseStock(String id, int amount) {
        Validator.requirePositiveAmount(amount, "Increase");
        Product p = repository.getById(id);
        p.setQuantity(p.getQuantity() + amount);
        checkLowStock(p);
    }

    public void decreaseStock(String id, int amount) {
        Validator.requirePositiveAmount(amount, "Decrease");
        Product p = repository.getById(id);
        if (p.getQuantity() < amount) {
            throw new InsufficientStockException(id, amount, p.getQuantity());
        }
        p.setQuantity(p.getQuantity() - amount);
        checkLowStock(p);
    }

    // ── SEARCH / FILTER ──────────────────────────────────────────────────────

    public List<Product> listBelowStockLevel(int threshold) {
        return repository.findAll().stream()
                .filter(p -> p.getQuantity() < threshold)
                .toList();
    }

    public List<Product> listInPriceRange(double min, double max) {
        return repository.findAll().stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .toList();
    }

    // ── SORTING ──────────────────────────────────────────────────────────────

    public List<Product> sortedByPrice(boolean ascending) {
        Comparator<Product> cmp = Comparator.comparingDouble(Product::getPrice);
        if (!ascending) cmp = cmp.reversed();
        return repository.findAll().stream().sorted(cmp).toList();
    }

    public List<Product> sortedByQuantity(boolean ascending) {
        Comparator<Product> cmp = Comparator.comparingInt(Product::getQuantity);
        if (!ascending) cmp = cmp.reversed();
        return repository.findAll().stream().sorted(cmp).toList();
    }

    // ── BONUS ────────────────────────────────────────────────────────────────

    public double totalInventoryValue() {
        return repository.findAll().stream()
                .mapToDouble(Product::totalValue)
                .sum();
    }

    public List<Product> getLowStockAlerts() {
        return listBelowStockLevel(LOW_STOCK_THRESHOLD);
    }

    // ── PRIVATE HELPERS ──────────────────────────────────────────────────────

    private void checkLowStock(Product p) {
        if (p.getQuantity() < LOW_STOCK_THRESHOLD) {
            System.out.printf("  ⚠  LOW STOCK ALERT: '%s' (ID: %s) has only %d units left.%n",
                    p.getName(), p.getId(), p.getQuantity());
        }
    }
}
