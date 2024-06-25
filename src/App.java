import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		try {
			String[] names = scanner.nextLine().split(" ");
			int position = scanner.nextInt();
			System.out.println(names[position]); 
		} catch (ArrayIndexOutOfBoundsException error) {
			System.out.println("Invalid position!");
		} catch (InputMismatchException error) {
			System.out.println("Position is not a number!");
		} finally {
			scanner.close();
		}

		System.out.println("End of program");
	}
}