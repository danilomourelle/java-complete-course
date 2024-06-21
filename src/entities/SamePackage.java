package entities;

public class SamePackage {
  public static void main(String[] args) {
    Product product = new Product("TV", 900.0, 10);
    product.price = 50.0; // --> OK
    product.model = "Computer"; // --> OK
    product.quantity = 10; // --> OK
    // product.name = "Toshiba"; --> error
  }
}
