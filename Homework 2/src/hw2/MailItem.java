package hw2;

/**
 * Katie Davenport
 * CS 5004 - Homework 2
 *
 * <p>This class represents a mail item with a given width, height, depth and recipient. This
 * class can return any of the input parameters.
 */
public class MailItem {
  private int width;
  private int height;
  private int depth;
  private Recipient recipient;
  public static final int minNum = 1; // Constant variable for minimum dimension

  /**
   * Constructs a mail item with the given width, height, and depth. An Illegal Argument Exception
   * is thrown if any of the dimensions are less than 1 or if the recipient is null.
   *
   * @param width     the width
   * @param height    the height
   * @param depth     the depth
   * @param recipient the recipient
   * @throws IllegalArgumentException the illegal argument exception
   */
  public MailItem(int width, int height, int depth, Recipient recipient) throws
          IllegalArgumentException {
    if (width < minNum || height < minNum || depth < minNum || recipient == null) {
      throw new IllegalArgumentException("Dimensions must be greater than 1 and recipient must "
              + "not be null."); }

    this.width = width;
    this.height = height;
    this.depth = depth;
    this.recipient = recipient;
  }

  /**
   * Gets this mail item's recipient.
   *
   * @return the recipient
   */
  public Recipient getRecipient() {
    return this.recipient;
  }

  /**
   * Gets this mail item's width. This is a helper method used in the Locker class.
   *
   * @return the width
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Gets this mail item's height. This is a helper method used in the Locker class.
   *
   * @return the height
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Gets this mail item's depth. This is a helper method used in the Locker class.
   *
   * @return the depth
   */
  public int getDepth() {
    return this.depth;
  }
}
