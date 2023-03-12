import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import model.AlbumImpl;
import model.Color;
import model.Oval;
import model.Point;
import model.Rectangle;


/**
 * Katie Davenport
 * CS 5004 - Homework 8
 *
 * <p>This is a JUnit test class for the AlbumImpl class.
 */
public class TestAlbumImpl {

  private AlbumImpl album1;
  private AlbumImpl album2;
  private AlbumImpl album3;
  private Rectangle shape1;
  private Rectangle shape2;
  private Rectangle shape3;
  private Oval shape4;
  private Oval shape5;


  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    shape1 = new Rectangle(new Point(50, 200), new Color(20, 30, 200), 25, 200);
    shape2 = new Rectangle(new Point(100, 400), new Color(0, 80, 15), 50, 100);
    shape3 = new Rectangle(new Point(200, 75), new Color(150, 50, 0), 75, 20);
    shape4 = new Oval(new Point(600, 300), new Color(0, 50, 200), 100, 50);
    shape5 = new Oval(new Point(444, 555), new Color(0, 220, 10), 200, 65);

    this.album1 = new AlbumImpl();
    album1.addShape("R1", shape1);
    album1.addShape("R2", shape2);

    this.album2 = new AlbumImpl();

    this.album3 = new AlbumImpl();
    album3.addShape("Oval1", shape4);
    album3.addShape("Oval2", shape5);
    album3.addShape("R3", shape3);

  }

  /**
   * Test the addShape method.
   */
  @Test
  public void testAddShape() {
    // Add two shape
    album1.addShape("R3", shape3);
    assertEquals("[Name: R1\nType: rectangle\nMin corner: (50, 200), "
                    + "Width: 25.0, Height: 200.0, Color: (20, 30, 200), "
                    + "Name: R2\nType: rectangle\nMin corner: (100, 400), "
                    + "Width: 50.0, Height: 100.0, Color: (0, 80, 15), "
                    + "Name: R3\nType: rectangle\nMin corner: (200, 75), "
                    + "Width: 75.0, Height: 20.0, Color: (150, 50, 0)]"
            , album1.getShapes().values().toString());

    // Add two shapes
    album2.addShape("Oval1", shape4);
    album2.addShape("Oval2", shape5);
    assertEquals("[Name: Oval1\n"
                    + "Type: oval\n"
                    + "Center: (600, 300), Width: 100.0, Height: 50.0, Color: (0, 50, 200), "
                    + "Name: Oval2\n"
                    + "Type: oval\n"
                    + "Center: (444, 555), Width: 200.0, Height: 65.0, Color: (0, 220, 10)]",
            album2.getShapes().values().toString());
  }

  /**
   * Test the removeShape method.
   */
  @Test
  public void testRemoveShape() {
    // Remove 1 shape
    album1.removeShape("R2");
    assertEquals("[Name: R1\n"
                    + "Type: rectangle\n"
                    + "Min corner: (50, 200), Width: 25.0, Height: 200.0, Color: (20, 30, 200)]",
            album1.getShapes().values().toString());

    // Remove an additional shape - none left
    album1.removeShape("R1");
    assertEquals("[]", album1.getShapes().values().toString());

    // Remove two shapes - one left
    album3.removeShape("Oval2");
    album3.removeShape("Oval1");
    assertEquals("[Name: R3\n"
                    + "Type: rectangle\n"
                    + "Min corner: (200, 75), Width: 75.0, Height: 20.0, Color: (150, 50, 0)]",
            album3.getShapes().values().toString());
  }

  /**
   * Test get shapes.
   */
  @Test
  public void testGetShapes() {
    assertEquals("[Name: R1\n"
                    + "Type: rectangle\n"
                    + "Min corner: (50, 200), Width: 25.0, Height: 200.0, Color: (20, 30, 200), "
                    + "Name: R2\n"
                    + "Type: rectangle\n"
                    + "Min corner: (100, 400), Width: 50.0, Height: 100.0, Color: (0, 80, 15)]",
            album1.getShapes().values().toString());

    assertEquals("[]", album2.getShapes().values().toString());

    assertEquals("[Name: Oval1\n"
                    + "Type: oval\n"
                    + "Center: (600, 300), Width: 100.0, Height: 50.0, Color: (0, 50, 200), "
                    + "Name: Oval2\n"
                    + "Type: oval\n"
                    + "Center: (444, 555), Width: 200.0, Height: 65.0, Color: (0, 220, 10), "
                    + "Name: R3\n"
                    + "Type: rectangle\n"
                    + "Min corner: (200, 75), Width: 75.0, Height: 20.0, Color: (150, 50, 0)]",
            album3.getShapes().values().toString());
  }

  /**
   * Test the takeSnapshot and toString methods.
   */
  @Test
  public void testAddShapshotAndToString1() {
    // Take a snapshot
    album1.takeSnapshot("snapshot1");

    // Make some changes to the album
    album1.removeShape("R2");

    // Take another snapshot
    album1.takeSnapshot("Snapshot 2");

    // Do a manual test of the snapshot by calling the toString. This will not pass over time
    // since the timestamp always changes.
    /*
    assertEquals("Printing Snapshots\n" +
            "\n" +
            "Snapshot ID: 2022-11-28 T 22:25\n" +
            "Timestamp: 28-11-2022 22:25\n" +
            "Description: snapshot1\n" +
            "Shape Information:\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (50, 200), Width: 25.0, Height: 200.0, Color: (20, 30, 200)\n" +
            "Name: R2\n" +
            "Type: rectangle\n" +
            "Min corner: (100, 400), Width: 50.0, Height: 100.0, Color: (0, 80, 15)\n" +
            "\n" +
            "Snapshot ID: 2022-11-28 T 22:25\n" +
            "Timestamp: 28-11-2022 22:25\n" +
            "Description: Snapshot 2\n" +
            "Shape Information:\n" +
            "Name: R1\n" +
            "Type: rectangle\n" +
            "Min corner: (50, 200), Width: 25.0, Height: 200.0, Color: (20, 30, 200)",
            album1.toString());
     */
  }

  /**
   * Test the takeSnapshot and toString methods.
   */
  @Test
  public void testAddShapshotAndToString2() {
    // Take a snapshot
    album3.takeSnapshot("snapshot1");

    // Make some changes to the album and take another snapshot
    album3.removeShape("R3");
    album3.addShape("R2", shape2);
    album3.takeSnapshot("snapshot2");

    // Make some more changes to the album and take another snapshot
    shape2.changeColor(new Color(50,100, 150));
    shape2.moveTo(new Point(850, 300));
    album3.takeSnapshot("Snapshot 3");

    // Do a manual test of the snapshot by calling the toString. This will not pass over time
    // since the timestamp always changes.
    /*
    assertEquals("Printing Snapshots\n" +
                    "\n" +
                    "Snapshot ID: 2022-11-28 T 22:37\n" +
                    "Timestamp: 28-11-2022 22:37\n" +
                    "Description: snapshot1\n" +
                    "Shape Information:\n" +
                    "Name: Oval1\n" +
                    "Type: oval\n" +
                    "Center: (600, 300), Width: 100.0, Height: 50.0, Color: (0, 50, 200)\n" +
                    "Name: Oval2\n" +
                    "Type: oval\n" +
                    "Center: (444, 555), Width: 200.0, Height: 65.0, Color: (0, 220, 10)\n" +
                    "Name: R3\n" +
                    "Type: rectangle\n" +
                    "Min corner: (200, 75), Width: 75.0, Height: 20.0, Color: (150, 50, 0)\n" +
                    "\n" +
                    "Snapshot ID: 2022-11-28 T 22:37\n" +
                    "Timestamp: 28-11-2022 22:37\n" +
                    "Description: snapshot2\n" +
                    "Shape Information:\n" +
                    "Name: Oval1\n" +
                    "Type: oval\n" +
                    "Center: (600, 300), Width: 100.0, Height: 50.0, Color: (0, 50, 200)\n" +
                    "Name: Oval2\n" +
                    "Type: oval\n" +
                    "Center: (444, 555), Width: 200.0, Height: 65.0, Color: (0, 220, 10)\n" +
                    "Name: R2\n" +
                    "Type: rectangle\n" +
                    "Min corner: (100, 400), Width: 50.0, Height: 100.0, Color: (0, 80, 15)\n" +
                    "\n" +
                    "Snapshot ID: 2022-11-28 T 22:37\n" +
                    "Timestamp: 28-11-2022 22:37\n" +
                    "Description: Snapshot 3\n" +
                    "Shape Information:\n" +
                    "Name: Oval1\n" +
                    "Type: oval\n" +
                    "Center: (600, 300), Width: 100.0, Height: 50.0, Color: (0, 50, 200)\n" +
                    "Name: Oval2\n" +
                    "Type: oval\n" +
                    "Center: (444, 555), Width: 200.0, Height: 65.0, Color: (0, 220, 10)\n" +
                    "Name: R2\n" +
                    "Type: rectangle\n" +
                    "Min corner: (850, 300), Width: 50.0, Height: 100.0, Color: (50, 100, 150)",
            album3.toString());
       */
  }

  /**
   * Test the takeSnapshot and toString methods - no snapshots yet taken.
   */
  @Test
  public void testAddShapshotAndToString3() {
    assertEquals("No snapshots have been taken.", album2.toString());
  }

  /**
   * Test the takeSnapshot and toString methods - take a snapshot with no shapes.
   */
  @Test
  public void testAddShapshotAndToString4() {
    album2.takeSnapshot("Empty snapshot");
    // Do a manual test of the snapshot by calling the toString. This will not pass over time
    // since the timestamp always changes.
    /*
    assertEquals("Printing Snapshots\n\n"
            + "Snapshot ID: 2022-11-29 T 20:07\n"
            + "Timestamp: 29-11-2022 20:07\n"
            + "Description: Empty snapshot\n"
            + "Shape Information: There are no shapes.", album2.toString());

     */
  }

  // Test Exceptions

  /**
   * Tests for an illegal call of the addShape method - add null shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAddShape1() {
    album1.addShape("yellowOval", null);
  }

  /**
   * Tests for an illegal call of the addShape method - add existing shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAddShape2() {
    album1.addShape("Rectangle1", shape1);
  }

  /**
   * Tests for an illegal call of the addShape method - add existing shape name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAddShape3() {
    album1.addShape("R1", shape2);
  }

  /**
   * Tests for an illegal call of the removeShape method - shape name does not exist.
   */
  @Test(expected =  NoSuchElementException.class)
  public void illegalRemoveShape() {
    album1.removeShape("banana");
  }
}
