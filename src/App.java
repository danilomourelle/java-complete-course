import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class App {
  public static void main(String[] args) throws Exception {
    LocalDate today = LocalDate.parse("2024-06-19");
    LocalDateTime now = LocalDateTime.parse("2024-06-19T11:55:30.302942");
    Instant nowISO = Instant.parse("2024-06-19T14:55:30.302942Z");

    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());

    System.out.println(fmt1.format(today));
    System.out.println(fmt2.format(now));
    System.out.println(fmt3.format(nowISO));
  }
}