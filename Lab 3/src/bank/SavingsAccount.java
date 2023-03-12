package bank;

/**
 * Katie Davenport
 * CS 5004 - Lab 2
 *
 * <p>This class represents a saving account that inherits methods from the AbstractAccount
 * class. In addition to the abstract account attributes, the saving account is initialized with
 * a withdrawal counter set to zero. In addition to the abstract account class methods, this class
 * can get the number of withdrawals, make a modified withdrawal, and perform the monthly
 * maintenance to assess monthly fees and reset the withdrawal counter to 0.
 */
public class SavingsAccount extends AbstractAccount {

  /**
   * The minimum balance over the month.
   */
  private int withdrawalCounter;
  /**
   * The constant minimumBalanceAllowed.
   */
  public static final int numberOfFreeWithdrawals = 6;
  /**
   * The constant transactionPenalty.
   */
  public static final int transactionPenalty = 14;

  /**
   * The savings account is initialized with the withdrawal counter set to 0.
   *
   * @param starterAmount the starter amount
   */
  public SavingsAccount(double starterAmount) {
    super(starterAmount);
    this.withdrawalCounter = 0;
  }

  /**
   * This method gets the number of withdrawals made over the month.
   *
   * @return the minimum balance
   */
  public int getWithdrawalCount() {
    return this.withdrawalCounter;
  }

  /**
   * This method adds 1 to the withdrawal counter and returns true if a withdrawal is made and
   * returns false if a withdrawal is not made.
   *
   * @param withdrawAmount the withdrawal amount
   * @return boolean
   */
  @Override
  public boolean withdraw(double withdrawAmount) {
    if (super.withdraw(withdrawAmount) == true) {
      withdrawalCounter += 1;
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method performs monthly maintenance by subtracting a $14 transaction penalty from the
   * balance if the number of withdrawals is greater than 6. The withdrawal counter is reset to 0.
   */
  public void performMonthlyMaintenance() {
    int withdrawalCount = getWithdrawalCount();
    if (withdrawalCount > numberOfFreeWithdrawals) {
      balance -= transactionPenalty;
    }
    withdrawalCounter = 0;
  }
}
