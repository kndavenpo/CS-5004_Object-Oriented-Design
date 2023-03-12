package model;

import static model.AbstractShape.pageHeight;
import static model.AbstractShape.pageWidth;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This class represents a point on a canvas where a shape will be placed. The point has an X
 * and Y coordinate that must be greater or equal to 0 and less than the page height / width. A
 * Point can answer its X and Y coordinates and return a String representation of itself.
 */
public class Point {
  private int pointX;
  private int pointY;


  /**
   * Instantiates a new Point.
   *
   * @param x the x
   * @param y the y
   */
  public Point(int x, int y) throws IllegalArgumentException {
    if (x < 0 || x >= pageWidth) {
      throw new IllegalArgumentException("The X must be greater than or equal to 0 and less than "
              + "or equal to the page width.");
    }
    if (y < 0 || y >= pageHeight) {
      throw new IllegalArgumentException("The Y must be greater than or equal to 0 and less than "
              + "or equal to the page height.");
    }
    this.pointX = x;
    this.pointY = y;
  }

  /**
   * Answers the x coordinate.
   *
   * @return the x
   */
  public int getX() {
    return this.pointX;
  }

  /**
   * Answers the y coordinate.
   *
   * @return the y
   */
  public int getY() {
    return this.pointY;
  }

  @Override
  public String toString() {
    return "(" + this.pointX + ", " + this.pointY + ")";
  }
}
