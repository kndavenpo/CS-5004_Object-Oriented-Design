package hw2;

/**
 * Katie Davenport
 * CS 5004 - Homework 2
 *
 * <p>This is an enumeration for room type that stores the maximum number of occupants for each
 * room type and returns that value.
 */
public enum RoomType {
  /**
   * Single room type.
   */
  SINGLE(1),
  /**
   * Double room type.
   */
  DOUBLE(2),
  /**
   * Family room type.
   */
  FAMILY(4);
  /**
   * The value that is the maximum number of guests.
   */
  private int value;

  /**
   * Constructs a roomType object with the maximum number of guests.
   *
   * @param value - the maximum number of guests
   */
  RoomType(int value) {
    this.value = value;
  }

  /**
   * Get the maximum number of guests for the room type.
   *
   * @return the maximum number of guests
   */
  public int getValue() {
    return this.value;
  }
}

