package tictactoe;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The type Tic tac toe model.
 */
public class TicTacToeModel implements TicTacToe {
  private Player [][] board;
  private int numMoves;
  private final int BOARD_SIZE = 3;

  /**
   * Instantiates a new Tic tac toe model.
   */
  public TicTacToeModel() {
    this.numMoves = 0; // Count the number of moves

    // The board is specified for a Player X or O and is 3 x 3
    this.board = new Player [BOARD_SIZE][BOARD_SIZE];
  }

  @Override
  public void move(int r, int c) {
    // Cannot move if game is over
    if (isGameOver()) {
      throw new IllegalStateException("The game is over.");
    }
    // Cannot move if row or column is out of bounds
    if (r > 2 || r < 0 || c > 2 || c < 0) {
      throw new IllegalArgumentException("Rows and columns must be 0, 1, or 2.");
    }
    // Cannot move to the spot if a player has already marked it
    if (getMarkAt(r, c) != null) {
      throw new IllegalArgumentException("This spot is already taken.");
    }
    // Mark the spot on the board of the player whose turn it is
    board[r][c] = getTurn();
    // Increment the number of moves
    numMoves++;
  }

  @Override
  public Player getTurn() {
    // X will start on even numbered moves
    if (numMoves % 2 == 0) {
      return Player.X;
    }
    // O will start on odd numbered moves
    return Player.O;
  }

  @Override
  public boolean isGameOver() {
    // Game is over under three conditions: X wins, O wins, or the board is full
    return getWinner() == Player.X || getWinner() == Player.O || numMoves == 9;
  }

  @Override
  public Player getMarkAt(int r, int c) {
    if (r > 2 || r < 0 || c > 2 || c < 0) {
      throw new IllegalArgumentException("Rows and columns must be 0, 1, or 2.");
    } else if (board[r][c] == null) {
      return null;
    }
    return board[r][c];
  }

  /**
   * This method checks if all columns in the given row are marked by the same player.
   *
   * @param r - the row to check
   * @return boolean
   */
  private boolean checkRowWin(int r) {
    for (int i = 1; i < board.length; i++) {
      if (board[r][i] != board[r][i - 1]) {
        return false;
      }
    }
    return true;
  }

  /**
   * This method checks if all rows in the given column are marked by the same player.
   *
   * @param c - the column to check
   * @return boolean
   */
  private boolean checkColWin(int c) {
    for (int i = 1; i < board.length; i++) {
      if (board[i][c] != board[i - 1][c]) {
        return false;
      }
    }
    return true;
  }

  /**
   * This method checks if the left diagonal ([0][0], [1][1], and [2][2]) are all
   * marked by the same player.
   *
   * @return boolean
   */
  private boolean checkLeftDiagonalWin() {
    for (int i = 1; i < board.length; i++) {
      if (board[i][i] != board[i - 1][i - 1]) {
        return false;
      }
    }
    return true;
  }

  /**
   * This method checks if the right diagonal ([0][2], [1][1], and [2][0]) are all
   * marked by the same player.
   *
   * @return boolean
   */
  private boolean checkRightDiagonalWin() {
    if ((board[0][2] != board[1][1]) || (board[0][2] != board[2][0])) {
      return false;
    }
    return true;
  }

  @Override
  public Player getWinner() {
    for (int i = 0; i < board.length; i++) {
      if (checkRowWin(i)) {
        return getMarkAt(i, 0);
      }
      if (checkColWin(i)) {
        return getMarkAt(0, i);
      }
      if (checkLeftDiagonalWin()) {
        return getMarkAt(0, 0 );
      }
      if (checkRightDiagonalWin()) {
        return getMarkAt(2,0);
      }
    }
    return null;
  }

  @Override
  public Player[][] getBoard() {
    // Note: there may be an easier way to copy the array, but good to practice looping.
    Player[][] tempBoard = new Player[BOARD_SIZE][BOARD_SIZE];
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        tempBoard[i][j] = board[i][j];
      }
    }
    return tempBoard;
  }

  @Override
  public String toString() {
    return Arrays.stream(getBoard()).map(
                    row -> " " + Arrays.stream(row).map(
                            p -> p == null ? " " : p.toString()).collect(Collectors.joining(" | ")))
            .collect(Collectors.joining("\n-----------\n"));
  }
}
