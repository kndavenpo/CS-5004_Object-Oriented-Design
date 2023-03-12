package chess;

/**
 * Katie Davenport
 * CS 5004 - Homework 3
 *
 * <p>This abstract class represents a chess piece. The piece has a given row, column, and color.
 * This class can return the row, column and color for the piece. The class return a boolean to
 * indicate a piece can move to a given cell ignoring any obstructions. The class also returns a
 * boolean to indicate if a piece can kill another piece based on its location on the board; it
 * ignores its color.
 */
public abstract class ChessPiece implements IChessPiece {

  /**
   * The row of the piece.
   */
  protected int row;
  /**
   * The column of the piece.
   */
  protected int column;

  /**
   * The color of the piece.
   */
  protected Color color;

  /**
   * The constant for the minimum row and column value.
   */
  protected static final int minRowColumn = 0;

  /**
   * The constant for the maximum row and column value.
   */
  protected static final int maxRowColumn = 7;

  /**
   * The constant for a move of no space.
   */
  protected static final int noSpace = 0;

  /**
   * The constant for a move of a single space.
   */
  protected static final int singleSpace = 1;
  /**
   * The constant for a move of a double space.
   */
  protected static final int doubleSpace = 2;


  /**
   * Instantiates a new Chess piece.
   *
   * @param row    the row
   * @param column the column
   * @param color  the color
   * @throws IllegalArgumentException the illegal argument exception for cell values
   */
  public ChessPiece(int row, int column, Color color) throws IllegalArgumentException {
    if (row < minRowColumn
            || row > maxRowColumn
            || column < minRowColumn
            || column > maxRowColumn) {
      throw new IllegalArgumentException("The row and column must be between 0 and 7.");
    }
    this.row = row;
    this.column = column;
    this.color = color;
  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int getColumn() {
    return this.column;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * Returns a boolean to indicate if this piece can move to a target cell.
   *
   * @param targetRow    the row of the target cell
   * @param targetColumn the column of the target cell
   * @return the boolean
   * @throws IllegalArgumentException if the target cell is not on the board
   */
  public boolean canMove(int targetRow, int targetColumn) throws IllegalArgumentException {
    if (targetRow < minRowColumn
            || targetRow  > maxRowColumn
            || targetColumn < minRowColumn
            || targetColumn > maxRowColumn) {
      throw new IllegalArgumentException("The row and column of the target cell must be between"
              + " 0 and 7.");
    } else {
      return true;
    }
  }

  /**
   * Returns a boolean to indicate if this piece can kill the other piece.
   *
   * @param other    the other piece being targeted to kill
   * @return the boolean
   */
  public boolean canKill(ChessPiece other) {
    if (this.getColor() == other.getColor()
    int rowDistance = other.getRow() - this.row;        //
    int columnDistance = other.getColumn() - this.column;   //
    ) {
      return false;
    } else {
      return true;
    }
  }
}
