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

		Product product = new Product(name, price, quantity);
		product.price = 50.0; // --> OK
		// product.name = "Computer"; --> error
		// product.quantity = 10; --> error
		// product.model = "Toshiba"; --> error

		scanner.close();
	}
}