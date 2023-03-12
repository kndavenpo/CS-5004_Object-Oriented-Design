import java.text.DecimalFormat;

/**
 * Katie Davenport
 * CS5004 - Homework 1
 *
 * <p>This class represents a paycheck with a rate and hours worked. This class calculates weekly
 * pay before and after taxes.
 */
public class Paycheck {
  private double payRate;
  private double hoursWorked;
  private double totalPay;

  // Declare constants
  public static final int taxThreshold = 400;
  public static final double taxRateLow = 0.10;
  public static final double taxRateHigh = 0.15;
  public static final int standardHours = 40;
  public static final double overtimeMultiple = 1.5;

  /**
   * Constructs a Paycheck object with the given rate and hours worked. The constructor calculates
   * total weekly pay. Weekly pay is equal to the pay rate times the number of hours worked
   * for up to forty hours and 1.5x the pay rate for any hours worked more than 40 hours. If an
   * employee earned more than 0 but less than 1 cent, they are paid 1 cent.
   *
   * @param payRate     the hourly pay rate
   * @param hoursWorked the hours worked in a week
   */

  public Paycheck(double payRate, double hoursWorked) {
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;

    if (this.hoursWorked > standardHours) {
      this.totalPay = this.payRate * standardHours
              + overtimeMultiple * this.payRate * (this.hoursWorked - standardHours);
    }
    else {
      this.totalPay = this.payRate * this.hoursWorked;
    }
  }

  /**
   * Return total weekly pay before taxes.
   *
   * @return total weekly pay before taxes
   */
  public double getTotalPay() {
    return this.totalPay;
  }

  /**
   * Return total weekly pay after taxes. Taxes are 10% if total pay is less than $400 and 15%
   * if total pay is equal to or greater than $400. Also applies the condition that if an
   * employee earned more than 0 but less than 1 cent, they are paid 1 cent.
   *
   * @return total weekly pay after taxes
   */
  public double getPayAfterTaxes() {
    double totalPay = this.getTotalPay();

    if (totalPay < 0.01 && totalPay > 0) {
      totalPay = 0.01;
    }

    if (totalPay < taxThreshold) {
      return totalPay * (1 - taxRateLow);
    }
    else {
      return totalPay * (1 - taxRateHigh);
    }
  }

  /**
   * Return a string representation of this paycheck with the payment after taxes.
   *
   * @return a formatted string
   */
  public String toString() {
    DecimalFormat money = new DecimalFormat("$ 0.00");
    return "Payment after taxes: " + money.format(this.getPayAfterTaxes());
  }
}