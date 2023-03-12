import static org.junit.Assert.assertEquals;

import chess.Color;
import chess.Queen;
import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS5004 - Homework 3
 *
 * <p>This is a JUnit test class for the Queen class.
 */
public class QueenTest {
  private Queen piece1;
  private Queen piece2;
  private Queen piece3;
  private Queen piece4;
  private Queen piece5;
  private Queen piece6;
  private Queen piece7;
  private Queen piece8;
  private Queen piece9;
  private Queen piece10;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    this.piece1 = new Queen(1,2, Color.BLACK);
    this.piece2 = new Queen(4,7, Color.WHITE);
    this.piece3 = new Queen(1,2, Color.WHITE);
    this.piece4 = new Queen(5,2, Color.WHITE);
    this.piece5 = new Queen(6,7, Color.WHITE);
    this.piece6 = new Queen(1,4, Color.WHITE);
    this.piece7 = new Queen(0,1, Color.WHITE);
    this.piece8 = new Queen(3,3, Color.WHITE);
    this.piece9 = new Queen(0,5, Color.WHITE);
    this.piece10 = new Queen(4,7, Color.BLACK);
  }

  /**
   * Tests for an illegal construction of a chess piece. Both the row and column must be between
   * 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    Queen rowTooSmall;
    rowTooSmall = new Queen(-2, 3, Color.WHITE);
  }

  /**
   * Tests for an illegal construction of a chess piece. Both the row and column must be between
   * 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    Queen rowTooBig;
    rowTooBig = new Queen(15, 3, Color.WHITE);
  }

  /**
   * Tests for an illegal construction of a chess piece. Both the row and column must be between
   * 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup3() {
    Queen columnTooSmall;
    columnTooSmall = new Queen(7, -50, Color.WHITE);
  }

  /**
   * Tests for an illegal construction of a chess piece. Both the row and column must be between
   * 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup4() {
    Queen columnTooBig;
    columnTooBig = new Queen(7, 33356, Color.WHITE);
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
    assertEquals(true, piece1.canMove(5, 2));
    assertEquals(true, piece1.canMove(6, 7));
    assertEquals(true, piece1.canMove(1, 4));
    assertEquals(true, piece1.canMove(0, 1));

    // Cannot move
    assertEquals(false, piece1.canMove(4, 7));
    assertEquals(false, piece1.canMove(3, 3));
    assertEquals(false, piece1.canMove(0, 5));
    assertEquals(false, piece1.canMove(1, 2));
  }

  /**
   * Test can kill.
   */
  @Test
  public void testCanKill() {
    // Can kill
    assertEquals(true, piece1.canKill(piece4));
    assertEquals(true, piece1.canKill(piece5));
    assertEquals(true, piece1.canKill(piece6));
    assertEquals(true, piece1.canKill(piece7));

    // Cannot kill
    assertEquals(false, piece1.canKill(piece2));
    assertEquals(false, piece1.canKill(piece8));
    assertEquals(false, piece1.canKill(piece9));
    assertEquals(false, piece1.canKill(piece3));
  }

}
