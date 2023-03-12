package hw2;

/**
 * Katie Davenport
 * CS 5004 - Homework 2
 *
 * <p>This class represents a recipient. A recipient has a first name, last name, and email.
 * This class can return a string representation of the recipient and determine if two recipients
 * are equal to one another.
 */
public class Recipient {
  private String firstName;
  private String lastName;
  private String email;

  /**
   * Constructs a recipient with the given first name, last name, and email. An illegal argument
   * exception is thrown if any of the inputs are null or empty strings.
   *
   * @param firstName the first name
   * @param lastName  the last name
   * @param email     the email
   */
  public Recipient(String firstName, String lastName, String email)
          throws IllegalArgumentException {
    if (firstName == null || firstName.isEmpty() || lastName == null || lastName.isEmpty()
            || email == null || email.isEmpty()) {
      throw new IllegalArgumentException("Inputs cannot be null or empty.");
    }
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  /**
   * Return a string representation of this recipient with first name, last name, and email.
   *
   * @return a formatted string.
   */
  public String toString() {
    return this.firstName + " " + this.lastName + " Email:" + this.email;
  }

  /**
   * Determines if two recipients are equal. This is a helper method used in the Locker class.
   *
   * @param other the other recipient
   * @return boolean
   */
  r boolean equals(Object other) {
    if (this == other) return true;
    if (!(other instanceof Recipient)) return false;
    Recipient recipient = (Recipient) other;
    return firstName == recipient.firstName && lastName == recipient.lastName
            && email == recipient.email;
  }
}
