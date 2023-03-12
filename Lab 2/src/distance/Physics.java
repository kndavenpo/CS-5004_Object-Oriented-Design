package distance;

import distance.Point3D;

/**
 * Katie Davenport
 * CS 5004 - Lab 2
 *
 * <p>This class provides a single class method that calculates a unit-less velocity given two
 * Point3D objects and elapsed time. Average velocity is the change in distance over change in
 * time.
 */
public class Physics {

  private Point3D one;
  private Point3D two;

  /**
   * Velocity double.
   *
   * @param one         the one
   * @param two         the two
   * @param elapsedTime the elapsed time
   * @return the double
   * @throws IllegalArgumentException the illegal argument exception
   */
  public static double velocity(Point3D one, Point3D two, double elapsedTime) throws
          IllegalArgumentException {
    if (elapsedTime <= 0) {
      throw new IllegalArgumentException("Elapsed time cannot be zero or negative."); }
    return one.distanceTo(two) / elapsedTime;
  }
}
