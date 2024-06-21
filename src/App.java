import java.util.Locale;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

		System.out.println("How many heights do you want to input?");
    int quantity = scanner.nextInt();
    double[] height = new double[quantity];

    for (int i = 0; i < quantity; i++) {
      height[i] = scanner.nextDouble();
    }

		// crate an array of prices already set
		double[] price = { 10.0, 15.0, 20.0, 25.0, 30.0 };

    scanner.close();
	}
}