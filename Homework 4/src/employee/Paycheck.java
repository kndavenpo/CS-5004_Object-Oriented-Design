package employee;

import java.text.DecimalFormat;

/**
 * Katie Davenport
 * CS 5004 - Homework 4
 *
 * <p>This is the abstract superclass of all Paycheck concrete classes. It implements the
 * IPaycheck interface and serves as the "repository" of reuse code for certain common services.
 */
public abstract class Paycheck implements IPaycheck {
  /**
   * The Pay rate.
   */
  protected double payRate;
  /**
   * The constant minimumPay.
   */
  protected static final double minimumPay = 0.01;
  /**
   * The constant taxRateLow.
   */
  protected static final double taxRateLow = 0.10;
  /**
   * The constant taxRateHigh.
   */
  protected static final double taxRateHigh = 0.15;
  /**
   * The constant taxThreshold.
   */
  protected static final int taxThreshold = 400;


  /**
   * Abstract Paycheck constructor.
   * This class cannot be instantiated, but this creation mechanism ensures the superclass
   * portion of all subclasses is appropriately initialized with a pay rate. An illegal argument
   * exception is thrown if the pay rate is negative.
   *
   * @param payRate the pay rate
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Paycheck(double payRate) throws IllegalArgumentException {
    if (payRate < 0) {
      throw new IllegalArgumentException("The pay rate cannot be negative.");
    }
    this.payRate = payRate;
  }

  /**
   * This method answers the pay rate.
   *
   * @return pay rate
   */
  public double GetPayRate() {
    return this.payRate;
  }


  /**
   * This method answers total pay after taxes. An employee is paid $0.01 if the total pay after
   * taxes is less than $0.01 but greater than $0.00.
   *
   * @return  total pay
   */
  public double getPayAfterTaxes() {
    double totalPay = this.getTotalPay();
    if (totalPay < minimumPay && totalPay > 0) {
      totalPay = minimumPay;
    }

    if (totalPay < taxThreshold) {
      return totalPay * (1 - taxRateLow);
    } else {
      return totalPay * (1 - taxRateHigh);
    }
  }

  @Override
  public String toString() {
    DecimalFormat money = new DecimalFormat("$ 0.00");
    return "Payment after taxes: " + money.format(this.getPayAfterTaxes());
  }
}
