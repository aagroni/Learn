package Products;

public class KosovoProductFactory implements ProductFactory {


    public Product createProduct(ProductType productType, String productName, double productPrice) {
        return switch (productType) {
            case BOOK -> new Book(productName, productPrice);
            case ELECTRONIC -> new Electronic(productName, productPrice);
            case FOOD_PRODUCT -> new FoodProduct(productName, productPrice);
            default -> throw new NullPointerException();
        };
    }
}