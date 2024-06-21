package data;

import entities.Product;

public class SubClass extends Product{
  public SubClass() {
    super("TV", 900.0, 10);
  }

  public void testAccess() {
    price = 50.0; // --> OK
    quantity = 10; // --> OK
    // name = "Toshiba"; --> error
    // model = "Computer"; --> error
  }
}
