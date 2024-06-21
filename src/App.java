import java.util.Locale;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		String text = scanner.next(); // Digitado "Foo Bar" no terminal
		System.out.println(text);

		int numInt = scanner.nextInt(); // Digitado "23 45" no terminal
		System.out.println(numInt);

		scanner.useLocale(Locale.US);
		double numDouble = scanner.nextDouble(); // Digitado 2324.12313 23411.12314 no terminal
		System.out.println(numDouble);
		scanner.useLocale(Locale.getDefault());

		String text2 = scanner.next();
		int numInt2 = scanner.nextInt();
		double numDouble2 = scanner.nextDouble();
		// Digitado "Foo 23 35.696" no terminal

		System.out.printf("Texto: %s\nNúmero inteiro: %d\nNúmero decimal: %.3f\n", text2, numInt2, numDouble2);

		int numInt3 = scanner.nextInt(); // Vai gerar uma quebra de linha presa;
		String s1, s2, s3;
		scanner.nextLine(); // Vai descartar a quebra pendente;
		s1 = scanner.nextLine(); // Vai pegar o valor desejado
		s2 = scanner.nextLine();
		s3 = scanner.nextLine();
		System.out.println(numInt3);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		scanner.close(); // Fecha a observação do objeto
	}
}