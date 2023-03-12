import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import model.Point;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This is a JUnit test class for the Point class.
 */
public class TestPoint {
  private Point point1;
  private Point point2;
  private Point point3;
  private Point point4;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    this.point1 = new Point(100, 200);
    this.point2 = new Point(300, 550);

    // Edge cases
    this.point3 = new Point(1, 599);
    this.point4 = new Point(999, 1);
  }

  /**
   * Test get x.
   */
  @Test
  public void testGetX() {
    assertEquals(100, point1.getX());
    assertEquals(300, point2.getX());
    assertEquals(1, point3.getX());
    assertEquals(999, point4.getX());
  }

  /**
   * Test get y.
   */
  @Test
  public void testGetY() {
    assertEquals(200, point1.getY());
    assertEquals(550, point2.getY());
    assertEquals(599, point3.getY());
    assertEquals(1, point4.getY());
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("(100, 200)", point1.toString());
    assertEquals("(300, 550)", point2.toString());
    assertEquals("(1, 599)", point3.toString());
    assertEquals("(999, 1)", point4.toString());
  }

  // Test Exceptions
  /**
   * Tests for an illegal construction of a point - negative x.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    Point negativeX = new Point(-50, 300);
  }

  /**
   * Tests for an illegal construction of a point - x larger than page width.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    Point largeX = new Point(3000, 300);
  }

  /**
   * Tests for an illegal construction of a point - negative y.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup3() {
    Point negativeY = new Point(50, -300);
  }

  /**
   * Tests for an illegal construction of a point - y larger than page height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup4() {
    Point largeY = new Point(100, 3000);
  }
}
