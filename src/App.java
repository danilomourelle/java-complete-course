import java.util.Locale;
import java.util.Scanner;

import model.services.PrintService;

public class App {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		PrintService<Integer> ps = new PrintService<>();

		System.out.println("How many values? ");
		int n = sc.nextInt();

		// ps.addValue("Maria"); -> erro

		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			ps.addValue(value);
		}

		ps.print();
		Integer x = ps.first();
		System.out.println("First: " + x);

		sc.close();
	}
}
