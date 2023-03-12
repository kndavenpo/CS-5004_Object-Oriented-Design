import java.text.DecimalFormat;

/**
 * Katie Davenport
 * CS5004 - Homework 1
 *
 * <p>This class represents an hourly employee. The employee has a name, employee id and pay rate.
 * This class can add hours to the weekly total, reset hours to zero, get weekly hours worked,
 * and get a weekly check from the Paycheck class.
 *
 * <p>We assume all string inputs to be non-null and all numeric data to be non-negative.
 */
public class Employee {
  private String name;
  private String employeeID;
  double hoursWorked;
  private double payRate;
  private Paycheck paycheck;

  /**
   * Constructs an Employee object with the given name, employee id, and pay rate. Hours worked
   * are initialized to zero.
   *
   * @param name       the name
   * @param employeeID the employee id
   * @param payRate    the hourly pay rate
   */
  public Employee(String name, String employeeID, double payRate) {
    this.name = name;
    this.employeeID = employeeID;
    this.payRate = payRate;
    this.hoursWorked = 0;
  }

  /**
   * Add hours to the Employee's total. It is legal to add negative hours for the week, however
   * total hours worked cannot drop below zero.
   *
   * @param newHoursWorked the new hours worked
   */
  public void addHoursWorked(double newHoursWorked) {
    if (this.hoursWorked + newHoursWorked <= 0) {
      this.hoursWorked = 0;
    }
    else {
      this.hoursWorked = this.hoursWorked + newHoursWorked;
    }
  }

  /**
   * Reset weekly hours worked to zero.
   */
  public void resetHoursWorked() {

    this.hoursWorked = 0;
  }

  /**
   * Return weekly hours worked.
   *
   * @return the weekly hours worked
   */
  public double getHoursWorked() {

    return this.hoursWorked;
  }

  /**
   * Return a new paycheck object that is initialized with the pay rate and hours worked by the
   * employee.
   *
   * @return a Paycheck object
   */
  public Paycheck getWeeklyCheck() {
    return new Paycheck(this.payRate, this.hoursWorked);
  }

  /**
   * Return a string representation of this employee with the name, employee id, and payment after
   * taxes.
   *
   * @return a formatted string
   */
  public String toString() {
    DecimalFormat money = new DecimalFormat("$ 0.00");
    paycheck = this.getWeeklyCheck();
    return "Name: " + this.name + "\nID: " + this.employeeID
            + "\nPayment after taxes: " + money.format(paycheck.getPayAfterTaxes());
  }
}