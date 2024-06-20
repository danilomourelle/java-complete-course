package entities;

import java.util.ArrayList;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
  private String name;
  private WorkerLevel level;
  private Double baseSalary;

  private Department department;
  private List<HourContract> contracts;

  public Worker() {
  }

  public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;

    this.department = department;
    this.contracts = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public WorkerLevel getLevel() {
    return level;
  }

  public Department getDepartment() {
    return department;
  }

  public void addContract(HourContract contract) {
    contracts.add(contract);
  }

  public void removeContract(HourContract contract) {
    contracts.remove(contract);
  }

  public Double income(int year, int month) {
    Double totalIncome = this.baseSalary;
    for (HourContract contract : this.contracts) {
      int contractYear = contract.getDate().getYear();
      int contractMonth = contract.getDate().getMonthValue();

      if (contractYear == year && contractMonth == month) {
        totalIncome += contract.totalValue();
      }
    }

    return totalIncome;
  }
}
