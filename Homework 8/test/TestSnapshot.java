import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Snapshot;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This is a JUnit test class for the Snapshot class.
 */

public class TestSnapshot {

  private Snapshot snapshot1;
  private Snapshot snapshot2;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    this.snapshot1 = new Snapshot("Test snapshot 1");
    this.snapshot2 = new Snapshot("Test snapshot 2");
  }

  // Test Methods
  /**
   * Test the getDescription method
   */
  @Test
  public void testGetDescription() {
    assertEquals("Test snapshot 1", snapshot1.getDescription());
    assertEquals("Test snapshot 2", snapshot2.getDescription());
  }


  /**
   * Test the getSnapshotID and getTimestamp methods
   */
  @Test
  public void testGetTimestampAndGetSnapshotId() throws ParseException {
    // Test #1
    // Get snapshot using getSnapshotId() and convert it to a Date
    String snapshotId1 = snapshot1.getSnapshotId();
    Date date1a = new SimpleDateFormat("yyyy-MM-dd' T 'HH:mm").parse(snapshotId1);

    // Get timestamp using getTimestamp() and covert it to a Date
    String timestamp1 = snapshot1.getTimestamp();
    Date date1b = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(timestamp1);

    // Check that the Dates using getSnapshotId() and getTimestamp() methods are equal
    assertEquals(date1a, date1b);


    // Test #2
    // Get snapshot using getSnapshotId() and convert it to a Date
    String snapshotId2 = snapshot2.getSnapshotId();
    Date date2a = new SimpleDateFormat("yyyy-MM-dd' T 'HH:mm").parse(snapshotId2);

    // Get timestamp using getTimestamp() and covert it to a Date
    String timestamp2 = snapshot2.getTimestamp();
    Date date2b = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(timestamp2);

    // Check that the Dates using getSnapshotId() and getTimestamp() methods are equal
    assertEquals(date2a, date2b);
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("Snapshot ID: " + snapshot1.getSnapshotId() + "\n"
            + "Timestamp: " + snapshot1.getTimestamp() + "\n"
            + "Description: Test snapshot 1", snapshot1.toString());

    assertEquals("Snapshot ID: " + snapshot2.getSnapshotId() + "\n"
            + "Timestamp: " + snapshot2.getTimestamp() + "\n"
            + "Description: Test snapshot 2", snapshot2.toString());
  }

  // Test Exceptions
  /**
   * Tests for an illegal construction of a snapshot - null description.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    Snapshot nullDescription = new Snapshot(null);
  }

  /**
   * Tests for an illegal construction of a snapshot - empty description.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    Snapshot emptyDescription = new Snapshot("");
  }
}
