
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import model.entities.Product;
import utils.ProductFunction;

public class App {
	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		List<String> names;

		// Function
		names = list.stream().map(new ProductFunction()).collect(Collectors.toList());

		// Reference method com método estático
		names = list.stream().map(Product::staticProductFunction).collect(Collectors.toList());

		// Reference method com método não estático
		names = list.stream().map(Product::nonStaticProductFunction).collect(Collectors.toList());

		// Expressão lambda declarada
		Function<Product, String> func = p -> p.getName().toUpperCase();
		names = list.stream().map(func).collect(Collectors.toList());

		// Expressão lambda inline
		names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());

		names.forEach(System.out::println);
	}
}