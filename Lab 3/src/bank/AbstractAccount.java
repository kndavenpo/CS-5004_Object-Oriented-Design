package bank;

import java.text.DecimalFormat;

/**
 * Katie Davenport
 * CS 5004 - Lab 2
 *
 * <p>This abstract class represents a generic bank account. The abstract account has a starter
 * balance. The abstract account can make a deposit, make a withdrawal, return the balance, and
 * return a string representation of the account balance.
 */
public abstract class AbstractAccount implements IAccount {

  /**
   * The Balance.
   */
  protected double balance;

  /**
   * Constructs an account with the balance equal to the given starter amount. An illegal argument
   * exception is thrown if the starter amount is less than $0.01.
   *
   * @param starterAmount the starter amount
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractAccount(double starterAmount) throws IllegalArgumentException {
    if (starterAmount < 0.01) {
      throw new IllegalArgumentException("The starting balance must be equal to or greater "
              + "than $0.01.");
    }
    this.balance = starterAmount;
  }

  /**
   * This method subtracts the deposit amount from the account balance.
   *
   * @param depositAmount the amount to deposit into the account
   * @throws IllegalArgumentException if the deposit amount is negative
   */
  public void deposit(double depositAmount) throws IllegalArgumentException {
    if (depositAmount < 0) {
      throw new IllegalArgumentException("The deposit amount cannot be negative.");
    }
    this.balance += depositAmount;
  }

  /**
   * This method deducts the withdrawal amount from the balance and returns true if the withdrawal
   * amount is less than the account balance. This method returns false if the withdrawal amount
   * is greater than the current balance. The withdrawal amount must be greater than 0.
   *
   * @param withdrawAmount the withdrawal amount
   * @return boolean
   */
  @Override
  public boolean withdraw(double withdrawAmount) {
    if (withdrawAmount <= this.balance && withdrawAmount > 0) {
      this.balance -= withdrawAmount;
      return true;
    } else {
      return false;
    }
  }

  @Override
  public double getBalance() {
    return this.balance;
  }

  @Override
  public String toString() {
    DecimalFormat money = new DecimalFormat("$0.00");
    return money.format(this.balance);
  }
}