import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import model.entities.Product;

public class App {
	public static void main(String[] args) {
		Set<Product> hashSet = new HashSet<>();
		
		hashSet.add(new Product("TV", 900.0));
		hashSet.add(new Product("Notebook", 1200.0));
		hashSet.add(new Product("Tablet", 400.0));

		System.out.println(hashSet.contains(new Product("Notebook", 1200.0))); // returns false if hashCode and equals are not implemented

		Set<Product> treeSet = new TreeSet<>(hashSet);

		for (Product p : treeSet) {
			System.out.println(p); // will crash if Product class does not implements Comparable
		}
	}
}
