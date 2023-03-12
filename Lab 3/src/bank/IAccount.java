package bank;

/**
 * Katie Davenport
 * CS 5004 - Lab 3
 *
 * <p>This interface represents a bank account. It is the super-type for any other type of
 * traditional financial account a bank might offer.
 */
public interface IAccount {
  /**
   * This method deposits money into the account.
   *
   * @param amount the deposit amount
   */
  public void deposit(double amount);

  /**
   * This method withdraws money from the account and returns a boolean to indicate if the
   * transaction was successful.
   *
   * @param amount the amount
   * @return the boolean
   */
  public boolean withdraw(double amount);


  /**
   * Gets balance.
   *
   * @return the balance
   */
  public double getBalance();

  /**
   * This method performs monthly maintenance on the account.
   */
  public void performMonthlyMaintenance();
}
