
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import model.entities.Product;
import utils.ProductConsumer;

public class App {
	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		double rate = 1.1;

		// Consumer
		list.forEach(new ProductConsumer());

		// Reference method com método estático
		list.forEach(Product::staticProductConsumer);

		// Reference method com método não estático
		list.forEach(Product::nonStaticProductConsumer);

		// Expressão lambda declarada
		Consumer<Product> consumer = p -> p.setPrice(p.getPrice() * rate); 
		list.forEach(consumer);

		// Expressão lambda inline
		list.forEach(p -> p.setPrice(p.getPrice() * rate));

		list.forEach(System.out::println);
	}
}