package IMS;

public class Product {
    private final String id;
    private String name;
    private double price;
    private int quantity;

    public Product(String id, String name, double price, int quantity) {
        if (id == null || id.isBlank())
            throw new IllegalArgumentException("ID cannot be null or blank");
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative");
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative");

        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public void increaseStock(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        this.quantity += amount;
    }

    public void decreaseStock(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative");
        if (quantity - amount < 0)
            throw new IllegalArgumentException("Not enough stock");
        this.quantity -= amount;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", Name=" + name +
                ", Price=" + price + ", Quantity=" + quantity;
    }
}