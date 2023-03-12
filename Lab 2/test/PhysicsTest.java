import distance.Physics;
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

public class PhysicsTest {

  private Point3D pointOne;
  private Point3D pointTwo;
  private Point3D pointThree;
  private double elapsedTime;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    pointOne = new Point3D(-1, 4, -2);
    pointTwo = new Point3D();
    pointThree = new Point3D(-1, 4, -2);
  }

  /**
   * Test the velocity method.
   */
  @Test
  public void testVelocity() {
    assertEquals(0.4582576, Physics.velocity(pointOne, pointTwo, 10), 0.001);
    assertEquals(0, Physics.velocity(pointOne, pointThree, 10), 0.001);
  }

  /**
   * Test the velocity method with bad inputs.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testBadVelocity() {
    Physics.velocity(pointOne, pointTwo, 0);
  }
}


