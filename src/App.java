import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
  public static void main(String[] args) throws Exception {
    // Current date and time
    LocalDate today = LocalDate.now();
    LocalDateTime now = LocalDateTime.now();
    Instant nowISO = Instant.now();

    System.out.println("Today: " + today);
    System.out.println("Now: " + now);
    System.out.println("Now ISO: " + nowISO);

    // Parse date and time from ISO format
    today = LocalDate.parse("2024-06-19");
    now = LocalDateTime.parse("2024-06-19T11:55:30.302942");
    nowISO = Instant.parse("2024-06-19T14:55:30.302942Z");
    Instant nowISOFromTZ = Instant.parse("2024-06-19T11:55:30.302942-03:00");

    System.out.println("Today: " + today);
    System.out.println("Now: " + now);
    System.out.println("Now ISO: " + nowISO);
    System.out.println("Now ISO from TZ: " + nowISOFromTZ);

    // Parse date and time from custom format
    String stringDate = "19/06/2024";
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate date = LocalDate.parse(stringDate, format);

    stringDate = "19/06/2024 12:30";
    format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(stringDate, format);

    // Individual values
    int year = 2024;
    int month = 06;
    int day = 19;
    int hour = 12;
    int minute = 00;

    date = LocalDate.of(year, month, day);
    dateTime = LocalDateTime.of(year, month, day, hour, minute);
  }
}