package cs5004.collections;

/**
 * Katie Davenport
 * CS 5004 - Homework 6
 *
 * <p>The type Empty priority queue exception.
 */
public class EmptyPriorityQueueException extends Exception {
  /**
   * Instantiates a new Empty priority queue exception.
   *
   * @param message the message
   */
  public EmptyPriorityQueueException(String message) {
    System.err.println(message);
  }
}
