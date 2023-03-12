package tictactoe;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Katie Davenport
 * CS 5004 - Lab 8
 *
 * <p>The type Tic tac toe console controller.
 */
public class TicTacToeConsoleController implements TicTacToeController {

  private Readable in;
  private Appendable out;

  /**
   * Instantiates a new Tic tac toe console controller.
   *
   * @param in  the in
   * @param out the out
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Inputs cannot be null.");
    }
    this.in = in;
    this.out = out;
  }

  @Override
  public void playGame(TicTacToe m) {
    if (m == null) {
      throw new IllegalArgumentException("Null invalid");
    }
    //Make scanner to look for next and scan through
    Scanner scan = new Scanner(in);
    try {
      out.append(m.toString()).append("\n");
      out.append("Enter a move for " + m.getTurn().toString() + ":").append("\n");
      Integer rowInput = null;
      Integer columnInput = null;
      String token = "";
      //While loop for continuous play until q is entered.
      while (!m.isGameOver()) {
        token = scan.next();
        // Break when the player wants to quit
        if (token.equalsIgnoreCase("q")) {
          break;
        }
        try {
          int var = Integer.parseInt(token);
          if (rowInput == null) {
            rowInput = var;
          } else {
            columnInput = var;
            m.move(rowInput - 1, columnInput - 1);
            if (m.isGameOver()) {
              out.append(m.toString()).append("\n");
              out.append("Game is over! ");
              if (m.getWinner() != null) {
                out.append(m.getWinner().toString() + "wins.\n");
              } else {
                out.append("Tie game.\n");
              }
              break;
            }
            out.append(m.toString()).append("\n");
            out.append("Enter a move for " + m.getTurn().toString() + ":").append("\n");
            rowInput = columnInput = null;
          }
        } catch (NumberFormatException e) {
          out.append("this is not a valid number: " + token + "\n");
        } catch (IllegalArgumentException e) {
          out.append("Invalid move" + rowInput + "," + columnInput + "\n");
          rowInput = columnInput = null;
        }
      }
      if (!m.isGameOver() && token.equalsIgnoreCase("q")) {
        out.append("Game quit! Ending game state:\n" + m.toString() + "\n");
      } else if (!m.isGameOver()) {
        throw new IllegalArgumentException("No more inputs");
      }
    } catch (IOException e) {
      throw new IllegalStateException("append failed", e);
    } catch (NoSuchElementException e) {
      throw new IllegalStateException("Failure to read from readable");
    }
    scan.close();
  }
}