package entities;

public class Product {
  private String name;
  private Double price;
  private Integer quantity;

  public Product(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public void add(int quantity) {
    this.quantity += quantity;
  }

  public void remove(int quantity) {
    this.quantity -= quantity;
  }

  public double totalValueInStock() {
    return price * quantity;
  }

  @Override
  public String toString() {
    return String.format("%s, $ %.2f, %d units, Total: $ %.2f", name, price, quantity, totalValueInStock());
  }
}