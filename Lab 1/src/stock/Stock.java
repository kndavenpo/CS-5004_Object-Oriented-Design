package stock;

import java.text.DecimalFormat;

/**
 * Katie Davenport
 * CS5004 - Lab1
 * This class represents a stock to be traded. A stock has a symbol, name, and cost basis.
 */
public class puStock {
  private String symbol;
  private String name;
  private double costBasis;
  private double currentPrice;

  /**
   * Constructs a Stock object that has the provided symbol, name, and cost basis.
   *
   * @param symbol    the symbol
   * @param name      the name
   * @param costBasis the cost basis
   */
  public Stock(String symbol, String name, double costBasis) {
    this.symbol = symbol;
    this.name = name;
    this.costBasis = costBasis;
  }

  /**
   * Gets the symbol of this stock.
   *
   * @return the symbol of this stock
   */
  public String getSymbol() {
    return this.symbol;
  }

  /**
   * Gets the name of this stock.
   *
   * @return the name of this stock
   */
  public String getName() {
    return this.name;
  }


  /**
   * Gets the cost basis of this stock.
   *
   * @return the cost basis of this stock
   */
  public double getCostBasis() {
    return this.costBasis;
  }


  /**
   * Gets the current price of this stock.
   *
   * @return the current price of this stock
   */
  public double getCurrentPrice() {
    return this.currentPrice;
  }


  /**
   * Sets the cost basis of this stock.
   *
   * @param newCostBasis the new cost basis
   */
  public void setCostBasis(double newCostBasis) {
    this.costBasis = newCostBasis;
  }


  /**
   * Sets the current price of this stock.
   *
   * @param newCurrentPrice the new current price
   */
  public void setCurrentPrice(double newCurrentPrice) {
    this.currentPrice = newCurrentPrice;
  }


  /**
   * Gets the fractional change between the original cost basis and the current price.
   *
   * @return the change percent
   */
  public double getChangePercent() {
    return (this.currentPrice - this.costBasis) / this.costBasis;
  }

t
  // Check formatting
  /**
   * Creates a string description of the stock instance with the name of the company, current
   * price, and the gain/loss percentage.
   *
   * @return the string representation of the stock.
   */

  public String toString() {
    DecimalFormat money = new DecimalFormat("$ 0.00");
    DecimalFormat percent = new DecimalFormat("0.00%");
    return this.name + " Current Price: " + money.format(this.currentPrice) + "\n Gain/Loss: "
            + percent.format(this.getChangePercent());
  }
}
