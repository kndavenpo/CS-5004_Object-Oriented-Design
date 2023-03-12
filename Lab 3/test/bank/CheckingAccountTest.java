package bank;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS5004 - Lab 3
 *
 * <p>This is a JUnit test class for the CheckingAccount class.
 */

public class CheckingAccountTest {

  private CheckingAccount account1;
  private CheckingAccount account2;
  private CheckingAccount account3;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    this.account1 = new CheckingAccount(0.05);
    this.account2 = new CheckingAccount(1000000);
    this.account3 = new CheckingAccount(200);
  }

  /**
   * Tests an illegal setup. An illegal argument exception is thrown if the
   * starter amount is less than $0.01.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    CheckingAccount badStarterAmt;
    badStarterAmt = new CheckingAccount(0);
  }

  /**
   * Tests an illegal setup. An illegal argument exception is thrown if the
   * starter amount is less than $0.01.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    CheckingAccount badStarterAmt;
    badStarterAmt = new CheckingAccount(-20);
  }

  /**
   * Tests an illegal call of the deposit method. An illegal argument exception is thrown if the
   * deposit is negative.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalDeposit() {
    account2.deposit(-50.75);
  }

  /**
   * Tests the getBalance method.
   */
  @Test
  public void testGetBalance() {
    assertEquals(0.05, account1.getBalance(), 0.001);
    assertEquals(1000000, account2.getBalance(), 0.001);
    assertEquals(200, account3.getBalance(), 0.001);
  }

  /**
   * Tests the deposit method by calling the deposit method and then checking the balance.
   */
  @Test
  public void testDeposit() {
    // deposit once
    account1.deposit(500);
    assertEquals(500.05, account1.getBalance(), 0.001);

    // deposit multiple times
    account3.deposit(100);
    account3.deposit(8752.56);
    account3.deposit(120.11);
    assertEquals(9172.67, account3.getBalance(), 0.001);
  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("$0.05", account1.toString());
    assertEquals("$1000000.00", account2.toString());
    assertEquals("$200.00", account3.toString());
  }

  /**
   * Tests the withdrawal method by calling the method and then checking the balance.
   */
  @Test
  public void testWithdraw() {
    // Case when withdraw amount is greater than balance
    assertEquals(false, account1.withdraw(1.76));
    assertEquals(0.05, account1.getBalance(), 0.001);

    // Withdraw once
    assertEquals(true, account2.withdraw(35902.12));
    assertEquals(964097.88, account2.getBalance(), 0.001);

    // Withdraw more than once
    assertEquals(true, account3.withdraw(50));
    assertEquals(true, account3.withdraw(19.95));
    assertEquals(130.05, account3.getBalance(), 0.001);

    // Withdraw a negative amount
    assertEquals(false, account2.withdraw(-1));
  }

  /**
   * Tests the getMinimumBalance method.
   */
  @Test
  public void testGetMinimumBalance() {
    // Test initial value before a withdraw is made
    assertEquals(0.05, account1.getMinimumBalance(), 0.001);

    // Test after one withdraw
    account2.withdraw(95779);
    assertEquals(904221, account2.getMinimumBalance(), 0.001);

    // Test after two withdraws and one deposit
    account3.withdraw(50.76);
    account3.deposit(19.75);
    account3.withdraw(20.01);
    assertEquals(148.98, account3.getMinimumBalance(), 0.001);
  }

  /**
   * Tests the performMonthlyMaintenance method by checking the balance and the minimum balance.
   */
  @Test
  public void testPerformMonthlyMaintenance() {
    // Case when there is no monthly maintenance fee
    account1.performMonthlyMaintenance();
    assertEquals(-4.95, account1.getBalance(), 0.001);

    // Case when there is a monthly maintenance fee
    account3.withdraw(110);
    account3.performMonthlyMaintenance();
    assertEquals(85, account3.getBalance(), 0.001);
  }
}
