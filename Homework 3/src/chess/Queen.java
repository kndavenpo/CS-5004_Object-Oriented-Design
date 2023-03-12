package chess;

/**
 * Katie Davenport
 * CS 5004 - Homework 3
 *
 * <p>The type Queen.
 */
public class Queen extends ChessPiece {
  /**
   * Instantiates a new Queen.
   *
   * @param row    the row
   * @param column the column
   * @param color  the color
   */
  public Queen(int row, int column, Color color) {
    super(row, column, color);
  }

  @Override
  public boolean canMove(int targetRow, int targetColumn) {
    if (super.canMove(targetRow, targetColumn)) {
      int rowDistance = targetRow - this.row;
      int columnDistance = targetColumn - this.column;
      if (((rowDistance + columnDistance == noSpace) && (rowDistance - columnDistance != noSpace)
              || (rowDistance + columnDistance != noSpace)
              && (rowDistance - columnDistance == noSpace))
              || ((rowDistance == noSpace && Math.abs(columnDistance) > noSpace)
              || (Math.abs(rowDistance) > noSpace && columnDistance == noSpace))) {
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
      if (((rowDistance + columnDistance == noSpace) && (rowDistance - columnDistance != noSpace)
              || (rowDistance + columnDistance != noSpace)
              && (rowDistance - columnDistance == noSpace))
              || ((rowDistance == noSpace && Math.abs(columnDistance) > noSpace)
              || (Math.abs(rowDistance) > noSpace && columnDistance == noSpace))) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}