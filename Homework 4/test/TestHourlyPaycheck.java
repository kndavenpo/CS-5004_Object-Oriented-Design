import static org.junit.Assert.assertEquals;

import employee.HourlyPaycheck;
import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS 5004 - Homework 4
 *
 * <p>This is a JUnit test class for the HourlyPaycheck class.
 */
public class TestHourlyPaycheck {
  private HourlyPaycheck paycheck1;
  private HourlyPaycheck paycheck2;
  private HourlyPaycheck paycheck3;
  private HourlyPaycheck paycheck4;
  private HourlyPaycheck paycheck5;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    // High tax rate and no overtime
    this.paycheck1 = new HourlyPaycheck(20.56, 20 );
    // High tax rate and overtime
    this.paycheck2 = new HourlyPaycheck(476.22, 60.85 );
    // Low tax rate and no overtime
    this.paycheck3 = new HourlyPaycheck(18.56, 15.89 );
    // Low tax rate and overtime
    this.paycheck4 = new HourlyPaycheck(8.55, 42.23 );
    // Earns less than $0.01 after taxes
    this.paycheck5 = new HourlyPaycheck(1.00, 0.0023 );
  }

  /**
   * Test get pay rate.
   */
  @Test
  public void testGetPayRate() {
    assertEquals(20.56, paycheck1.getPayRate(), 0.001);
    assertEquals(476.22, paycheck2.getPayRate(), 0.001);
    assertEquals(18.56, paycheck3.getPayRate(), 0.001);
    assertEquals(8.55, paycheck4.getPayRate(), 0.001);
    assertEquals(1.00, paycheck5.getPayRate(), 0.001);
  }

  /**
   * Test total pay.
   */
  @Test
  public void testGetTotalPay() {
    // Use delta of 0.005 since we are rounding to the nearest penny.
    assertEquals(411.20, paycheck1.getTotalPay(), 0.005);
    assertEquals(33942.58, paycheck2.getTotalPay(), 0.005);
    assertEquals(294.92, paycheck3.getTotalPay(), 0.005);
    assertEquals(370.60, paycheck4.getTotalPay(), 0.005);

    // Use delta of 0.001. We don't round up to $0.01 until calculating pay after taxes.
    assertEquals(0.0023, paycheck5.getTotalPay(), 0.001);
  }

  /**
   * Test get pay after taxes.
   */
  @Test
  public void testGetPayAfterTaxes() {
    // Use delta of 0.005 since we are rounding to the nearest penny.
    assertEquals(349.52, paycheck1.getPayAfterTaxes(), 0.05);
    assertEquals(28851.19, paycheck2.getPayAfterTaxes(), 0.05);
    assertEquals(265.43, paycheck3.getPayAfterTaxes(), 0.05);
    assertEquals(333.54, paycheck4.getPayAfterTaxes(), 0.05);

    // Use delta of 0.001 since we pay exactly $0.01 when pay after taxes is between
    // $0.00 and $0.01.
    assertEquals(0.01, paycheck5.getPayAfterTaxes(), 0.001);
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    assertEquals("Payment after taxes: $ 349.52", paycheck1.toString());
    assertEquals("Payment after taxes: $ 28851.19", paycheck2.toString());
    assertEquals("Payment after taxes: $ 265.43", paycheck3.toString());
    assertEquals("Payment after taxes: $ 333.54", paycheck4.toString());
    assertEquals("Payment after taxes: $ 0.01", paycheck5.toString());
  }

  /**
   * Test get hours worked.
   */
  @Test
  public void testGetHoursWorked() {
    assertEquals(20, paycheck1.getHoursWorked(), 0.001);
    assertEquals(60.85, paycheck2.getHoursWorked(), 0.001);
    assertEquals(15.89, paycheck3.getHoursWorked(), 0.001);
    assertEquals(42.23, paycheck4.getHoursWorked(), 0.001);
    assertEquals(0.0023, paycheck5.getHoursWorked(), 0.001);
  }

  /**
   * Test add hours worked.
   */
  @Test
  public void testAddHoursWorked1() {
    // Add once
    paycheck1.addHoursWorked(10.56);
    assertEquals(30.56, paycheck1.getHoursWorked(), 0.001);
  }

  /**
   * Test add hours worked.
   */
  @Test
  public void testAddHoursWorked2() {
    // Add / subtract multiple times
    paycheck1.addHoursWorked(10.56);
    paycheck1.addHoursWorked(-5.26);
    paycheck1.addHoursWorked(15.98);
    assertEquals(41.28, paycheck1.getHoursWorked(), 0.001);
  }

  /**
   * Test add hours worked.
   */
  @Test
  public void testAddHoursWorked3() {
    // Subtract so that total is negative
    paycheck1.addHoursWorked(-10.56);
    paycheck1.addHoursWorked(-5.26);
    paycheck1.addHoursWorked(-15.98);
    assertEquals(0, paycheck1.getHoursWorked(), 0.001);
  }

  /**
   * Test reset hours worked.
   */
  @Test
  public void testResetHoursWorked() {
    paycheck1.resetHoursWorked();
    assertEquals(0, paycheck1.getHoursWorked(), 0.001);
    paycheck2.resetHoursWorked();
    assertEquals(0, paycheck2.getHoursWorked(), 0.001);
    paycheck3.resetHoursWorked();
    assertEquals(0, paycheck2.getHoursWorked(), 0.001);
    paycheck4.resetHoursWorked();
    assertEquals(0, paycheck2.getHoursWorked(), 0.001);
    paycheck5.resetHoursWorked();
    assertEquals(0, paycheck2.getHoursWorked(), 0.001);
  }

  /**
   * Tests for an illegal construction of a Paycheck.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    HourlyPaycheck negativePayRate;
    negativePayRate = new HourlyPaycheck(-10.36, 20 );
  }

  /**
   * Tests for an illegal construction of a Paycheck.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    HourlyPaycheck negativePayRate2;
    negativePayRate2 = new HourlyPaycheck(-100632578.36, 20 );
  }

  /**
   * Tests for an illegal construction of a paycheck.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup3() {
    HourlyPaycheck negativeHours;
    negativeHours = new HourlyPaycheck(20.88, -20.56 );
  }

  /**
   * Tests for an illegal construction of a paycheck.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup4() {
    HourlyPaycheck negativeHours2;
    negativeHours2 = new HourlyPaycheck(20.88, -205625.56 );
  }
}
