package hw2;

/**
 * Katie Davenport
 * CS 5004 - Homework 2
 *
 * <p>This class represents a locker that has maximum width, height, and depth dimensions.
 * This class can add a mail item, pick up a mail item, and get a mail item.
 */
public class Locker {
  private int maxWidth;
  private int maxHeight;
  private int maxDepth;
  private MailItem mailItem;
  public static final int minNum = 1; // Constant variable for minimum value of max dimensions

  /**
   * Constructs a locker with the given max width, max height, and max depth. An illegal argument
   * exception is thrown if any of these dimensions are less than 1. A mail item in the locker
   * is set to null as a default.
   *
   * @param maxWidth  the max width
   * @param maxHeight the max height
   * @param maxDepth  the max depth
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) throws
          IllegalArgumentException {
    if (maxWidth < minNum || maxHeight < minNum || maxDepth < minNum) {
      throw new IllegalArgumentException("Dimensions must be equal to or greater than 1."); }

    this.maxWidth = maxWidth;
    this.maxHeight = maxHeight;
    this.maxDepth = maxDepth;
    this.mailItem = null;
  }

  /**
   * Stores the mail item in the locker unless the locker already contains a mail item or if any
   * of the dimensions of the mail item exceeds those of the locker.
   *
   * @param mailItem the mail item
   */
  public void addMail(MailItem mailItem) {
    double width = mailItem.getWidth();
    double height = mailItem.getHeight();
    double depth = mailItem.getDepth();
    if (this.mailItem == null && width <= maxWidth && height <= maxHeight && depth <= maxDepth) {
      this.mailItem = mailItem;
    }
  }

  /**
   * Pickup mail item. Remove and return the mail item from the locker if there is an item in
   * the mail locker and if the recipient matches the recipient of the mail item. If the recipients
   * do not match or if there is no mail in the locker then return null.
   *
   * @return the mail item
   */
  public MailItem pickupMail(Recipient recipient) {
    if (this.mailItem != null) {
      Recipient recipient2 = this.mailItem.getRecipient();
      if (recipient.equals(recipient2)) {
        MailItem mailItem = this.mailItem;
        this.mailItem = null;
        return mailItem;
      }
    }
    return null;
  }

  /**
   * Gets the mail item. This is a helper method used for testing the addMail method.
   *
   * @return the recipient
   */
  public MailItem getMailItem() {
    if (mailItem != null)
      return this.mailItem;
    return null;
  }
}