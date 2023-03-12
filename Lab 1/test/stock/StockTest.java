/**
 * Katie Davenport
 * CS5004 - Lab1
 *
 * <p>This is a JUnit test class for the Stock class.
 */

package stock;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * The type Stock test.
 */
public class StockTest {
  private Stock microsoft;
  private Stock alphabet;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    this.microsoft = new Stock("MSFT", "Microsoft Corp.", 245.38);
    this.alphabet = new Stock("GOOG", "Alphabet Inc.", 103.90);
  }

  /**
   * Test the getSymbol method.
   */
  @Test
  public void testGetSymbol() {
    assertEquals("MSFT", this.microsoft.getSymbol());
    assertEquals("GOOG", this.alphabet.getSymbol());
  }

  /**
   * Test the getName method.
   */
  @Test
  public void testGetName() {
    assertEquals("Microsoft Corp.", this.microsoft.getName());
    assertEquals("Alphabet Inc.", this.alphabet.getName());
  }

  /**
   * Test the getCostBasis method.
   */
  @Test
  public void testGetCostBasis() {
    assertEquals(245.38, this.microsoft.getCostBasis(), 0.001);
    assertEquals(103.90, this.alphabet.getCostBasis(), 0.001);
  }

  /**
   * Test the getCurrentPrice method.
   */
  @Test
  public void testGetCurrentPrice() {
    this.microsoft.setCurrentPrice(279.12);
    this.alphabet.setCurrentPrice(50.32);
    assertEquals(279.12, this.microsoft.getCurrentPrice(), 0.001);
    assertEquals(50.32, this.alphabet.getCurrentPrice(), 0.001);
  }

  /**
   * Test the setCostBasis method.
   */
  @Test
  public void testSetCostBasis() {
    this.microsoft.setCostBasis(270.13);
    this.alphabet.setCostBasis(110.15);
    assertEquals(270.13, this.microsoft.getCostBasis(), 0.001);
    assertEquals(110.15, this.alphabet.getCostBasis(), 0.001);
  }

  /**
   * Test the setCurrentPrice method.
   */
  @Test
  public void testSetCurrentPrice() {
    this.microsoft.setCurrentPrice(50.15);
    this.alphabet.setCurrentPrice(99.01);
    assertEquals(50.15, this.microsoft.getCurrentPrice(), 0.001);
    assertEquals(99.01, this.alphabet.getCurrentPrice(), 0.001);
  }


  /**
   * Test the getChangePercent method.
   */
  @Test
  public void testGetChangePercent() {
    this.microsoft.setCurrentPrice(275.19); // Test gain
    assertEquals(0.1215, this.microsoft.getChangePercent(), 0.001);

    this.alphabet.setCurrentPrice(126.17); // Test gain
    assertEquals(0.2143, this.alphabet.getChangePercent(), 0.001);

    this.microsoft.setCurrentPrice(230.75); // Test loss
    assertEquals(-0.0596, this.microsoft.getChangePercent(), 0.001);

    this.alphabet.setCurrentPrice(90.63); // Test loss
    assertEquals(-0.1277, this.alphabet.getChangePercent(), 0.001);
  }

  /**
   * Test the toString method.
   */

  @Test
  public void testToString() {
    this.microsoft.setCurrentPrice(275.19); // Test gain
    assertEquals("Microsoft Corp. Current Price: $ 275.19\n Gain/Loss: 12.15%",
            this.microsoft.toString());

    this.alphabet.setCurrentPrice(126.17); // Test gain
    assertEquals("Alphabet Inc. Current Price: $ 126.17\n Gain/Loss: 21.43%",
            this.alphabet.toString());

    this.microsoft.setCurrentPrice(230.75); // Test loss
    assertEquals("Microsoft Corp. Current Price: $ 230.75\n Gain/Loss: -5.96%",
            this.microsoft.toString());

    this.alphabet.setCurrentPrice(90.63); // Test loss
    assertEquals("Alphabet Inc. Current Price: $ 90.63\n Gain/Loss: -12.77%",
            this.alphabet.toString());
  }

}
