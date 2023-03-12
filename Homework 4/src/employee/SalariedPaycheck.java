package employee;

/**
 * Katie Davenport
 * CS 5004 - Homework 4
 *
 * <p>This class represents a paycheck for a salaried worker. The paycheck has a pay rate and pay
 * interval. It can answer the pay rate, total pay, total pay after taxes, and a string.
 */
public class SalariedPaycheck extends Paycheck {
  private int payInterval;
  private static final int weeksPerYear = 52;

  /**
   * Instantiates a new salaried paycheck with the given pay rate and pay interval. An illegal
   * argument exception is thrown if the pay interval is negative.
   *
   * @param payRate     the pay rate
   * @param payInterval the pay interval
   */
  public SalariedPaycheck(double payRate, int payInterval) throws IllegalArgumentException {
    super(payRate);
    if (payInterval < 0) {
      throw new IllegalArgumentException("Pay interval cannot be negative.");
    }
    this.payInterval = payInterval;
  }

  @Override
  public double getPayRate() {
    return this.payRate;
  }

  @Override
  public double getTotalPay() {
    // Divide the pay rate by weeks per year and multiply by the pay interval.
    return this.payRate / weeksPerYear * payInterval;
  }
}
