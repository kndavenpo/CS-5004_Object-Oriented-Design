package hw2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
/**
 * Katie Davenport
 * CS5004 - Homework 2
 *
 * <p>This is a JUnit test class for the Locker class.
 */


public class LockerTest {
  private Recipient recipientOne;
  private Recipient recipientTwo;
  private Recipient recipientThree;
  private MailItem mailItemOne;
  private MailItem mailItemTwo;
  private MailItem mailItemThree;
  private Locker lockerOne;
  private Locker lockerTwo;
  private Locker lockerThree;

  /**
   * Set up tests. We create a recipient object and a mail item object for testing.
   */
  @Before
  public void setUp() {
    this.lockerOne = new Locker(10, 10, 10);
    this.lockerTwo = new Locker( 8, 12, 24);
    this.lockerThree = new Locker(5,5,5);

    this.recipientOne = new Recipient("Katie", "Davenport","davenport.k@northeastern.edu");
    this.recipientTwo = new Recipient("Steve", "Dav", "sdav@gmail.com");
    this.recipientThree = new Recipient("Jane", "Smith", "js@yahoo.com");

    this.mailItemOne = new MailItem(5, 5, 5, this.recipientOne);
    this.mailItemTwo = new MailItem(4, 10, 2, this.recipientTwo);
    this.mailItemThree = new MailItem(10, 5, 5, this.recipientThree);
  }

  /**
   * Tests an illegal setup of the locker. An illegal argument exception is thrown if any of the
   * maximum dimension parameters are less than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    Locker badLocker1;
    badLocker1 = new Locker(0, 4, 12);
  }

  /**
   * Tests an illegal setup of the locker. An illegal argument exception is thrown if any of the
   * maximum dimension parameters are less than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    Locker badLocker2;
    badLocker2 = new Locker(12, -12, 24);
  }

  /**
   * Tests an illegal setup of the locker. An illegal argument exception is thrown if any of the
   * maximum dimension parameters are less than 1.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup3() {
    Locker badLocker3;
    badLocker3 = new Locker(18, 24, -65000000);
  }

  /**
   * Tests the getMailItem method by calling the toString method for the mail item's recipient.
   */
  @Test
  public void testGetMailItem() {
    lockerOne.addMail(mailItemOne);
    MailItem mailItem = lockerOne.getMailItem();
    Recipient recipient = mailItem.getRecipient();
    assertEquals("Katie Davenport Email:davenport.k@northeastern.edu", recipient.toString());
  }

  /**
   * Tests the getMethod when one no mail has been added. This should result in a null pointer
   * exception since the mail item's default value is null.
   */
  @Test(expected = NullPointerException.class)
  public void testGetNoMailItem() {
    MailItem mailItemNoMail = lockerOne.getMailItem();
    Recipient recipient = mailItemNoMail.getRecipient();
  }

  /**
   * Test addMail method by adding a mail item and calling the toString method for the mail item's
   * recipient. Note that this is an identical test to getMailItem.
   */
  @Test
  public void testAddMail() {
    // Test basic functionality
    lockerOne.addMail(mailItemOne);
    MailItem mailItem = lockerOne.getMailItem();
    Recipient recipient = mailItem.getRecipient();
    assertEquals("Katie Davenport Email:davenport.k@northeastern.edu", recipient.toString());

    // Negative test - locker already contains mail
    lockerTwo.addMail(mailItemOne);
    lockerTwo.addMail(mailItemTwo);
    MailItem mailItemTwo = lockerTwo.getMailItem();
    Recipient recipientTwo = mailItemTwo.getRecipient();
    assertNotEquals("Steve Dav Email:sdav@gmail.com", recipientTwo.toString());
  }

  /**
   * Tests the addMail when one of the dimensions of the mail item exceeds the max dimension of
   * the locker. Test by adding a mail item and calling the toString method for the mail item's
   * recipient.
   */
  @Test(expected = NullPointerException.class)
  public void testAddTooBigMail() {
    lockerThree.addMail(mailItemThree);
    MailItem mailItemThree = lockerThree.getMailItem();
    Recipient recipientThree = mailItemThree.getRecipient();
  }

  /**
   * Test pickupMail method by calling the toString method for the mail item's recipient.
   */
  @Test
  public void testPickupMail() {
    lockerOne.addMail(mailItemOne);
    MailItem mailItem = lockerOne.pickupMail(recipientOne);
    Recipient recipient = mailItem.getRecipient();
    assertEquals("Katie Davenport Email:davenport.k@northeastern.edu", recipient.toString());
  }

  /**
   * Test the pickupMail method when there is no mail in the locker.
   */
  @Test(expected = NullPointerException.class)
  public void testPickupNoMail() {
    MailItem mailItemThree = lockerThree.getMailItem();
    Recipient recipientThree = mailItemThree.getRecipient();
  }

  /**
   * Test the pickupMail method when the recipients do not match.
   */
  @Test(expected = NullPointerException.class)
  public void testPickupWrongMail() {
    lockerOne.addMail(mailItemOne);
    MailItem mailItem = lockerOne.pickupMail(recipientTwo);
    Recipient recipient = mailItem.getRecipient();
  }
}
