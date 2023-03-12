import org.junit.Before;
import org.junit.Test;

import model.Color;
import model.Point;
import model.Oval;
import model.Shape;

import static org.junit.Assert.assertEquals;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This is a JUnit test class for the Oval class.
 */
public class TestOval {
  private Point point1;
  private Point point2;
  private Color color1;
  private Color color2;
  private Oval oval1;
  private Oval oval2;

  /**
   * Set up.
   */
  @Before
  public void setUp(){
    this.point1 = new Point(1, 150);
    this.point2 = new Point(250, 599);

    this.color1 = new Color(0, 0, 255);
    this.color2 = new Color(0, 255, 0);

    this.oval1 = new Oval(point1, color1, 10, 599);
    this.oval2 = new Oval(point2, color2, 999, 150);
  }

  /**
   * Test the moveTo method.
   */
  @Test
  public void testMoveTo() {
    oval1.moveTo(point2);
    assertEquals("(250, 599)", oval1.getPoint().toString());

    oval2.moveTo(point1);
    assertEquals("(1, 150)", oval2.getPoint().toString());
  }

  /**
   * Test the changeColor method.
   */
  @Test
  public void testChangeColor() {
    oval1.changeColor(color2);
    assertEquals("(0,255,0)", oval1.getColor().toString());

    oval2.changeColor(color1);
    assertEquals("(0,0,255)",oval2.getColor().toString());
  }

  /**
   * Test the resize method.
   */
  @Test
  public void testResize() {
    oval1.resize(300, 200);
    assertEquals(300, oval1.getWidth(), .001);
    assertEquals(200, oval1.getHeight(), 0.001);

    oval2.resize(1000, 600);
    assertEquals(1000, oval2.getWidth(), 0.001);
    assertEquals(600, oval2.getHeight(), 0.001);
  }

  /**
   * Test the getName and setName methods.
   */
  @Test
  public void testGetNameAndSetName() {
    // Check default value
    assertEquals("unassigned", oval1.getName());

    // Set name for the first time
    oval1.setName("oval1");
    assertEquals("oval1", oval1.getName());

    // Set name a second time
    oval1.setName("renameOval1");
    assertEquals("renameOval1", oval1.getName());
  }

  /**
   * Test the copy method.
   */
  @Test
  public void testCopy() {
    Shape oval1Copy = oval1.copy();
    assertEquals(oval1Copy.toString(), oval1.toString());

    Shape oval2Copy = oval2.copy();
    assertEquals(oval2Copy.toString(), oval2.toString());
  }

  /**
   * Test the getPoint method.
   */
  @Test
  public void testGetPoint() {
    assertEquals("(1, 150)", oval1.getPoint().toString());
    assertEquals("(250, 599)", oval2.getPoint().toString());
  }

  /**
   * Test the getColor method.
   */
  @Test
  public void testGetColor() {
    assertEquals("(0,0,255)", oval1.getColor().toString());
    assertEquals("(0,255,0)", oval2.getColor().toString());
  }

  /**
   * Test the getWidth method.
   */
  @Test
  public void testGetWidth() {
    assertEquals(10, oval1.getWidth(), 0.001);
    assertEquals(999, oval2.getWidth(), 0.001);
  }

  /**
   * Test the getHeight method.
   */
  @Test
  public void testGetHeight() {
    assertEquals(599, oval1.getHeight(), 0.001);
    assertEquals(150, oval2.getHeight(), 0.001);
  }

  /**
   * Test the toString method.
   */
  @Test
  public void testToString() {
    oval1.setName("Oval1");
    assertEquals("Name: Oval1\nType: oval\nCenter: (1, 150), Width: 10, "
            + "Height: 599, Color: (0,0,255)", oval1.toString());

    oval2.setName("Oval2");
    assertEquals("Name: Oval2\nType: oval\nCenter: (250, 599), Width: 999, "
            + "Height: 150, Color: (0,255,0)", oval2.toString());
  }

  // Test Exceptions

  /**
   * Tests for an illegal construction of an oval - negative width.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    Oval negativeWidth = new Oval(point1, color1, -125, 250);
  }

//  /**
//   * Tests for an illegal construction of an oval - zero width.
//   */
//  @Test(expected = IllegalArgumentException.class)
//  public void illegalSetup2() {
//    Oval zeroWidth = new Oval(point1, color1,
//            0, 250);
//  }

  /**
   * Tests for an illegal construction of an oval - width greater than page width.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup3() {
    Oval bigWidth = new Oval( point1, color1,1500, 250);
  }

  /**
   * Tests for an illegal construction of an oval - negative height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup4() {
    Oval negativeHeight = new Oval( point1, color1,125, -250);
  }

//  /**
//   * Tests for an illegal construction of an oval - zero height.
//   */
//  @Test(expected = IllegalArgumentException.class)
//  public void illegalSetup5() {
//    Oval zeroHeight = new Oval(point1, color1,100, 0);
//  }

  /**
   * Tests for an illegal construction of an oval - height greater than page height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup6() {
    Oval bigHeight = new Oval(point1, color1, 150, 2500);
  }

  /**
   * Tests for an illegal call of the moveTo method - move to existing location.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalMoveTo() {
    oval1.moveTo(point1);
  }

  /**
   * Tests for an illegal call of the changeColor method - change to existing color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalChangeColor() {
    oval1.changeColor(color1);
  }

  /**
   * Tests for an illegal call of the resize method - change to existing size.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalResize1() {
    oval1.resize(oval1.getWidth(), oval1.getHeight());
  }

//  /**
//   * Tests for an illegal call of the resize method - change width to zero.
//   */
//  @Test(expected = IllegalArgumentException.class)
//  public void illegalResize2() {
//    oval1.resize(0, 100);
//  }
//
//  /**
//   * Tests for an illegal call of the resize method - change height to zero.
//   */
//  @Test(expected = IllegalArgumentException.class)
//  public void illegalResize3() {
//    oval1.resize(100, 0);
//  }

  /**
   * Tests for an illegal call of the resize method - change width to negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalResize4() {
    oval1.resize(-100, 100);
  }

  /**
   * Tests for an illegal call of the resize method - change height to negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalResize5() {
    oval1.resize(100, -100);
  }

  /**
   * Tests for an illegal call of the resize method - change width to larger than page width.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalResize6() {
    oval1.resize(2000, 100);
  }

  /**
   * Tests for an illegal call of the resize method - change height to larger than page height.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalResize7() {
    oval1.resize(100, 2000);
  }

  /**
   * Tests for an illegal call of the setName method - set name to null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetName1() {
    oval1.setName(null);
  }

  /**
   * Tests for an illegal call of the setName method - set name to empty String.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetName2() {
    oval1.setName("");
  }
}