package entities;

public class Circule extends Shape {
  private Double radius;

  public Circule(Double radius) {
    this.radius = radius;
  }

  @Override
  public Double area() {
    return Math.PI * radius * radius;
  }
}
