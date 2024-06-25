package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Reservation {
  private Integer roomNumber;
  private LocalDate checkIn;
  private LocalDate checkOut;

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  public Reservation() {
  }

  public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
    this.roomNumber = roomNumber;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  public Integer duration() {
    return (int) ChronoUnit.DAYS.between(checkIn, checkOut);
  }

  public void updateDates(LocalDate checkIn, LocalDate checkOut) {
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }

  @Override
  public String toString() {
    return "Room " + roomNumber +
        ", check-in: " + DATE_FORMAT.format(checkIn) +
        ", check-out: " + DATE_FORMAT.format(checkOut) +
        ", " + duration() + " nights";
  }
}
