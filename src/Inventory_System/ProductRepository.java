package Inventory_System;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * In-memory storage for products, keyed by ID for O(1) lookup.
 * Uses LinkedHashMap to preserve insertion order during iteration.
 */
public class ProductRepository {

    private final Map<String, Product> store = new LinkedHashMap<>();

    public void save(Product product) {
        store.put(product.getId(), product);
    }

    public Optional<Product> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    public Product getById(String id) {
        return findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public boolean existsById(String id) {
        return store.containsKey(id);
    }

    public boolean existsByName(String name) {
        return store.values().stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(name));
    }

    public void deleteById(String id) {
        if (!store.containsKey(id)) {
            throw new ProductNotFoundException(id);
        }
        store.remove(id);
    }

    public Collection<Product> findAll() {
        return store.values();
    }

    public int count() {
        return store.size();
    }
}
