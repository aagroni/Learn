package Products;

class FoodProduct extends Product {
    public FoodProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public void process() {
        System.out.println("Processing Food Product: " + name +  " - Price: €" + price);
    }
}