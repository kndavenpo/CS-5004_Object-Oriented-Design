package model;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This class represents an RGB color. A Color is an attribute of a shape. A color has a red,
 * green, and blue value that each range from 0 to 255. A Color can answer a string representation
 * of itself.
 */
public class Color {
  private int red;
  private int green;
  private int blue;
  private static int minValue = 0;  // Do I need to add in final?
  private static int maxValue = 255; // Do I need to add in final?


  /**
   * Instantiates a new Color.
   *
   * @param red   the red
   * @param green the green
   * @param blue  the blue
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Color(int red, int green, int blue) throws IllegalArgumentException {
    if (red < minValue || red > maxValue
            || green < minValue || green > maxValue
            || blue < minValue || blue > maxValue) {
      throw new IllegalArgumentException("RGB values must be between 0 and 255.");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
  //NEW

  public int getRed() {
    return red;
  }

  public int getGreen() {
    return green;
  }

  public int getBlue() {
    return blue;
  }

  @Override
  public String toString() {
    return "(" + red + "," + green + "," + blue + ")";
  }
}
