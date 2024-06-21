import java.util.Random;

public class App {
	public static void main(String[] args) throws Exception {
		// while -> it may not run if condition is already fulfilled
		int number1 = new Random().nextInt(10);
		while (number1 < 5) {
			System.out.println("Oh, no!! Number to low. Trying again.");
			number1 = new Random().nextInt(10);
			System.out.println(number1);
		}

		// do/while -> it will run at least once
		int number;
		do {
			number = new Random().nextInt(10);
		} while (number < 5);

		// for
		for (int index = 0; index < 10; index++) {
			System.out.println(index);
		}
	}
}