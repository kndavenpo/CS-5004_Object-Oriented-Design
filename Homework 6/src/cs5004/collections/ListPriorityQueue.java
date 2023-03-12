package cs5004.collections;

import java.util.Objects;

/**
 * Katie Davenport
 * CS 5004 - Homework 6
 *
 * <p>This concrete class implements the methods in the PriorityQueue interface. This class
 * instantiates a ListPriorityQueue, which has a priority, a value, and the rest of the queue.
 * In addition to the methods in the PQ interface, this class creates an empty Priority Queue and
 * provides toString, equals, and hashcode methods.
 */
public class ListPriorityQueue implements PriorityQueue {
  private Integer priority;
  private String value;
  private PriorityQueue rest;

  /**
   * Instantiates a new List Priority Queue where the priority determines the node's order, the
   * value is the value that is stored in the node, and the rest is the PQ to which the new node
   * will be added.
   */
  public ListPriorityQueue(Integer priority, String value, PriorityQueue rest) {
    if (priority == null || value == null || rest == null) {
      throw new IllegalArgumentException("Data cannot be null.");
    }
    this.priority = priority;
    this.value = value;
    this.rest = rest;
  }

  @Override
  public Boolean isEmpty() {
    if (this.toString() == "") {
      return true;
    }
    return false;
  }

  @Override
  public PriorityQueue add(Integer priority, String value) throws IllegalArgumentException {
    if (value == null || priority == null || priority < 1 || priority > 10) {
      throw new IllegalArgumentException("Values cannot be null and the priority must "
              + "be between 1 and 10.");
    }
    if (this.priority >= priority) {
      return new ListPriorityQueue(this.priority, this.value, this.rest.add(priority, value));
    } else {
      return new ListPriorityQueue(priority, value, this);
    }
  }

  @Override
  public String peek() throws EmptyPriorityQueueException {
    return this.value;
  }

  @Override
  public PriorityQueue pop() throws EmptyPriorityQueueException {
    return this.rest;
  }

  /**
   * Creates and returns an empty PriorityQueue.
   */
  public static PriorityQueue createEmpty() {
    return new EmptyNode();
  }

  @Override
  public String toString() {
    return "(Priority: " + this.priority.toString() + ", Value:" + this.value  + ")"
            + this.rest.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (! (o instanceof PriorityQueue)) {
      return false;
    }
    PriorityQueue other = (PriorityQueue) o;
    return this.toString().equals(other.toString());
  }

  @Override
  public int hashCode() {
    return Objects.hash(priority, value, rest);
  }
}