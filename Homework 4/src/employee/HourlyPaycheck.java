package employee;

/**
 * Katie Davenport
 * CS 5004 - Homework 4
 *
 * <p>This class represents a paycheck for an hourly worker. The paycheck has a pay rate and hours
 * worked. It can answer the pay rate, total pay, total pay after taxes, hours worked, and a string.
 * It can also add hours worked and reset hours worked.
 */
public class HourlyPaycheck extends Paycheck {
  private double hoursWorked;
  private static final double overtimeMultiple = 1.5;
  private static final int standardHours = 40;

  /**
   * Instantiates a new Hourly paycheck with the given pay rate and hours worked. An Illegal
   * Argument Exception is thrown if hours worked is negative.
   *
   * @param payRate     the pay rate
   * @param hoursWorked the hours worked
   * @throws IllegalArgumentException the illegal argument exception
   */
  public HourlyPaycheck(double payRate, double hoursWorked) throws IllegalArgumentException {
    super(payRate);
    if (hoursWorked < 0) {
      throw new IllegalArgumentException("Hours worked cannot be negative.");
    }
    this.hoursWorked = hoursWorked;
  }

  @Override
  public double getPayRate() {
    return this.payRate;
  }

  @Override
  public double getTotalPay() {
    // If the employee works more than 40 hours in a week they are paid a 50% overtime bonus for
    // the incremental hours worked.
    if (this.hoursWorked > standardHours) {
      return this.GetPayRate() * standardHours
              + overtimeMultiple * this.GetPayRate() * (this.hoursWorked - standardHours);
    } else {
      return this.GetPayRate() * this.hoursWorked;
    }
  }

  /**
   * This method adds hours to the Employee's total. It is legal to add negative hours for the
   * week, however total hours worked cannot drop below zero.
   *
   * @param newHours the new hours worked
   */
  public void addHoursWorked(double newHours) {
    if (this.hoursWorked + newHours <= 0) {
      this.hoursWorked = 0;
    } else {
      this.hoursWorked = this.hoursWorked + newHours;
    }
  }

  /**
   * This method answers hours worked.
   *
   * @return the hours worked
   */
  public double getHoursWorked() {
    return this.hoursWorked;
  }

  /**
   * This method resets hours worked to zero.
   */
  public void resetHoursWorked() {
    this.hoursWorked = 0;
  }
}
