import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS5004 - Homework 1
 *
 * <p>This is a JUnit test class for the Paycheck class.
 */
public class PaycheckTest {
  private Paycheck paycheckOne;
  private Paycheck paycheckTwo;
  private Paycheck paycheckThree;
  private Paycheck paycheckFour;
  private Paycheck paycheckFive;
  private Paycheck paycheckSix;
  private Paycheck paycheckSeven;
  private Paycheck paycheckEight;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    this.paycheckOne = new Paycheck(15, 20); // less than or equal to 40 hours worked
    this.paycheckTwo = new Paycheck(20, 50); // more than 40 hours worked
    this.paycheckThree = new Paycheck(20, 10); // total pay is less than $400
    this.paycheckFour = new Paycheck(20, 20 ); // total pay is equal to $400
    this.paycheckFive = new Paycheck(20, 30); // total pay greater than $400
    this.paycheckSix = new Paycheck(0.001, 1); // total pay less than  $0.01
    this.paycheckSeven = new Paycheck(0, 0); // zero pay
    this.paycheckEight = new Paycheck(1, 10.005); // total pay includes fractional cent
  }

  /**
   * Test the getTotalPay method.
   */
  @Test
  public void testGetTotalPay() {
    assertEquals(300, this.paycheckOne.getTotalPay(),0.001);// less than or equal to 40 hrs worked
    assertEquals(1100, this.paycheckTwo.getTotalPay(),0.001); // more than 40 hours worked
    assertEquals(0.001, this.paycheckSix.getTotalPay(),0.001); // less than one cent earned
    assertEquals(10.005, this.paycheckEight.getTotalPay(),0.001); // fractional cent earned
  }

  /**
   * Test the getPayAfterTaxes method.
   */
  @Test
  public void testGetPayAfterTaxes() {
    assertEquals(180, this.paycheckThree.getPayAfterTaxes(), 0.001);// pay less than $400
    assertEquals(340, this.paycheckFour.getPayAfterTaxes(), 0.001); // pay equal to $400
    assertEquals(510, this.paycheckFive.getPayAfterTaxes(), 0.001); // pay greater than $400
    assertEquals(9.0045, this.paycheckEight.getPayAfterTaxes(),0.001); // fractional cent earned
    assertEquals(0.009, this.paycheckSix.getPayAfterTaxes(),0.001); //less than one cent earned
  }

  /**
   * Test the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Payment after taxes: $ 180.00", this.paycheckThree.toString());
    assertEquals("Payment after taxes: $ 0.00", this.paycheckSeven.toString()); // zero pay
    assertEquals("Payment after taxes: $ 9.00", this.paycheckEight.toString()); // fractional pay
  }
}