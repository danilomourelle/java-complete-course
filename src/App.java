import java.util.Locale;

public class App {
	public static void main(String[] args) throws Exception {
		// Two prints attached
		System.out.print("Hello Word");
		System.out.print("How are you?");

		// Line brake print
		System.out.println("Hello Word");
		System.out.println("How are you?");

		// Concat hard text with variables
		String name = "Danilo";
		int age = 36;

		System.out.print("Hello, my name is " + name + " and I'm " + age + " years old");

		// Using printf to format values
		double height = 1.80;

		System.out.printf("Hi, my name is %s, I'm %d years old and %fm high", name, age, height);

		// How float number can be formatted and are influence by Locale
		Locale.setDefault(Locale.US);
		System.out.printf("Hello, my name is %d and I'm %d years old and I'm %.2fm tall%n", name, age, height);
		System.out.printf("%.4f", height);
	}
}