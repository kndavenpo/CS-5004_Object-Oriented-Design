package chess;

/**
 * Katie Davenport
 * CS 5004 - Homework 3
 *
 * <p>The type Rook.
 */
public class Rook extends ChessPiece {
  /**
   * Instantiates a new Rook.
   *
   * @param row    the row
   * @param column the column
   * @param color  the color
   */
  public Rook(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int targetRow, int targetColumn) {
    if (super.canMove(targetRow, targetColumn)) {
      int rowDistance = targetRow - this.row;
      int columnDistance = targetColumn - this.column;
      if ((rowDistance == noSpace && Math.abs(columnDistance) > noSpace)
              || (Math.abs(rowDistance) > noSpace && columnDistance == noSpace)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  @Override
  public boolean canKill(ChessPiece other) {
    if (super.canKill(other)) {
      int rowDistance = other.getRow() - this.row;
      int columnDistance = other.getColumn() - this.column;
      if ((rowDistance == noSpace && Math.abs(columnDistance) > noSpace)
              || (Math.abs(rowDistance) > noSpace && columnDistance == noSpace)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}
