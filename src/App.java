import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class App {
	public static void main(String[] args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter product data:");
		System.out.print("Name: ");
		String name = scanner.nextLine();
		System.out.print("Price: ");
		double price = scanner.nextDouble();
		System.out.print("Quantity in stock: ");
		int quantity = scanner.nextInt();

		Product product = new Product();
		product.name = name;
		product.price = price;
		product.quantity = quantity;

		System.out.println();
		System.out.println("Product data: " + product);
		
		System.out.println();
		System.out.print("Enter the number of products to be added in stock: ");
		product.add(scanner.nextInt());
		System.out.println("Updated data: " + product);

		scanner.close();
	}
}