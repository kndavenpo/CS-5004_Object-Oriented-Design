import static org.junit.Assert.assertEquals;

import employee.SalariedPaycheck;
import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS 5004 - Homework 4
 *
 * <p>This is a JUnit test class for the SalariedPaycheck class.
 */
public class TestSalariedPaycheck {
  private SalariedPaycheck paycheck1;
  private SalariedPaycheck paycheck2;
  private SalariedPaycheck paycheck3;
  private SalariedPaycheck paycheck4;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    // High tax rate, pay every other week
    this.paycheck1 = new SalariedPaycheck(50625.67, 2 );
    // High tax rate, pay every 12 weeks
    this.paycheck2 = new SalariedPaycheck(250917.17, 12 );
    // Low tax rate, pay weekly
    this.paycheck3 = new SalariedPaycheck(18017.17, 1 );
    // Low tax rate, pay twice a week day (earns less than a penny after taxes)
    this.paycheck4 = new SalariedPaycheck(0.05, 1 );
  }

  /**
   * Test get pay rate.
   */
  @Test
  public void testGetPayRate() {
    assertEquals(50625.67, paycheck1.getPayRate(), 0.001);
    assertEquals(250917.17, paycheck2.getPayRate(), 0.001);
    assertEquals(18017.17, paycheck3.getPayRate(), 0.001);
    assertEquals(0.05, paycheck4.getPayRate(), 0.001);
  }

  /**
   * Test total pay.
   */
  @Test
  public void testGetTotalPay() {
    // Use delta of 0.005 since we are rounding to the nearest penny.
    assertEquals(1947.14, paycheck1.getTotalPay(), 0.005);
    assertEquals(57903.96, paycheck2.getTotalPay(), 0.005);
    assertEquals(346.48, paycheck3.getTotalPay(), 0.005);

    // Use delta of 0.001. We don't round up to $0.01 until calculating pay after taxes.
    assertEquals(0.001, paycheck4.getTotalPay(), 0.001);
  }

  /**
   * Test get pay after taxes.
   */
  @Test
  public void testGetPayAfterTaxes() {
    // Use delta of 0.005 since we are rounding to the nearest penny.
    assertEquals(1655.07, paycheck1.getPayAfterTaxes(), 0.005);
    assertEquals(49218.37, paycheck2.getPayAfterTaxes(), 0.005);
    assertEquals(311.84, paycheck3.getPayAfterTaxes(), 0.005);

    // Use delta of 0.001 since we pay exactly $0.01 when pay after taxes is between
    // $0.00 and $0.01.
    assertEquals(0.01, paycheck4.getPayAfterTaxes(), 0.001);
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("Payment after taxes: $ 1655.07", paycheck1.toString());
    assertEquals("Payment after taxes: $ 49218.37", paycheck2.toString());
    assertEquals("Payment after taxes: $ 311.84", paycheck3.toString());
    assertEquals("Payment after taxes: $ 0.01", paycheck4.toString());
  }

  /**
   * Tests for an illegal construction of a paycheck.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    SalariedPaycheck negativeRate2;
    negativeRate2 = new SalariedPaycheck(-10.756, 2);
  }

  /**
   * Tests for an illegal construction of a paycheck.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    SalariedPaycheck negativeRate2;
    negativeRate2 = new SalariedPaycheck(-0.756, 2);
  }

  /**
   * Tests for an illegal construction of a paycheck.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup3() {
    SalariedPaycheck negativePayInterval;
    negativePayInterval = new SalariedPaycheck(58888.62, -2);
  }

  /**
   * Tests for an illegal construction of a paycheck.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup4() {
    SalariedPaycheck negativePayInterval2;
    negativePayInterval2 = new SalariedPaycheck(58888.62, -25625);
  }
}
