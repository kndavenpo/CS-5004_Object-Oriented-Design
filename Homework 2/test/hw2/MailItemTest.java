package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
/**
 * Katie Davenport
 * CS5004 - Homework 2
 *
 * <p>This is a JUnit test class for the MailItem class.
 */

public class MailItemTest {

  private Recipient recipientOne;
  private MailItem mailItemOne;
  private Recipient recipientTwo;
  private MailItem mailItemTwo;

  /**
   * Set up tests. We create a recipient object since a recipient is an input parameter for the
   * mail item class.
   */
  @Before
  public void setUp() {
    this.recipientOne = new Recipient("Katie", "Davenport",
            "davenport.k@northeastern.edu");
    this.mailItemOne = new MailItem(1, 1, 1, this.recipientOne);

    this.recipientTwo = new Recipient("Jane", "Smith",
            "jane.smith@google.com");
    this.mailItemTwo = new MailItem(25, 19, 44, this.recipientTwo);
  }

  /**
   * Tests an illegal setup of the mail item. An illegal argument exception is thrown if any of the
   * dimension parameters are less than 1 of if a recipient is not provided.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetupDimensions1() {
    MailItem mailItem1;
    mailItem1 = new MailItem(0, 1, 2, recipientOne);
  }

  /**
   * Tests an illegal setup of the mail item. An illegal argument exception is thrown if any of the
   * dimension parameters are less than 1 of if a recipient is not provided.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetupDimensions2() {
    MailItem mailItem1;
    mailItem1 = new MailItem(1, -2, 2, recipientOne);
  }

  /**
   * Tests an illegal setup of the mail item. An illegal argument exception is thrown if any of the
   * dimension parameters are less than 1 of if a recipient is not provided.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetupDimensions3() {
    MailItem mailItem1;
    mailItem1 = new MailItem(1, 2, -70000, recipientOne);
  }

  /**
   * Tests an illegal setup of the mail item. An illegal argument exception is thrown if any of the
   * dimension parameters are less than 1 of if a recipient is not provided.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetupNull() {
    MailItem mailItemSix;
    mailItemSix = new MailItem(1, 2, 7, null);
  }


  /**
   * Test the get recipient method using the string representation of the mail item's recipient.
   */
  @Test
  public void testGetRecipient() {
    recipientOne = mailItemOne.getRecipient();
    assertEquals("Katie Davenport Email:davenport.k@northeastern.edu", recipientOne.toString());

    recipientTwo = mailItemTwo.getRecipient();
    assertEquals("Jane Smith Email:jane.smith@google.com", recipientTwo.toString());
  }

  /**
   * Test the get width method.
   */
  @Test
  public void testGetWidth() {
    assertEquals(1, mailItemOne.getWidth(), 0.001);
    assertEquals(25, mailItemTwo.getWidth(), 0.001);
  }

  /**
   * Test the get height method.
   */
  @Test
  public void testGetHeight() {
    assertEquals(1, mailItemOne.getHeight(), 0.001);
    assertEquals(19, mailItemTwo.getHeight(), 0.001);
  }

  /**
   * Test the get depth method.
   */
  @Test
  public void testGetDepth() {
    assertEquals(1, mailItemOne.getDepth(), 0.001);
    assertEquals(44, mailItemTwo.getDepth(), 0.001);
  }
}