package model.services;

public class PayPalService implements IPaymentService {

  @Override
  public Double interest(Double amount, Integer month) {
    return 0.01 * month * amount;
  }

  @Override
  public Double paymentFee(Double amount) {
    return amount * 0.02;
  }
}
