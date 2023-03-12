package model;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This class represents a rectangle type shape.
 */
public class Rectangle extends AbstractShape {

  /**
   * Instantiates a new Rectangle.
   *
   * @param point  the point
   * @param color  the color
   * @param width  the width
   * @param height the height
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Rectangle(Point point, Color color, int width, int height) {
    super(point, color, width, height);
    this.type = "rect";
  }

  @Override
  public Shape copy() {
    Shape copy = new Rectangle(this.point, this.color, this.width, this.height);
    copy.setName(this.getName());
    return copy;
  }

  @Override
  public String toString() {
    return "Name: " + name
            + "\nType: " + type
            + "\nMin corner: " + point.toString() + ", Width: " + width + ", Height: " + height
            + ", Color: " + color.toString();
  }
}
