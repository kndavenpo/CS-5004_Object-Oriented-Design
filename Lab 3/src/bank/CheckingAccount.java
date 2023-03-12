package bank;

/**
 * Katie Davenport
 * CS 5004 - Lab 2
 *
 * <p>This class represents a checking account that inherits methods from the AbstractAccount
 * class. In addition to the abstract account attributes, the checking account is initialized with
 * minimum balance set to the starter amount. In addition to the abstract account class methods,
 * this class can get the minimum balance for the month, make a modified withdrawal, and perform
 * the monthly maintenance to assess monthly fees.
 */
public class CheckingAccount extends AbstractAccount {

  /**
   * The minimum balance over the month.
   */
  private double minimumBalance;
  /**
   * The constant minimumBalanceAllowed.
   */
  private static final int minimumBalanceAllowed = 100;
  /**
   * The constant transactionPenalty.
   */
  private static final int transactionPenalty = 5;


  /**
   * The checking account is initialized with a minimum balance set to the starter amount.
   *
   * @param starterAmount the starter amount
   */
  public CheckingAccount(double starterAmount) {
    super(starterAmount);
    this.minimumBalance = starterAmount;
  }

  /**
   * This method gets the minimum balance.
   *
   * @return the minimum balance
   */
  public double getMinimumBalance() {
    return this.minimumBalance;
  }

  /**
   * This method sets the minimum balance to the new balance if the new balance is less than the
   * existing minimum balance and returns true if a withdrawal is made and returns false if a
   * withdrawal is not made.
   *
   * @param withdrawAmount the withdrawal amount
   * @return boolean
   */
  @Override
  public boolean withdraw(double withdrawAmount) {
    if (super.withdraw(withdrawAmount) == true && balance < minimumBalance) {
      minimumBalance = balance;
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method performs monthly maintenance by subtracting a $5 transaction penalty from the
   * balance if the balance falls below the minimum required balance of $100 at any point during
   * the month.
   */
  public void performMonthlyMaintenance() {
    minimumBalance = getMinimumBalance();
    if (minimumBalance < minimumBalanceAllowed) {
      balance -= transactionPenalty;
    }
  }
}