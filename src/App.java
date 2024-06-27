import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractPaymentService;
import model.services.PayPalService;

public class App {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), formatter);
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int installmentsQtd = sc.nextInt();

		Contract contract = new Contract(number, date, totalValue, installmentsQtd);

		System.out.println("Installments:");

		new ContractPaymentService(contract, new PayPalService()).processContract();

		for (int index = 0; index < contract.getInstallmentsQtd(); index++) {
			System.out.println(contract.getInstallments()[index]);
		}

		sc.close();
	}
}
