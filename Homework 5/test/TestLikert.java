import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questionnaire.Likert;

/**
 * Katie Davenport
 * CS 5004 - Homework 5
 *
 * <p>This is a JUnit test class for the Likert class.
 */
public class TestLikert {

  private Likert likert1;
  private Likert likert2;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    this.likert1 = new Likert("Respond to the statement: I like cabbage.", false);
    this.likert2 = new Likert("Respond to the statement: Today is a great day!", true);
  }

  /**
   * Test the getPrompt method.
   */
  @Test
  public void testGetPrompt() {
    assertEquals("Respond to the statement: I like cabbage.", likert1.getPrompt());
    assertEquals("Respond to the statement: Today is a great day!", likert2.getPrompt());
  }

  /**
   * Test the isRequired method.
   */
  @Test
  public void testIsRequired() {
    assertEquals(false, likert1.isRequired());
    assertEquals(true, likert2.isRequired());
  }

  /**
   * Tests the answer and getAnswer methods.
   */
  @Test
  public void testAnswerAndGetAnswer() {
    likert1.answer("agree");
    assertEquals("agree", likert1.getAnswer());

    likert1.answer("Agree");
    assertEquals("Agree", likert1.getAnswer());

    likert1.answer("Strongly Agree");
    assertEquals("Strongly Agree", likert1.getAnswer());

    likert1.answer("STRONGLY AGREE");
    assertEquals("STRONGLY AGREE", likert1.getAnswer());

    likert1.answer("Neither agree nor disagree");
    assertEquals("Neither agree nor disagree", likert1.getAnswer());

    likert1.answer("DISAGree");
    assertEquals("DISAGree", likert1.getAnswer());

    likert1.answer("StRoNgLy DISAgree");
    assertEquals("StRoNgLy DISAgree", likert1.getAnswer());
  }

  /**
   * Tests the equals method.
   */
  @Test
  public void testEquals() {
    assertEquals(false, likert1.equals(likert2));

    Likert newLikert2 = new Likert("Respond to the statement: Today is a great day!",
            true);
    assertEquals(true, likert2.equals(newLikert2));
  }

  /**
   * Tests the copy method.
   *
   * @throws CloneNotSupportedException the clone not supported exception
   */
  @Test
  public void testCopy() throws CloneNotSupportedException {
    Likert likert1Copy = likert1.copy();
    assertEquals(true, likert1.equals(likert1Copy));

    Likert likert2Copy = likert2.copy();
    assertEquals(true, likert2.equals(likert2Copy));
  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Question: Respond to the statement: I like cabbage. | Answer:  "
            + "| Status: false", likert1.toString());

    likert2.answer("agree");
    assertEquals("Question: Respond to the statement: Today is a great day! | Answer: "
            + "agree | Status: true", likert2.toString());
  }


  // TEST EXCEPTIONS
  /**
   * Tests for an illegal construction of a question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    Likert nullPrompt;
    nullPrompt = new Likert(null, false);
  }

  /**
   * Tests for an illegal construction of a question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    Likert nullPrompt;
    nullPrompt = new Likert("", false);
  }

  /**
   * Tests for an illegal input for the answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAnswer1() {
    likert1.answer("only with bacon.");
  }

  /**
   * Tests for an illegal input for the answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAnswer2() {
    likert1.answer("");
  }

  /**
   * Tests for an illegal input for the answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAnswer3() {
    likert1.answer(null);
  }
}
