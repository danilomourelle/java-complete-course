import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class App {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);

		System.out.print("Enter department's name: ");
		Department department = new Department(sc.next());

		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Level: ");
		String level = sc.next();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(
				name,
				WorkerLevel.valueOf(level),
				baseSalary,
				department);

		System.out.print("How many contracts to this worker? ");
		double contractsQtd = sc.nextInt();
		for (int index = 1; index <= contractsQtd; index++) {
			System.out.println("Enter contract #" + index);
			System.out.print("Date (DD/MM/YYYY): ");
			LocalDate contractDate = LocalDate.parse(
					sc.next(),
					DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			System.out.print("Value per hour: ");
			double contractHourValue = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int contractDuration = sc.nextInt();

			HourContract contract = new HourContract(contractDate, contractHourValue, contractDuration);
			worker.addContract(contract);
		}

		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String dateToCheck = sc.next();
		TemporalAccessor temporalAccessor = DateTimeFormatter
				.ofPattern("MM/yyyy")
				.parse(dateToCheck);

		/*
		 * LocalDate dateToSelect = LocalDate.of(
		 * ta.get(ChronoField.YEAR),
		 * ta.get(ChronoField.MONTH_OF_YEAR),
		 * 1);
		 */

		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		// System.out.println("Income: " + worker.income(dateToSelect.getYear(),
		// dateToSelect.getMonthValue()));
		System.out.println("Income: " + String.format(
				"%.2f",
				worker.income(
						temporalAccessor.get(ChronoField.YEAR),
						temporalAccessor.get(ChronoField.MONTH_OF_YEAR))));

		sc.close();
	}
}