package model.entities;

import java.time.LocalDateTime;

public class CarRental {
  LocalDateTime start;
  LocalDateTime finish;

  private Vehicle vehicle;
  private Invoice invoice;

  public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle) {
    this.start = start;
    this.finish = finish;
    this.vehicle = vehicle;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
  }

  public Invoice getInvoice() {
    return invoice;
  }
  
  public LocalDateTime getStart() {
    return start;
  }

  public LocalDateTime getFinish() {
    return finish;
  }
}
