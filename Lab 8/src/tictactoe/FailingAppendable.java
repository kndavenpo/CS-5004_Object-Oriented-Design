package tictactoe;

import java.io.IOException;

/**
 * Katie Davenport
 * CS 5004 - Lab 8
 *
 * <p>A mock to simulate a failure to write to the Appendable.
 */
public class FailingAppendable implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("Fail!");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("Fail!");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("Fail!");
  }
}
