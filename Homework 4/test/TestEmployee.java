import static org.junit.Assert.assertEquals;

import employee.Employee;
import employee.IPaycheck;
import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS 5004 - Homework 4
 *
 * <p>This is a JUnit test class for the Employee class.
 */
public class TestEmployee {
  private Employee hourly1;
  private Employee hourly2;
  private Employee salaried1;
  private Employee salaried2;


  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    this.hourly1 = new Employee("Helen", "123", 15.17, 10);
    this.hourly2 = new Employee("Jack", "456", 25.76, 50);
    this.salaried1 = new Employee("Alison", "789", 75125,
            4, true);
    this.salaried2 = new Employee("Bob", "A02", 15125,
            1, false);
  }

  /**
   * Test Is Manager indicator.
   */
  @Test
  public void testIsManager() {
    assertEquals(false, hourly1.isManager());
    assertEquals(false, hourly2.isManager());
    assertEquals(true, salaried1.isManager());
    assertEquals(false, salaried2.isManager());
  }

  /**
   * Test the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Name: Helen\nID: 123\nPayment after taxes: $ 136.53",
            this.hourly1.toString());
    assertEquals("Name: Jack\nID: 456\nPayment after taxes: $ 1204.28",
            this.hourly2.toString());
    assertEquals("Name: Alison\nID: 789\nPayment after taxes: $ 4912.02",
            this.salaried1.toString());
    assertEquals("Name: Bob\nID: A02\nPayment after taxes: $ 261.78",
            this.salaried2.toString());
  }

  /**
   * Test the getWeeklyCheck method.
   */
  @Test
  public void TestGetWeeklyCheck() {
    IPaycheck hourlyCheck1 = hourly1.getPaycheck();
    assertEquals("Payment after taxes: $ 136.53", hourlyCheck1.toString());

    IPaycheck hourlyCheck2 = hourly2.getPaycheck();
    assertEquals("Payment after taxes: $ 1204.28", hourlyCheck2.toString());

    IPaycheck salariedCheck1 = salaried1.getPaycheck();
    assertEquals("Payment after taxes: $ 4912.02", salariedCheck1.toString());

    IPaycheck salariedCheck2 = salaried2.getPaycheck();
    assertEquals("Payment after taxes: $ 261.78", salariedCheck2.toString());

  }

  /**
   * Tests for an illegal construction of an employee.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    Employee nullName1;
    nullName1 = new Employee(null, "999", 15, 10);
  }

  /**
   * Tests for an illegal construction of an employee.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    Employee nullName;
    nullName = new Employee(null, "999", 15, 2, false);
  }

  /**
   * Tests for an illegal construction of an employee.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup3() {
    Employee emptyName;
    emptyName = new Employee("", "999", 15, 10);
  }

  /**
   * Tests for an illegal construction of an employee.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup4() {
    Employee emptyName;
    emptyName = new Employee("", "999", 15, 2, false);
  }

  /**
   * Tests for an illegal construction of an employee.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup5() {
    Employee nullID;
    nullID = new Employee("John", null, 15, 10);
  }

  /**
   * Tests for an illegal construction of an employee.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup6() {
    Employee nullID;
    nullID = new Employee("Mary", null, 15, 2, false);
  }

  /**
   * Tests for an illegal construction of an employee.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup7() {
    Employee emptyID;
    emptyID = new Employee("Sue", "", 15, 10);
  }

  /**
   * Tests for an illegal construction of an employee.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup8() {
    Employee emptyID;
    emptyID = new Employee("Hank", "", 15, 2, false);
  }

  /**
   * Tests for an illegal construction of an employee.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup9() {
    Employee negativeRate;
    negativeRate = new Employee("Sue", "652", -10000000, 10);
  }

  /**
   * Tests for an illegal construction of an employee.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup10() {
    Employee negativeRate;
    negativeRate = new Employee("Hank", "aB526", -10, 2,
            false);
  }

  /**
   * Tests for an illegal construction of an employee.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup11() {
    Employee negativeHours;
    negativeHours = new Employee("Hank", "aB526", 100, -560);
  }
}
