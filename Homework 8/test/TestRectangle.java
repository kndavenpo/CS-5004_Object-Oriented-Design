import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import model.Color;
import model.Point;
import model.Rectangle;
import model.Shape;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This is a JUnit test class for the Rectangle class.
 */
public class TestRectangle {
  private Point point1;
  private Point point2;
  private Color color1;
  private Color color2;
  private Rectangle rectangle1;
  private Rectangle rectangle2;

  /**
   * Set up.
   */
  @Before
  public void setUp(){
    this.point1 = new Point(100, 200);
    this.point2 = new Point(300, 75);

    this.color1 = new Color(0, 200, 75);
    this.color2 = new Color(75, 25, 250);

    this.rectangle1 = new Rectangle(point1, color1, 25, 200);
    this.rectangle2 = new Rectangle(point2, color2, 200, 400);
  }

  /**
   * Test the moveTo method.
   */
  @Test
  public void testMoveTo() {
    rectangle1.moveTo(point2);
    assertEquals("(300, 75)", rectangle1.getPoint().toString());

    rectangle2.moveTo(point1);
    assertEquals("(100, 200)", rectangle2.getPoint().toString());
  }

  /**
   * Test the changeColor method.
   */
  @Test
  public void testChangeColor() {
    rectangle1.changeColor(color2);
    assertEquals("(75,25,250)", rectangle1.getColor().toString());

    rectangle2.changeColor(color1);
    assertEquals("(0,200,75)", rectangle2.getColor().toString());
  }

  /**
   * Test the resize method.
   */
  @Test
  public void testResize() {
    rectangle1.resize(75, 50);
    assertEquals(75, rectangle1.getWidth(), 0.001);
    assertEquals(50, rectangle1.getHeight(), 0.001);

    rectangle2.resize(1000, 1);
    assertEquals(1000, rectangle2.getWidth(), 0.001);
    assertEquals(1, rectangle2.getHeight(), 0.001);

    rectangle2.resize(1, 600);
    assertEquals(1, rectangle2.getWidth(), 0.001);
    assertEquals(600, rectangle2.getHeight(), 0.001);
  }

  /**
   * Test the getName and setName methods.
   */
  @Test
  public void testGetNameAndSetName() {
    // Check default value
    assertEquals("unassigned", rectangle1.getName());

    // Set name for the first time
    rectangle1.setName("R1");
    assertEquals("R1", rectangle1.getName());

    // Set name a second time
    rectangle1.setName("renameR1");
    assertEquals("renameR1", rectangle1.getName());
  }

  /**
   * Test the copy method.
   */
  @Test
  public void testCopy() {
    Shape rectangle1Copy = rectangle1.copy();
    assertEquals(rectangle1Copy.toString(), rectangle1.toString());

    Shape rectangle2Copy = rectangle2.copy();
    assertEquals(rectangle2Copy.toString(), rectangle2.toString());
  }

  /**
   * Test the getPoint method.
   */
  @Test
  public void testGetPoint() {
    assertEquals("(100, 200)", rectangle1.getPoint().toString());
    assertEquals("(300, 75)", rectangle2.getPoint().toString());
  }

  /**
   * Test the getColor method.
   */
  @Test
  public void testGetColor() {
    assertEquals("(0,200,75)", rectangle1.getColor().toString());
    assertEquals("(75,25,250)", rectangle2.getColor().toString());
  }

  /**
   * Test the getWidth method.
   */
  @Test
  public void testGetWidth() {
    assertEquals(25, rectangle1.getWidth(), 0.001);
    assertEquals(200, rectangle2.getWidth(), 0.001);
  }

  /**
   * Test the getHeight method.
   */
  @Test
  public void testGetHeight() {
    assertEquals(200, rectangle1.getHeight(), 0.001);
    assertEquals(400, rectangle2.getHeight(), 0.001);
  }

  /**
   * Test the toString method.
   */
  @Test
  public void testToString() {
    rectangle1.setName("R1");
    assertEquals("Name: R1\nType: rect\nMin corner: (100, 200), Width: 25, "
            + "Height: 200, Color: (0,200,75)", rectangle1.toString());

    rectangle2.setName("R2");
    assertEquals("Name: R2\nType: rect\nMin corner: (300, 75), Width: 200, "
            + "Height: 400, Color: (75,25,250)", rectangle2.toString());
  }

  // Test Exceptions

  /**
   * Tests for an illegal construction of a rectangle - negative width.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    Rectangle negativeWidth = new Rectangle(point1, color1, -125, 250);
  }

  /**
   * Tests for an illegal construction of a rectangle - zero width.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    Rectangle zeroWidth = new Rectangle(point1, color1,
            0, 250);
  }

  /**
   * Tests for an illegal construction of a rectangle - width greater than page width.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup3() {
    Rectangle bigWidth = new Rectangle( point1, color1,
            1500, 250);
  }

  /**
   * Tests for an illegal construction of a rectangle - negative height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup4() {
    Rectangle negativeHeight = new Rectangle( point1, color1, 125, -250);
  }

  /**
   * Tests for an illegal construction of a rectangle - zero height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup5() {
    Rectangle zeroHeight = new Rectangle(point1, color1,
            100, 0);
  }

  /**
   * Tests for an illegal construction of a rectangle - height greater than page height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup6() {
    Rectangle bigHeight = new Rectangle(point1, color1,
            150, 2500);
  }

  /**
   * Tests for an illegal call of the moveTo method - move to existing location.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalMoveTo() {
    rectangle1.moveTo(point1);
  }

  /**
   * Tests for an illegal call of the changeColor method - change to existing color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalChangeColor() {
    rectangle1.changeColor(color1);
  }

  /**
   * Tests for an illegal call of the resize method - change to existing size.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalResize1() {
    rectangle1.resize(rectangle1.getWidth(), rectangle1.getHeight());
  }

  /**
   * Tests for an illegal call of the resize method - change width to zero.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalResize2() {
    rectangle1.resize(0, 100);
  }

  /**
   * Tests for an illegal call of the resize method - change height to zero.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalResize3() {
    rectangle1.resize(100, 0);
  }

  /**
   * Tests for an illegal call of the resize method - change width to negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalResize4() {
    rectangle1.resize(-100, 100);
  }

  /**
   * Tests for an illegal call of the resize method - change height to negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalResize5() {
    rectangle1.resize(100, -100);
  }

  /**
   * Tests for an illegal call of the resize method - change width to larger than page width.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalResize6() {
    rectangle1.resize(2000, 100);
  }

  /**
   * Tests for an illegal call of the resize method - change height to larger than page height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalResize7() {
    rectangle1.resize(100, 2000);
  }

  /**
   * Tests for an illegal call of the setName method - set name to null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetName1() {
    rectangle1.setName(null);
  }

  /**
   * Tests for an illegal call of the setName method - set name to empty String.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetName2() {
    rectangle1.setName("");
  }
}