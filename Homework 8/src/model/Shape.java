package model;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This interface represents a shape that will appear in a photo album. All Shapes allow users
 * to move to a different location, change color, change size, and create a copy. Shapes can also
 * answer and set their name.
 */
public interface Shape {

  /**
   * Move to a different Point.
   *
   * @param point the point
   * @throws IllegalArgumentException the illegal argument exception
   */
  void moveTo(Point point) throws IllegalArgumentException;

  /**
   * Change the color of Shape.
   *
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  void changeColor(Color color) throws IllegalArgumentException;

  /**
   * Resize the shape.
   *
   * @param newWidth  the new width
   * @param newHeight the new height
   * @throws IllegalArgumentException the illegal argument exception
   */
  void resize(int newWidth,int newHeight) throws IllegalArgumentException;

  /**
   * Gets the name.
   *
   * @return the name
   */
  String getName();

  /**
   * Sets the name.
   *
   * @param name the name
   * @throws IllegalArgumentException the illegal argument exception
   */
  void setName(String name) throws IllegalArgumentException;

  /**
   * Create a copy of the shape.
   *
   * @return the shape
   */
  Shape copy();
}