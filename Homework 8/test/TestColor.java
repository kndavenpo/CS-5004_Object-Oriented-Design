import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import model.Color;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This is a JUnit test class for the Color class.
 */
public class TestColor {
  private Color color1;
  private Color color2;
  private Color color3;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    // Test edge cases for red, green, and blue
    this.color1 = new Color(0, 255, 100);
    this.color2 = new Color(100, 0, 255);
    this.color3 = new Color(255, 100, 0);
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("(0,255,100)", color1.toString());
    assertEquals("(100,0,255)", color2.toString());
    assertEquals("(255,100,0)", color3.toString());
  }

  // Test Exceptions
  /**
   * Tests for an illegal construction of a color - negative red value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    Color NegativeRed = new Color(-50, 0, 100);
  }

  /**
   * Tests for an illegal construction of a color - greater than max red value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    Color BigRed = new Color(1050, 0, 100);
  }

  /**
   * Tests for an illegal construction of a color - negative green value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup3() {
    Color NegativeGreen = new Color(100, -775, 100);
  }

  /**
   * Tests for an illegal construction of a color - greater than max green value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup4() {
    Color BigGreen = new Color(100, 1000, 100);
  }

  /**
   * Tests for an illegal construction of a color - negative blue value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup5() {
    Color NegativeBlue = new Color(100, 100, -100);
  }

  /**
   * Tests for an illegal construction of a color - greater than max blue value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup6() {
    Color BigBlue = new Color(100, 100, 1000);
  }
}
