import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS5004 - Homework 1
 *
 * <p>This is a JUnit test class for the Employee class.
 */
public class EmployeeTest {
  private Employee helen;
  private Employee jasmine;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {

    this.helen = new Employee("Helen", "123", 30.00);
  }

  /**
   * Test the addHoursWorked method.
   */
  @Test
  public void testAddHoursWorked() {
    this.helen.addHoursWorked(10);   // Add positive
    assertEquals(10.00, this.helen.hoursWorked, 0.001);

    this.helen.addHoursWorked(-10);   // Add negative
    assertEquals(0.00, this.helen.hoursWorked, 0.001);
  }

  /**
   * Test the resetHoursWorked method.
   */
  @Test
  public void testResetHoursWorked() {
    this.helen.addHoursWorked(10);  // Add positive
    this.helen.resetHoursWorked();
    assertEquals(0, this.helen.hoursWorked, 0.001);

    this.helen.addHoursWorked(-10);  // Add negative
    this.helen.resetHoursWorked();
    assertEquals(0, this.helen.hoursWorked, 0.001);
  }

  /**
   * Test the getHoursWorked method.
   */
  @Test
  public void testGetHoursWorked() {
    this.helen.addHoursWorked(10); // Add positive
    assertEquals(10, this.helen.getHoursWorked(), 0.001);

    this.helen.addHoursWorked(-10); // Add negative
    assertEquals(0, this.helen.getHoursWorked(), 0.001);
  }

  /**
   * Test the getWeeklyCheck method.
   */
  @Test
  public void testGetWeeklyCheck() {
    this.helen.addHoursWorked(10); // add positive
    assertEquals("Name: Helen\nID: 123\nPayment after taxes: $ 270.00", this.helen.toString());

    this.helen.resetHoursWorked(); // set to zero
    assertEquals("Name: Helen\nID: 123\nPayment after taxes: $ 0.00", this.helen.toString());
  }

  /**
   * Test the toString method.
   */
  @Test
  public void testToString() {
    this.helen.addHoursWorked(10);
    assertEquals("Name: Helen\nID: 123\nPayment after taxes: $ 270.00",
            this.helen.toString());

    this.helen.resetHoursWorked(); // set to zero
    assertEquals("Name: Helen\nID: 123\nPayment after taxes: $ 0.00",
            this.helen.toString());
  }
}