package hw2;

/**
 * Katie Davenport
 * CS5004 - Homework 2
 *
 * <p>This class represents a hotel Room. The room has a type, price, and number of guests.
 * This class can check if this room is available, book this room, and get the number of
 * guests that currently occupy this room.
 */
public class Room {
  private RoomType roomType;
  private double roomPrice;
  private int numberOfGuests;

  /**
   * Constructs a room object with the given room type and price. The price must be equal to or
   * greater than zero. The number of guests is initialized to 0.
   *
   * @param roomType  the room type
   * @param roomPrice the room price
   */
  public Room(RoomType roomType, double roomPrice) throws IllegalArgumentException {
    this.roomType = roomType;
    this.roomPrice = roomPrice;
    this.numberOfGuests = 0;

    if (roomPrice < 0) {
      throw new IllegalArgumentException( "The room price cannot be negative.");
    }
  }

  /**
   * Checks if this room is available. A room is available if the current number of guests is 0
   * and unavailable if the number of guests is greater than 0.
   *
   * @return the boolean representing if the room is available
   */
  public boolean isAvailable() {
    if (numberOfGuests == 0) {
      return true;
    } else return false;
  }

  /**
   * This method books this room by setting the number of guests to the parameter value only if
   * the room is available and the number of guests is greater than 0 but less than or equal to
   * the maximum occupancy for the room type.
   *
   * @param numberOfGuests the num guests to be booked
   */
  public void bookRoom(int numberOfGuests) {
    if (this.isAvailable() == true
            && numberOfGuests > 0
            && numberOfGuests <= roomType.getValue()) {
      this.numberOfGuests = numberOfGuests;
    }
  }

  /**
   * Gets the number of guests currently assigned to this room.
   *
   * @return the number of guests currently assigned
   */
  public int getNumberOfGuests() {
    return this.numberOfGuests;
  }
}