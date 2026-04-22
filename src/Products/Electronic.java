package Products;

class Electronic extends Product {
    public Electronic(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println("Processing Electronic Product: " + name + " - Price: €" + price);
    }
}