package hw2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
/**
 * Katie Davenport
 * CS5004 - Homework 2
 *
 * <p>This is a JUnit test class for the Room class.
 */

public class RoomTest {
  private Room roomOne;
  private Room roomTwo;
  private Room roomThree;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    roomOne = new Room(RoomType.SINGLE, 80.05);
    roomTwo = new Room(RoomType.DOUBLE, 99.99);
    roomThree = new Room(RoomType.FAMILY, 125.75);
  }

  /**
   * Tests an illegal setup of the room. An illegal argument exception is thrown if the room price
   * is less than zero.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    Room roomNegativePrice;
    roomNegativePrice = new Room(RoomType.SINGLE, -20.99);
  }

  /**
   * Tests an illegal setup of the room with a large negative number. An illegal argument
   * exception is thrown if the room price is less than zero.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    Room roomBigNegativePrice;
    roomBigNegativePrice = new Room(RoomType.DOUBLE, -7777775.25);
  }

  /**
   * Test the isAvailable method. A room is available if the current number of guests is 0.
   */
  @Test
  public void testIsAvailable() {
    // Test all room types before the room is booked.
    assertEquals(true, roomOne.isAvailable());
    assertEquals(true, roomTwo.isAvailable());
    assertEquals(true, roomThree.isAvailable());

    // Test all room types after the room is booked.
    roomOne.bookRoom(1);
    assertEquals(false, roomOne.isAvailable());
    roomTwo.bookRoom(2);
    assertEquals(false, roomOne.isAvailable());
    roomThree.bookRoom(4);
    assertEquals(false, roomOne.isAvailable());
  }

  /**
   * Test the bookRoom method by booking the room and returning the number of guests. In order
   * to book the room it must be available and the number of guests must be between 0 and the
   * maximum number of guests for the room type.
   */
  @Test
  public void testBookRoom() {
    // Test when room is available
    roomOne.bookRoom(1);
    assertEquals(1, roomOne.getNumberOfGuests());

    // Negative test - the room has already been booked.
    roomOne.bookRoom(1);
    roomOne.bookRoom(3);
    assertNotEquals(3, roomOne.getNumberOfGuests());

    // Negative test - the number of guests is less than 1 or greater than the allowed occupancy.
    roomOne.bookRoom(0); // Test zero
    assertNotEquals(0, roomOne.getNumberOfGuests());

    roomTwo.bookRoom(4); // Test greater than allowed number of guests.
    assertNotEquals(4, roomOne.getNumberOfGuests());
  }

  /**
   * Test the getNumberOfGuests method.
   */
  @Test
  public void testGetNumberOfGuests() {
    // Test before booking
    assertEquals(0, roomOne.getNumberOfGuests());
    assertEquals(0, roomTwo.getNumberOfGuests());
    assertEquals(0, roomThree.getNumberOfGuests());

    // Test after a valid booking
    roomOne.bookRoom(1);
    assertEquals(1, roomOne.getNumberOfGuests());
    roomTwo.bookRoom(2);
    assertEquals(2, roomTwo.getNumberOfGuests());
    roomThree.bookRoom(3);
    assertEquals(3, roomThree.getNumberOfGuests());
  }
}