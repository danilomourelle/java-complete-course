package model.services;

public class BrazilianService implements IInterestService {
  private double interestRate;

  public BrazilianService(double interestRate) {
    this.interestRate = interestRate;
  }

  @Override
  public double getInterestRate() {
    return interestRate;
  }
}
