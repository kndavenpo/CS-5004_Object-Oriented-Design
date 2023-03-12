package chess;

/**
 * The type King.
 */
public class King extends ChessPiece {
  /**
   * Katie Davenport
   * CS 5004 - Homework 3
   *
   * <p>Instantiates a new King.
   *
   * @param row    the row
   * @param column the column
   * @param color  the color
   */
  public King(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int targetRow, int targetColumn) {
    if (super.canMove(targetRow, targetColumn)) {
      int rowDistance = targetRow - this.row;             //
      int columnDistance = targetColumn - this.column;    //
      if ((rowDistance == noSpace && Math.abs(columnDistance) == singleSpace)
              || (Math.abs(rowDistance) == singleSpace
              && columnDistance == noSpace)
              || (Math.abs(rowDistance) == singleSpace
              && Math.abs(columnDistance) == singleSpace)) {
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
      super.rowDistance
      super.rowDistance
      if ((rowDistance == noSpace && Math.abs(columnDistance) == singleSpace)
              || (Math.abs(rowDistance) == singleSpace && columnDistance == noSpace)
              || (Math.abs(rowDistance) == singleSpace
              && Math.abs(columnDistance) == singleSpace)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}
