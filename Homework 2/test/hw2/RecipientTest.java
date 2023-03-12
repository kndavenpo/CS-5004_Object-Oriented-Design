package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
/**
 * Katie Davenport
 * CS5004 - Homework 2
 *
 * <p>This is a JUnit test class for the Recipient class.
 */

public class RecipientTest {
  private Recipient recipientOne;
  private Recipient recipientTwo;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    recipientOne = new Recipient("Katie", "Davenport", "davenport.k@northeastern.edu");
    recipientTwo = new Recipient("Jane", "Smith", "j.smith@google.com");
  }

  /**
   * Tests an illegal setup of the recipient. An illegal argument exception is thrown if any of the
   * parameters are null or empty strings.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetupEmpty1() {
    Recipient recipient1;
    recipient1 = new Recipient("", "Nash", "k_nash.google.com");
  }

  /**
   * Tests an illegal setup of the recipient. An illegal argument exception is thrown if any of the
   * parameters are null or empty strings.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetupEmpty2() {
    Recipient recipient2;
    recipient2 = new Recipient("Katie", "", "k_nash.google.com");

    Recipient recipient3;
    recipient3 = new Recipient("Katie", "Nash", "  ");
  }

  /**
   * Tests an illegal setup of the recipient. An illegal argument exception is thrown if any of the
   * parameters are null or empty strings.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetupNull1() {
    Recipient recipient1;
    recipient1 = new Recipient(null, "Nash", "k_nash@yahoo.com");
  }

  /**
   * Tests an illegal setup of the recipient. An illegal argument exception is thrown if any of the
   * parameters are null or empty strings.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetupNull2() {
    Recipient recipient2;
    recipient2 = new Recipient("Katie", null, "k_nash@yahoo.com");
  }

  /**
   * Tests an illegal setup of the recipient. An illegal argument exception is thrown if any of the
   * parameters are null or empty strings.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetupNull3() {
    Recipient recipient3;
    recipient3 = new Recipient("Katie", "Nash", null);
  }

  /**
   * Test the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Katie Davenport Email:davenport.k@northeastern.edu",
            this.recipientOne.toString());
    assertEquals("Jane Smith Email:j.smith@google.com", this.recipientTwo.toString());
  }

  /**
   * Test the equals method.
   */
  @Test
  public void testEquals() {
    Recipient sameRecipient;
    sameRecipient = new Recipient("Katie", "Davenport",
            "davenport.k@northeastern.edu");
    assertEquals(true, recipientOne.equals(sameRecipient));
  }
}
