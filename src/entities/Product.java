package entities;

public class Product {
  public String name;
  public double price;
  public int quantity;

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