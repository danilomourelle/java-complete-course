package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractPaymentService {

  private IPaymentService paymentService;
  private Contract contract;

  public ContractPaymentService(Contract cr, IPaymentService paymentService) {
    this.paymentService = paymentService;
    this.contract = cr;
  }

  public void processContract() {
    int months = contract.getInstallmentsQtd();
    double installmentBaseValue = contract.getTotalValue() / months;

    for (int index = 1; index <= months; index++) {
      double installmentValue = getInstallmentFinalValue(installmentBaseValue, index);
      LocalDate instalmentDueDate = getNextDueDate(contract.getDate(), index);

      Installment installment = new Installment(instalmentDueDate, installmentValue);
      contract.setInstallment(installment, index - 1);
    }
  }

  private LocalDate getNextDueDate(LocalDate contractDate, int months) {
    return contractDate.plusMonths(months);
  }

  private Double getInstallmentFinalValue(Double baseValue, int month) {
    double interest = paymentService.interest(baseValue, month);
    double fee = paymentService.paymentFee(baseValue + interest);

    return baseValue + interest + fee;
  }
}
