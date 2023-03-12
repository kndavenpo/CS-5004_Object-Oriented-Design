package chess;

/**
 * Katie Davenport
 * CS 5004 - Homework 3
 *
 * <p>The type Pawn.
 */
public class Pawn extends ChessPiece {

  /**
   * The constant for the black royal row.
   */
  private static final int blackRoyalRow = 7;
  /**
   * The constant for the white royal row.
   */
  private static final int whiteRoyalRow = 0;

  /**
   * The constant the black pawn's starter row.
   */
  private static final int blackStarterRow = 6;
  /**
   * The constant the white pawn's starter row.
   */
  private static final int whiteStarterRow = 1;


  /**
   * Instantiates a new Pawn.
   *
   * @param row    the row
   * @param column the column
   * @param color  the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Pawn(int row, int column, Color color) throws IllegalArgumentException {
    super(row, column, color);
    if ((color == Color.BLACK && row == blackRoyalRow)
            || (color == Color.WHITE && row == whiteRoyalRow)) {
      throw new IllegalArgumentException("Pawns cannot be created in their color's royal row.");
    }
  }

  @Override
  public boolean canMove(int targetRow, int targetColumn) {
    if (super.canMove(targetRow, targetColumn)) {
      int rowDistance = targetRow - this.row;
      int columnDistance = targetColumn - this.column;
      if (this.getColor() == Color.WHITE) {
        if (row == whiteStarterRow) {
          if ((rowDistance == singleSpace || rowDistance == doubleSpace)
                  && columnDistance == noSpace) {
            return true;
          }
        } else if (rowDistance == singleSpace && columnDistance == noSpace) {
          return true;
        }
        return false;
      } else {
        if (row == blackStarterRow) {
          if ((rowDistance == -singleSpace || rowDistance == -doubleSpace)
                  && columnDistance == noSpace) {
            return true;
          }
        } else if (rowDistance == -singleSpace & columnDistance == noSpace) {
          return true;
        }
        return false;
      }
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece other) {
    if (super.canKill(other)) {
      int rowDistance = other.getRow() - this.row;
      int columnDistance = other.getColumn() - this.column;
      if (this.getColor() == Color.WHITE) {
        if (rowDistance == singleSpace && Math.abs(columnDistance) == singleSpace) {
          return true;
        } else {
          return false;
        }
      } else {
        if (rowDistance == -singleSpace && Math.abs(columnDistance) == singleSpace) {
          return true;
        } else {
          return false;
        }
      }
    } else {
      return false;
    }
  }
}