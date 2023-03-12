package tictactoe;

import java.io.InputStreamReader;

/**
 * Katie Davenport
 * CS 5004 - Lab 8
 *
 * <p>Run a Tic Tac Toe game interactively on the console.
 */
public class Main {
  /**
   * Run a Tic Tac Toe game interactively on the console.
   */
  public static void main(String[] args) {
    new TicTacToeConsoleController(new InputStreamReader(System.in),
        System.out).playGame(new TicTacToeModel());
  }
}
