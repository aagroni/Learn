package Products;


public interface ProductFactory {
     Product createProduct(ProductType productType, String productName, double productPrice);
}
