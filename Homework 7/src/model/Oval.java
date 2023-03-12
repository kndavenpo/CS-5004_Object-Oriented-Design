package model;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This class represents an oval type shape.
 */
public class Oval extends AbstractShape {

  /**
   * Instantiates a new Oval.
   *
   * @param point  the point
   * @param color  the color
   * @param width  the width
   * @param height the height
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Oval(Point point, Color color, double width, double height) {
    super(point, color, width, height);
  }

  @Override
  public Shape copy() {
    Shape copy = new Oval(this.point, this.color, this.width, this.height);
    copy.setName(this.getName());
    return copy;
  }

  @Override
  public String toString() {
    return "Name: " + name
            + "\nType: oval"
            + "\nCenter: " + point.toString() + ", Width: " + width + ", Height: " + height
            + ", Color: " + color.toString();
  }
}
