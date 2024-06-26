package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
  Double pricePerHour;
  Double pricePerDay;

  private TaxService taxService;

  public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
    this.pricePerHour = pricePerHour;
    this.pricePerDay = pricePerDay;
    this.taxService = taxService;
  }

  public void processInvoice(CarRental carRental) {
    Duration duration = Duration.between(carRental.getStart(), carRental.getFinish());
    double minutes = duration.toMinutes();
    double hours = Math.ceil(minutes / 60.0); 

    double basicPayment;
    if (hours <= 12.0) {
      basicPayment = Math.ceil(hours) * pricePerHour;
    } else {
      basicPayment = Math.ceil(hours / 24.0) * pricePerDay;
    }

    double tax = taxService.tax(basicPayment);

    carRental.setInvoice(new Invoice(basicPayment, tax));
  }


}
