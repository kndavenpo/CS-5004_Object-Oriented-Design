package cs5004.collections;

/**
 * Katie Davenport
 * CS 5004 - Homework 6
 *
 * <p>This is a concrete class that implements the methods in the PriorityQueue interface. This
 * class represents an empty node in the Priority Queue. In addition to the methods in the PQ
 * interface, this class provides toString, equals, and hashcode methods.
 */
public class EmptyNode implements PriorityQueue {
  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
    if (value == null || priority == null || priority < 1 || priority > 10) {
      throw new IllegalArgumentException("Values cannot be null and the priority must "
              + "be between 1 and 10.");
    }
    return new ListPriorityQueue(priority, value, this);
  }

  @Override
  public String peek() throws EmptyPriorityQueueException {
    throw new EmptyPriorityQueueException("You cannot call the peek method on an empty node.");
  }

  @Override
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    throw new EmptyPriorityQueueException("You cannot call the pop method on an empty node.");
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EmptyNode)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}