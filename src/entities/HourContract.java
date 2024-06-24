package entities;

import java.time.LocalDate;

public class HourContract {
  private LocalDate date;
  private Double valuePerHour;
  private Integer hoursWorked;
  
  public HourContract(LocalDate date, Double valuePerHour, Integer hoursWorked) {
    this.date = date;
    this.valuePerHour = valuePerHour;
    this.hoursWorked = hoursWorked;
  }

  public LocalDate getDate() {
    return date;
  }

  public Double totalValue() {
    return this.valuePerHour * this.hoursWorked;
  }
}
