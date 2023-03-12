package cs5004.collections;

/**
 * Katie Davenport
 * CS 5004 - Homework 6
 *
 * <p>Represents an immutable PriorityQueue that includes an empty node and 0 to n element nodes.
 */
public interface PriorityQueue {
  /**
   * Checks if the priority queue is empty.
   *
   * @return true if the PQ is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Adds an element to the PQ.
   *
   * @param priority The element's (non-negative) priority.
   * @param value    The element's value.
   * @return A copy of the priority queue containing the new element.
   * @throws IllegalArgumentException the illegal argument exception
   */
  PriorityQueue add(Integer priority, String value) throws IllegalArgumentException;

  /**
   * Gets the value of the highest priority element. If there are multiple elements that have the
   * same priority, gets the value  of the earliest added element.
   *
   * @return The value  of the highest priority element.
   * @throws EmptyPriorityQueueException if the PQ is empty.
   */
  String peek() throws EmptyPriorityQueueException;

  /**
   * Removes the highest priority element.
   *
   * @return A copy of the priority queue without the highest priority element.
   * @throws EmptyPriorityQueueException if the PQ is empty.
   */
  PriorityQueue pop() throws EmptyPriorityQueueException;
}