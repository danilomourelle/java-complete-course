import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.entities.MyComparator;
import model.entities.Product;

public class App {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.0));
		list.add(new Product("Notebook", 1200.0));
		list.add(new Product("Tablet", 450.0));

		// Using the class MyComparator
		list.sort(new MyComparator());

		// Anonymous class implementation
		Comparator<Product> comp = new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			}
		};
		list.sort(comp);

		// Lambda expression
		list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

		for (Product p : list) {
			System.out.println(p);
		}
	}
}
