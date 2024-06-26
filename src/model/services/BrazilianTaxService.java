package model.services;

public class BrazilianTaxService implements TaxService {
  public Double tax(Double amount) {
    if (amount <= 100.0) {
      return amount * 0.2;
    } else {
      return amount * 0.15;
    }
  }
}
