import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class App {
  public static void main(String[] args) throws Exception {
    Instant nowISO = Instant.parse("2024-06-19T14:55:30.302942Z");

    LocalDate today = LocalDate.ofInstant(nowISO, ZoneId.of("America/Sao_Paulo"));
    LocalDate today2 = nowISO.atZone(ZoneId.of("America/Sao_Paulo")).toLocalDate();
  }
}