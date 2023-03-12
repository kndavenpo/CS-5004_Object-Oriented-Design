package chess;

/**
 * Katie Davenport
 * CS 5004 - Homework 3
 *
 * <p>This interface represents a chess piece. It is the super-type for any type of chess piece on
 * a traditional chess board.
 */
public interface IChessPiece {

  /**
   * Gets the row of the piece.
   *
   * @return the row
   */
  public int getRow();


  /**
   * Gets the column of the piece.
   *
   * @return the column
   */
  public int getColumn();


  /**
   * Gets the color of the piece.
   *
   * @return the color
   */
  public Color getColor();


  /**
   * Returns a boolean to indicate if the piece can move to the given cell.
   *
   * @param row    the row
   * @param column the column
   * @return the boolean
   */
  public boolean canMove(int row, int column);

  /**
   * Returns a boolean to indicate if this piece can kill another piece.
   *
   * @param piece the piece
   * @return the boolean
   */
  public boolean canKill(ChessPiece piece);
}
