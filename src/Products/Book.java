package Products;

class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println("Processing Book: " + name+ " - Price: €" + price );
    }
}