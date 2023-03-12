import static org.junit.Assert.assertEquals;

import chess.Bishop;
import chess.Color;
import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS5004 - Homework 3
 *
 * <p>This is a JUnit test class for the Bishop class.
 */
public class BishopTest {
  private Bishop piece1;
  private Bishop piece2;
  private Bishop piece3;
  private Bishop piece4;
  private Bishop piece5;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    this.piece1 = new Bishop(1,2, Color.BLACK);
    this.piece2 = new Bishop(4,7, Color.WHITE);
    this.piece3 = new Bishop(5, 6, Color.WHITE);
    this.piece4 = new Bishop(1,2, Color.WHITE);
    this.piece5 = new Bishop(1,4, Color.BLACK);
  }

  /**
   * Tests for an illegal construction of a chess piece. Both the row and column must be between
   * 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    Bishop rowTooSmall;
    rowTooSmall = new Bishop(-2, 3, Color.WHITE);
  }

  /**
   * Tests for an illegal construction of a chess piece. Both the row and column must be between
   * 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    Bishop rowTooBig;
    rowTooBig = new Bishop(15, 3, Color.WHITE);
  }

  /**
   * Tests for an illegal construction of a chess piece. Both the row and column must be between
   * 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup3() {
    Bishop columnTooSmall;
    columnTooSmall = new Bishop(7, -50, Color.WHITE);
  }

  /**
   * Tests for an illegal construction of a chess piece. Both the row and column must be between
   * 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup4() {
    Bishop columnTooBig;
    columnTooBig = new Bishop(7, 33356, Color.WHITE);
  }

  /**
   * Test the getRow method.
   */
  @Test
  public void testGetRow() {
    assertEquals(1, piece1.getRow());
    assertEquals(4, piece2.getRow());
  }

  /**
   * Test the getColumn method.
   */
  @Test
  public void testGetColumn() {
    assertEquals(2, piece1.getColumn());
    assertEquals(7, piece2.getColumn());
  }

  /**
   * Test the getColor method.
   */
  @Test
  public void testGetColor() {
    assertEquals(Color.BLACK, piece1.getColor());
    assertEquals(Color.WHITE, piece2.getColor());
  }

  /**
   * Tests for illegal inputs for the CanMove method. Both the target row and target column must
   * be between 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void badCanMoveInputs1() {
    this.piece1.canMove(-2,3);
  }

  /**
   * Tests for illegal inputs for the CanMove method. Both the target row and target column must
   * be between 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void badCanMoveInputs2() {
    this.piece1.canMove(10,3);
  }

  /**
   * Tests for illegal inputs for the CanMove method. Both the target row and target column must
   * be between 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void badCanMoveInputs3() {
    this.piece1.canMove(5,-55);
  }

  /**
   * Tests for illegal inputs for the CanMove method. Both the target row and target column must
   * be between 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void badCanMoveInputs4() {
    this.piece1.canMove(5,18);
  }

  /**
   * Test can move.
   */
  @Test
  public void testCanMove() {
    // Can move
    assertEquals(true, piece2.canMove(5, 6));
    assertEquals(true, piece2.canMove(1,4));

    // Cannot move
    assertEquals(false, piece1.canMove(1,2)); // own location
    assertEquals(false, piece1.canMove(4, 7));
  }

  /**
   * Test can kill.
   */
  @Test
  public void testCanKill() {
    // Can kill
    assertEquals(true, piece1.canKill(piece3));
    assertEquals(true, piece2.canKill(piece5));

    // Cannot kill
    assertEquals(false, piece1.canKill(piece2));
    assertEquals(false, piece1.canKill(piece4)); // own location
  }
}
