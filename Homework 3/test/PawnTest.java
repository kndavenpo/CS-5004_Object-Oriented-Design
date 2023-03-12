import static org.junit.Assert.assertEquals;

import chess.Color;
import chess.Pawn;
import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS5004 - Homework 3
 *
 * <p>This is a JUnit test class for the Pawn class.
 */
public class PawnTest {
  private Pawn piece1;
  private Pawn piece2;
  private Pawn piece3;
  private Pawn piece4;
  private Pawn piece5;
  private Pawn piece6;
  private Pawn piece7;
  private Pawn piece8;
  private Pawn piece9;
  private Pawn piece10;
  private Pawn piece11;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    this.piece1 = new Pawn(1,2, Color.WHITE);
    this.piece2 = new Pawn(4,7, Color.WHITE);
    this.piece3 = new Pawn(3,4, Color.WHITE);
    this.piece4 = new Pawn(6,4, Color.BLACK);
    this.piece5 = new Pawn(4,5, Color.BLACK);
    this.piece6 = new Pawn(5,3, Color.WHITE);
    this.piece7 = new Pawn(5,5, Color.WHITE);
    this.piece8 = new Pawn(5,6, Color.WHITE);
    this.piece9 = new Pawn(2,1, Color.BLACK);
    this.piece10 = new Pawn(2,2, Color.BLACK);
    this.piece11 = new Pawn(2, 3, Color.BLACK);
  }

  /**
   * Tests for an illegal construction of a chess piece. Both the row and column must be between
   * 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalPieceSetup1() {
    Pawn rowTooSmall;
    rowTooSmall = new Pawn(-2, 3, Color.WHITE);
  }

  /**
   * Tests for an illegal construction of a chess piece. Both the row and column must be between
   * 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalPieceSetup2() {
    Pawn rowTooBig;
    rowTooBig = new Pawn(15, 3, Color.WHITE);
  }

  /**
   * Tests for an illegal construction of a chess piece. Both the row and column must be between
   * 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalPieceSetup3() {
    Pawn columnTooSmall;
    columnTooSmall = new Pawn(7, -50, Color.WHITE);
  }

  /**
   * Tests for an illegal construction of a chess piece. Both the row and column must be between
   * 0 and 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalPieceSetup4() {
    Pawn columnTooBig;
    columnTooBig = new Pawn(7, 33356, Color.WHITE);
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
    assertEquals(Color.WHITE, piece1.getColor());
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
   * Tests for an illegal construction of a pawn. A black pawn cannot be in row 7 and a white
   * pawn cannot be in row 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalPawnSetup1() {
    Pawn illegalWhite;
    illegalWhite = new Pawn(7, 5, Color.BLACK);
  }

  /**
   * Tests for an illegal construction of a pawn. A black pawn cannot be in row 7 and a white
   * pawn cannot be in row 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalPawnSetup2() {
    Pawn illegalWhite;
    illegalWhite = new Pawn(0, 5, Color.WHITE);
  }


  /**
   * Test can move.
   */
  @Test
  public void testCanMove() {
    // Black piece - can move
    assertEquals(true, piece4.canMove(5, 4)); // 1 space - move 1
    assertEquals(true, piece4.canMove(4, 4)); // 2 spaces - move 1
    assertEquals(true, piece5.canMove(3, 5)); // 1 space - not move 1 ---

    // Black piece - cannot move
    assertEquals(false, piece4.canMove(3, 4)); // 3 spaces
    assertEquals(false, piece5.canMove(2, 5)); // 2 spaces - not move 1
    assertEquals(false, piece5.canMove(5, 5)); // backwards
    assertEquals(false, piece5.canMove(3, 2)); // random spot

    // White piece - can move
    assertEquals(true, piece1.canMove(2, 2)); // 1 space - move 1
    assertEquals(true, piece1.canMove(3, 2)); // 2 spaces - move 1
    assertEquals(true, piece3.canMove(4, 4)); // 1 space - not move 1

    // White piece - cannot move
    assertEquals(false, piece1.canMove(4, 2)); // 3 spaces
    assertEquals(false, piece3.canMove(5, 4)); // 2 spaces - not move 1
    assertEquals(false, piece3.canMove(2, 4)); // backwards
    assertEquals(false, piece3.canMove(5, 1)); // random spot
  }

  /**
   * Test can kill.
   */
  @Test
  public void testCanKill() {
    // Black piece - can kill
    assertEquals(true, piece4.canKill(piece6)); // diagonal left
    assertEquals(true, piece5.canKill(piece3)); // diagonal right

    // Black piece - cannot kill
    assertEquals(false, piece5.canKill(piece7)); // straight ahead
    assertEquals(false, piece5.canKill(piece8)); // backwards diagonal
    assertEquals(false, piece5.canKill(piece1)); // random

    // White piece - can kill
    assertEquals(true, piece1.canKill(piece9)); // diagonal left
    assertEquals(true, piece3.canKill(piece5)); // diagonal right

    // White piece - cannot kill
    assertEquals(false, piece1.canKill(piece10)); // straight ahead
    assertEquals(false, piece3.canKill(piece11)); // backwards diagonal
    assertEquals(false, piece3.canKill(piece4)); // random
  }
}
