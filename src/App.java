import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			System.out.print("Enter room number: ");
			int roomNumber = scanner.nextInt();

			System.out.print("Enter check-in date: ");
			LocalDate checkIn = LocalDate.parse(scanner.next(), formatter);

			System.out.print("Enter check-out date: ");
			LocalDate checkOut = LocalDate.parse(scanner.next(), formatter);

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Enter check-in date: ");
			checkIn = LocalDate.parse(scanner.next(), formatter);

			System.out.print("Enter check-out date: ");
			checkOut = LocalDate.parse(scanner.next(), formatter);

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

		} catch (DateTimeParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		} finally {
			scanner.close();
		}
	}
}
