import java.util.Random;

public class App {
	public static void main(String[] args) throws Exception {
		String hello = buildHelloWorld();
		int times = buildRandomNumber();

		printTextNthTimes(hello, times);
	}

	public static String buildHelloWorld() {
		return "Hello World!!";
	}

	public static int buildRandomNumber() {
		return new Random().nextInt(10);
	}

	public static void printTextNthTimes(String text, int times) {
		for (int index = 0; index < times; index++) {
			System.out.println(text);
		}
	}
}