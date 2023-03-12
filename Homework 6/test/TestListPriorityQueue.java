import static org.junit.Assert.assertEquals;

import cs5004.collections.EmptyPriorityQueueException;
import cs5004.collections.ListPriorityQueue;
import cs5004.collections.PriorityQueue;
import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS 5004 - Homework 6
 *
 * <p>This is a JUnit test class for the ListPriorityQueue class.
 */
public class TestListPriorityQueue {
  private PriorityQueue list1;
  private PriorityQueue list2;
  private PriorityQueue list3;
  private PriorityQueue list4;
  private PriorityQueue list5;
  private PriorityQueue list6;
  private PriorityQueue list7;
  private PriorityQueue list8;
  private PriorityQueue list9;
  private PriorityQueue list10;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    this.list1 = ListPriorityQueue.createEmpty();
    this.list2 = list1.add(1, "priority1Order1");
    this.list3 = list2.add(4, "priority4Order1");
    this.list4 = list3.add(2, "priority2Order1");
    this.list5 = list4.add(4, "priority4Order2");
    this.list6 = list5.add(1, "priority1Order2");
    this.list7 = list6.add(1, "priority1Order3");

    this.list8 = ListPriorityQueue.createEmpty();
    this.list9 = list8.add(1, "priority1Order1");
    this.list10 = list9.add(4, "priority4Order1");
  }

  // TEST METHODS
  /**
   * Test the createEmpty method.
   */
  @Test
  public void testCreateEmpty() {
    assertEquals("", list1.toString());
  }

  /**
   * Test the add method.
   */
  @Test
  public void testAdd() {
    // Add one element node using the toString method
    assertEquals("(Priority: 1, Value:priority1Order1)", list2.toString());

    // Add many element nodes using the toString method. Check that the order is correct
    assertEquals("(Priority: 4, Value:priority4Order1)"
            + "(Priority: 4, Value:priority4Order2)"
            + "(Priority: 2, Value:priority2Order1)"
            + "(Priority: 1, Value:priority1Order1)"
            + "(Priority: 1, Value:priority1Order2)"
            + "(Priority: 1, Value:priority1Order3)", list7.toString());

    // Add many element nodes using the toString method. Check that the order is correct
    assertEquals("(Priority: 4, Value:priority4Order1)"
            + "(Priority: 4, Value:priority4Order2)"
            + "(Priority: 2, Value:priority2Order1)"
            + "(Priority: 1, Value:priority1Order1)", list5.toString());
  }

  /**
   * Test the isEmpty method.
   */
  @Test
  public void testIsEmpty() {
    // Empty list
    assertEquals(true, list1.isEmpty());

    // Add an element node to the list
    assertEquals(false, list2.isEmpty());

    // Add multiple element nodes to the list
    assertEquals(false, list5.isEmpty());
  }

  /**
   * Test the peek method.
   *
   * @throws EmptyPriorityQueueException the empty priority queue exception
   */
  @Test
  public void testPeek() throws EmptyPriorityQueueException {
    // Test list2
    assertEquals("priority1Order1", list2.peek());
    // Check that the list remains unchanged after the call to peek()
    assertEquals("(Priority: 1, Value:priority1Order1)", list2.toString());

    // Test list5
    assertEquals("priority4Order1", list5.peek());
    // Check that the list remains unchanged after the call to peek()
    assertEquals("(Priority: 4, Value:priority4Order1)"
            + "(Priority: 4, Value:priority4Order2)"
            + "(Priority: 2, Value:priority2Order1)"
            + "(Priority: 1, Value:priority1Order1)", list5.toString());
  }

  /**
   * Test the pop method.
   *
   * @throws EmptyPriorityQueueException the empty priority queue exception
   */
  @Test
  public void testPop() throws EmptyPriorityQueueException {
    // Test list2. This should be a copy of list2 without the first node.
    assertEquals("", list2.pop().toString());
    // Check that the list remains unchanged after the call to pop()
    assertEquals("(Priority: 1, Value:priority1Order1)", list2.toString());

    // Test list5. This should be a copy of list2 without the first node.
    assertEquals("(Priority: 4, Value:priority4Order2)"
            + "(Priority: 2, Value:priority2Order1)"
            + "(Priority: 1, Value:priority1Order1)", list5.pop().toString());
    // Check that the list remains unchanged after the call to pop()
    assertEquals("(Priority: 4, Value:priority4Order1)"
            + "(Priority: 4, Value:priority4Order2)"
            + "(Priority: 2, Value:priority2Order1)"
            + "(Priority: 1, Value:priority1Order1)", list5.toString());

    // Check a list that we pop twice.
    PriorityQueue testList = list7.pop().pop();
    assertEquals("(Priority: 2, Value:priority2Order1)"
            + "(Priority: 1, Value:priority1Order1)"
            + "(Priority: 1, Value:priority1Order2)"
            + "(Priority: 1, Value:priority1Order3)", testList.toString());
  }

  /**
   * Test the toString method.
   *
   * @throws EmptyPriorityQueueException the empty priority queue exception
   */
  @Test
  public void testToString() throws EmptyPriorityQueueException {
    // Test an empty PQ
    assertEquals("", list1.toString());

    // Test a PQ with several element nodes (Note: already tested in other method tests)
    assertEquals("(Priority: 4, Value:priority4Order1)"
            + "(Priority: 4, Value:priority4Order2)"
            + "(Priority: 2, Value:priority2Order1)"
            + "(Priority: 1, Value:priority1Order1)"
            + "(Priority: 1, Value:priority1Order2)", list6.toString());
  }

  /**
   * Test the equals method.
   */
  @Test
  public void testEquals() {
    // Test an empty PQ
    assertEquals(true, list1.equals(list8));

    // Test non-empty PQ
    assertEquals(true, list2.equals(list9));

    // Test non-empty PQ
    assertEquals(true, list3.equals(list10));
  }

  /**
   * Test the hashCode method.
   */
  @Test
  public void testHashCode() {
    // Create a shallow copy and test if the hashCodes are equal.
    PriorityQueue listA = list1;
    assertEquals(listA.hashCode(), list1.hashCode());

    PriorityQueue listB = list7;
    assertEquals(listB.hashCode(), list7.hashCode());
  }


  /// TEST ILLEGAL PARAMETER VALUES
  /**
   * Tests for an illegal call of the add method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalAdd1() {
    // Test: priority < 1
    PriorityQueue list1 = ListPriorityQueue.createEmpty();
    list1.add(0, "dog");
  }

  /**
   * Tests for an illegal call of the add method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalAdd2() {
    // Test: priority > 10
    PriorityQueue list1 = ListPriorityQueue.createEmpty();
    list1.add(11000, "dog");
  }

  /**
   * Tests for an illegal call of the add method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalAdd3() {
    // Test: value is null
    PriorityQueue list1 = ListPriorityQueue.createEmpty();
    list1.add(5, null);
  }

  /**
   * Tests for an illegal call of the peek method.
   *
   * @throws EmptyPriorityQueueException the empty priority queue exception
   */
  @Test(expected = EmptyPriorityQueueException.class)
  public void testEmptyPeek() throws EmptyPriorityQueueException {
    PriorityQueue list1 = ListPriorityQueue.createEmpty();
    list1.peek();
  }

  /**
   * Tests for an illegal call of the pop method.
   *
   * @throws EmptyPriorityQueueException the empty priority queue exception
   */
  @Test(expected = EmptyPriorityQueueException.class)
  public void testEmptyPop() throws EmptyPriorityQueueException {
    PriorityQueue list1 = ListPriorityQueue.createEmpty();
    list1.pop();
  }
}