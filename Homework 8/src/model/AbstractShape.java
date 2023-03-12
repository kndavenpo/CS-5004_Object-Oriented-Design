package model;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This is the abstract superclass of all Shape concrete classes. It implements the Shape
 * interface. In addition to the interface methods, an Abstract Shape can also return its Point,
 * Color, height, and width.
 */
public class AbstractShape implements Shape {

  /**
   * The Name.
   */
  protected String name;

  /**
   * The Point.
   */
  protected Point point;
  /**
   * The Color.
   */
  protected Color color;
  /**
   * The Width.
   */
  protected int width;
  /**
   * The Height.
   */
  protected int height;
  /**
   * The type
   */
  protected String type;
  /**
   * The constant pageWidth.
   */
  protected static int pageWidth = 1000; // Placeholder value
  /**
   * The constant pageHeight.
   */
  protected static int pageHeight = 1000; // Placeholder value

  /**
   * Instantiates a new Abstract shape.
   *
   * @param point  the point
   * @param color  the color
   * @param width  the width
   * @param height the height
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractShape(Point point, Color color, int width, int height) throws
          IllegalArgumentException {
    if (width < 0 || width > pageWidth) {
      throw new IllegalArgumentException("The width must be greater than or equal to 0 and less "
              + "than or equal to the page width.");
    }
    if (height < 0 || height > pageHeight) {
      throw new IllegalArgumentException("The height must be greater than or equal to 0 and less "
              + "than or equal to the page height.");
    }
    this.name = "unassigned"; // Placeholder name that is not null or empty.
    this.type = "unassigned"; // Placeholder
    this.point = point;
    this.color = color;
    this.width = width;
    this.height = height;
  }

  // Interface methods
  @Override
  public void moveTo(Point newPoint) throws IllegalArgumentException {
    if (this.point.getX() == newPoint.getX() && this.point.getY() == newPoint.getY()) {
      throw new IllegalArgumentException("This is the current location.");
    }
    this.point = newPoint;
  }

  @Override
  public void changeColor(Color newColor) throws IllegalArgumentException {
    if (this.color == newColor) {
      throw new IllegalArgumentException("This is the current color.");
    }
    this.color = newColor;
  }

  @Override
  public void resize(int newWidth, int newHeight) throws IllegalArgumentException {
    if (this.width == newWidth && this.height == newHeight) {
      throw new IllegalArgumentException("This is the current size.");
    }
    if (newWidth < 0 || newWidth > pageWidth) {
      throw new IllegalArgumentException("The width must be greater than or equal to 0 and less "
              + "than or equal to the page width.");
    }
    if (newHeight < 0 || newHeight > pageHeight) {
      throw new IllegalArgumentException("The height must be greater than or equal to 0 and less " +
              "than or equal to the page height.");
    }
    this.width = newWidth;
    this.height = newHeight;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) throws IllegalArgumentException {
    if (name == null || name.length() == 0) {
      throw new IllegalArgumentException("The name cannot be null or empty.");
    }
    this.name = name;
  }

  @Override
  public Shape copy() {
    return null; // This will be overridden in each of the subclasses.
  }

  // Non-interface methods
  /**
   * Gets point.
   *
   * @return the point
   */
  public String getPoint() {
    return this.point.toString();
  }

  /**
   * Gets the x-coordinate
   *
   * @return the point
   */
  public int getX() {
    return this.point.getX();
  }

  /**
   * Gets the y-coordinate
   *
   * @return the point
   */
  public int getY() {
    return this.point.getY();
  }

  /**
   * Gets color.
   *
   * @return the color
   */
  public String getColor() {
    return this.color.toString();
  }

  // NEW
  public int getRed() { return this.color.getRed(); }

  public int getGreen() { return this.color.getGreen(); }

  public int getBlue() { return this.color.getBlue(); }

  /**
   * Gets width.
   *
   * @return the width
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Gets height.
   *
   * @return the height
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Gets type
   *
   * @return the type
   */
  public String getType() {
    return this.type;
  }
}