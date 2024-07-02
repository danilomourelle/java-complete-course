
import java.util.ArrayList;
import java.util.List;

import model.entities.Product;
import model.service.ProductService;

public class App {
	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		ProductService ps = new ProductService();

		double sum = ps.filteredSum(list, p -> p.getPrice() < 100.0);
		System.out.println("Sum under 100 = " + String.format("%.2f", sum));

		sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');
		System.out.println("Sum starting with 'T' = " + String.format("%.2f", sum));
	}
}