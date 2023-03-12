package employee;

import java.text.DecimalFormat;

/**
 * Katie Davenport
 * CS5004 - Homework 4
 *
 * <p>This class represents two types of employees: hourly and salaried. Both types have a name,
 * employee id, and pay rate. Additionally, hourly employees have hours worked and a salaried
 * employees have a pay interval and a manager indicator. Hourly employees cannot be managers.
 * This class answers if an employee is a manager, a paycheck, and a string.
 */
public class Employee {
  private String name;
  private String employeeID;
  private double hoursWorked;
  private boolean isManager;
  private IPaycheck paycheck;
  private int payInterval;
  private double payRate;


  /**
   * Constructs an hourly employee object with the given name, employee id, pay rate and hours
   * worked. The manager indicator is set to false and an hourly paycheck is created with the
   * given pay rate and hours worked. An illegal argument exception is thrown if the name or
   * employee id are either empty strings or null.
   *
   * @param name       the name
   * @param id         the employee id
   * @param payRate    the hourly pay rate
   */
  public Employee(String name, String id, double payRate, double hoursWorked) throws
          IllegalArgumentException {
    if (name == null || name.length() == 0 || id == null || id.length() == 0) {
      throw new IllegalArgumentException("The name and the employee id cannot be either null "
              + "or an empty string.");
    }

    this.name = name;
    this.employeeID = id;
    this.payRate = payRate;
    this.hoursWorked = hoursWorked;
    this.isManager = false;
    this.paycheck = new HourlyPaycheck(payRate, hoursWorked);
  }

  /**
   * Constructs a salaried employee object with the given name, employee id, pay rate, pay interval,
   * and manager indicator. A salaried paycheck is created with the given pay rate and pay interval.
   * An illegal argument exception is thrown if the name or employee id are either empty strings or
   * null.
   *
   * @param name        the name
   * @param id          the employee id
   * @param payRate     the hourly pay rate
   * @param payInterval the pay interval
   * @param isManager   the is manager
   */
  public Employee(String name, String id, double payRate, int payInterval,
                  boolean isManager) throws IllegalArgumentException {
    if (name == null || name.length() == 0 || id == null || id.length() == 0) {
      throw new IllegalArgumentException("The name and the employee id cannot be either null "
              + "or an empty string.");
    }
    this.name = name;
    this.employeeID = id;
    this.payRate = payRate;
    this.payInterval = payInterval;
    this.isManager = isManager;
    this.paycheck = new SalariedPaycheck(payRate, payInterval);
  }

  /**
   * This method answers a new paycheck object for the employee.
   *
   * @return a Paycheck object
   */
  public Paycheck getPaycheck() {
    return (Paycheck) this.paycheck;
  }

  /**
   * This method answers a boolean to indicate if the employee is a manager.
   *
   * @return the boolean
   */
  public boolean isManager() {
    return this.isManager;
  }

  /**
   * This method answers a string representation of this employee.
   *
   * @return a formatted string
   */
  public String toString() {
    DecimalFormat money = new DecimalFormat("$ 0.00");
    paycheck = this.getPaycheck();
    return "Name: " + this.name + "\nID: " + this.employeeID
            + "\nPayment after taxes: " + money.format(paycheck.getPayAfterTaxes());
  }
}
