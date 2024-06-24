import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourceEmployee;

public class App {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of employees: ");
		int employeesQtd = scanner.nextInt();

		List<Employee> employees = new ArrayList<>();

		for (int index = 1; index <= employeesQtd; index++) {
			System.out.printf("Employee #%d data:\n", index);

			System.out.print("Outsourced (y/n)? ");
			boolean isOutsourcedEmployee = scanner.next().charAt(0) == 'y';

			System.out.print("Name: ");
			scanner.nextLine();
			String name = scanner.nextLine();

			System.out.print("Hours: ");
			int hours = scanner.nextInt();

			System.out.print("Value per hour: ");
			Double hourValue = scanner.nextDouble();

			if (isOutsourcedEmployee) {
				System.out.print("Additional charge: ");
				Double charge = scanner.nextDouble();

				employees.add(new OutsourceEmployee(name, hours, hourValue, charge));
			} else {
				employees.add(new Employee(name, hours, hourValue));
			}
		}

		System.out.println();
		System.out.println("PAYMENTS:");
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		scanner.close();
	}
}