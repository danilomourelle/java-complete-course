package model.entities;

public class Employee implements Comparable<Employee> {
  private String name;
  private Double salary;

  public Employee() {
  }

  public Employee(String name, Double salary) {
    this.name = name;
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public Double getSalary() {
    return salary;
  }

  @Override
  public int compareTo(Employee other) {
    return name.compareTo(other.getName());
  }
}
