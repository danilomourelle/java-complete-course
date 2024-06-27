package model.entities;

import java.time.LocalDate;

public class Contract {
  private Integer number;
  private LocalDate date;
  private Double totalValue;

  private Installment[] installments = null;

  public Contract(Integer number, LocalDate date, Double totalValue, int installmentsQtd) {
    this.number = number;
    this.date = date;
    this.totalValue = totalValue;
    this.installments = new Installment[installmentsQtd];
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Double getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(Double totalValue) {
    this.totalValue = totalValue;
  }

  public void setInstallment(Installment installment, Integer index) {
    this.installments[index] = installment;
  }

  public Integer getInstallmentsQtd() {
    return installments.length;
  }

  public Installment[] getInstallments() {
    return installments;
  }
}
