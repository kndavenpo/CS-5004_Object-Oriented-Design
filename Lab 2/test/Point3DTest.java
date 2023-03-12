import distance.Point3D;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS5004 - Lab 2
 *
 * <p>This is a JUnit test class for the Point3D class.
 */

public class Point3DTest {
  private Point3D pointOne;
  private Point3D pointTwo;
  private Point3D pointThree;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    this.pointOne = new Point3D(-1, 4, -2);
    this.pointTwo = new Point3D(0, 0, 0);
    this.pointThree = new Point3D(-1, 4, -2);
  }

  /**
   * Test the getX method.
   */
  @Test
  public void testGetX() {
    assertEquals(-1, pointOne.getX(), 0.001);
    assertEquals(0, pointTwo.getX(), 0.001);
  }

  /**
   * Test the getY method.
   */
  @Test
  public void testGetY() {
    assertEquals(4, pointOne.getY(), 0.001);
    assertEquals(0, pointTwo.getY(), 0.001);
  }

  /**
   * Test the getZ method.
   */
  @Test
  public void testGetZ() {
    assertEquals(-2, pointOne.getZ(), 0.001);
    assertEquals(0, pointTwo.getZ(), 0.001);
  }

  /**
   * Test the distanceTo method.
   */
  @Test
  public void testDistanceTo() {
    assertEquals(4.582576, pointOne.distanceTo(pointTwo), .001);
    assertEquals(0, pointOne.distanceTo(pointThree), .001);
  }

  /**
   * Test the testEquals method.
   */
  @Test
  public void testEquals() {
    assertEquals(false, pointOne.equals(pointTwo));
    assertEquals(true, pointOne.equals(pointThree));
  }
}

