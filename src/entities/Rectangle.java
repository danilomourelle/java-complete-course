package entities;

public class Rectangle extends Shape  {
  private Double width;
  private Double height;
  
  public Rectangle(Double width, Double height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public Double area() {
    return width * height;
  }
}
