package distance;

import java.util.Objects;

/**
 * Katie Davenport
 * CS 5004 - Lab 2
 *
 * <p>This class represents a point in 3-D cartesian space. This class returns the coordinates of
 * the point, calculates the distance between two points, and checks if two points are equal.
 */
public class Point3D {
  private int x;
  private int y;
  private int z;

  /**
   * Constructs a Point3D object with the given X, Y, and Z coordinates.
   *
   * @param x the x-coordinate
   * @param y the y-coordinate
   * @param z the z-coordinate
   */
  public Point3D(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Constructs a Point3D object with default values of zero for the X, Y, and Z coordinates.
   */
  public Point3D() {
    this.x = 0;
    this.y = 0;
    this.z = 0;
  }

  /**
   * Gets the x-coordinate of this point.
   *
   * @return the x-coordinate (an integer)
   */
  public int getX() {
    return this.x;
  }

  /**
   * Gets the y-coordinate of this point.
   *
   * @return the y-coordinate (an integer)
   */
  public int getY() {
    return this.y;
  }

  /**
   * Gets the z-coordinate of this point.
   *
   * @return the z-coordinate (an integer)
   */
  public int getZ() {
    return this.z;
  }

  /**
   * Calculates the distance between this point and another point.
   *
   * @param other the other point
   * @return the distance between points (double)
   */
  public double distanceTo(Point3D other) {
    return Math.sqrt(Math.pow((this.x - other.getX()), 2) + Math.pow((this.y - other.getY()), 2)
            + Math.pow((this.z - other.getZ()), 2));
  }

  /**
   * Determines if two points are equal.
   *
   * @param other the other point
   * @return boolean
   */
  public boolean equals(Object other) {
    if (this == other) return true;
    if (!(other instanceof Point3D)) return false;
    Point3D point3D = (Point3D) other;
    return x == point3D.x && y == point3D.y && z == point3D.z;
  }
}