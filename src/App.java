import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class App {
  public static void main(String[] args) throws Exception {
    LocalDate today = LocalDate.parse("2024-06-19");
    LocalDate yesterday = today.minusDays(1);

    LocalDateTime now = LocalDateTime.parse("2024-06-19T11:55:30.302942");
    LocalDateTime minus24Hours = now.minusHours(24);

    Instant nowISO = Instant.parse("2024-06-19T14:55:30.302942Z");
    Instant tomorrow = nowISO.plus(1, ChronoUnit.DAYS);
    
    Duration duration = Duration.between(now, minus24Hours);
    duration = Duration.between(nowISO, tomorrow);
    duration = Duration.between(today.atStartOfDay(), yesterday.atStartOfDay());
    System.out.println(duration.toDays());
  }
}