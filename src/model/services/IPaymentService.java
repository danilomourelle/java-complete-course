package model.services;

public interface IPaymentService {
  public Double paymentFee(Double amount);

  public Double interest(Double amount, Integer month);
}
