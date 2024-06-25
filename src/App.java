import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Reservation;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Enter room number: ");
		int roomNumber = scanner.nextInt();

		System.out.print("Enter check-in date: ");
		LocalDate checkIn = LocalDate.parse(scanner.next(), formatter);

		System.out.print("Enter check-out date: ");
		LocalDate checkOut = LocalDate.parse(scanner.next(), formatter);

		if (!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Enter check-in date: ");
			checkIn = LocalDate.parse(scanner.next(), formatter);

			System.out.print("Enter check-out date: ");
			checkOut = LocalDate.parse(scanner.next(), formatter);

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}

		}
	}
}