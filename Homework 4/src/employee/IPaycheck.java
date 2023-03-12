package employee;

/**
 * Katie Davenport
 * CS 5004 - Homework 4
 *
 * <p>This interface represents a paycheck. All paychecks can answer total pay, total pay after
 * taxes, and the pay rate.
 */
public interface IPaycheck {
  /**
   * Gets total pay.
   *
   * @return the total pay
   */
  double getTotalPay();

  /**
   * Gets pay after taxes.
   *
   * @return the pay after taxes
   */
  double getPayAfterTaxes();

  /**
   * Gets pay rate.
   *
   * @return the pay rate
   */
  double getPayRate();
}
