package tictactoe;

/**
 * The enum Player.
 */
public enum Player {
  /**
   * X player.
   */
  X,
  /**
   * O player.
   */
  O;

  @Override
  public String toString() {
    if (this == Player.X) {
      return "X";
    } else {
      return "O";
    }
  }
}
