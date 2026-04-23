

package Products;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        ProductFactory kosovoFactory = new KosovoProductFactory();
        List<Product> products = new ArrayList<>();

       Product p1 = kosovoFactory.createProduct(ProductType.BOOK, "Clean Code", 15);
       Product p2 = kosovoFactory.createProduct(ProductType.FOOD_PRODUCT, "Pizza", 4.5);
       Product p3 = kosovoFactory.createProduct(ProductType.ELECTRONIC, "Smart TV LG", 650);

       products.add(p1);
       products.add(p2);
       products.add(p3);

       //Examples of Using Funcional Interfaces
       //Consumer<Product> c = x -> System.out.println(x);
       Consumer<Product> c = System.out::println;
       Consumer<Product> ex = p -> p.process();

        products.forEach(c);
        System.out.println("_______________________________");
        products.forEach(ex);
    }
}
