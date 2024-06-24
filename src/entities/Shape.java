package entities;

import entities.enums.Color;

public abstract class Shape {
  private Color color;

  public Color getColor() {
    return color;
  }

  public abstract Double area();
}
