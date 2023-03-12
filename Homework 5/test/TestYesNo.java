import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questionnaire.YesNo;

/**
 * Katie Davenport
 * CS 5004 - Homework 5
 *
 * <p>This is a JUnit test class for the YesNo class.
 */
public class TestYesNo {
  private YesNo yesNo1;
  private YesNo yesNo2;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    this.yesNo1 = new YesNo("Will tomorrow be sunny?", true);
    this.yesNo2 = new YesNo("Did you enjoy dinner?", false);
  }

  /**
   * Test getPrompt method.
   */
  @Test
  public void testGetPrompt() {
    assertEquals("Will tomorrow be sunny?", yesNo1.getPrompt());
    assertEquals("Did you enjoy dinner?", yesNo2.getPrompt());
  }

  /**
   * Test isRequired method.
   */
  @Test
  public void testIsRequired() {
    assertEquals(true, yesNo1.isRequired());
    assertEquals(false, yesNo2.isRequired());
  }

  /**
   * Tests for the answer and getAnswer methods.
   */
  @Test
  public void testAnswerAndGetAnswer() {
    yesNo1.answer("no");
    assertEquals("no", yesNo1.getAnswer());
    yesNo2.answer("No");
    assertEquals("No", yesNo2.getAnswer());
    yesNo1.answer("NO");
    assertEquals("NO", yesNo1.getAnswer());
    yesNo2.answer("yes");
    assertEquals("yes", yesNo2.getAnswer());
    yesNo1.answer("YEs");
    assertEquals("YEs", yesNo1.getAnswer());
    yesNo2.answer("YES");
    assertEquals("YES", yesNo2.getAnswer());
    yesNo1.answer("yES");
    assertEquals("yES", yesNo1.getAnswer());
  }

  /**
   * Tests the equals method.
   */
  @Test
  public void testEquals() {
    assertEquals(false, yesNo1.equals(yesNo2));

    YesNo newYesNo2 = new YesNo("Did you enjoy dinner?",false);
    assertEquals(true, yesNo2.equals(newYesNo2));
  }

  /**
   * Tests the copy method.
   *
   * @throws CloneNotSupportedException the clone not supported exception
   */
  @Test
  public void testCopy() throws CloneNotSupportedException {
    YesNo yesNo1Copy = yesNo1.copy();
    assertEquals(true, yesNo1.equals(yesNo1Copy));

    YesNo yesNo2Copy = yesNo2.copy();
    assertEquals(true, yesNo2.equals(yesNo2Copy));
  }

  /**
   * Tests the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("Question: Will tomorrow be sunny? | Answer:  | Status: true",
            yesNo1.toString());

    yesNo2.answer("yes");
    assertEquals("Question: Did you enjoy dinner? | Answer: yes | Status: false",
            yesNo2.toString());

  }

  // TEST EXCEPTIONS
  /**
   * Tests for an illegal construction of a question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    YesNo nullPrompt;
    nullPrompt = new YesNo(null, true);
  }

  /**
   * Tests for an illegal construction of a question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    YesNo emptyPrompt;
    emptyPrompt = new YesNo("", true);
  }

  /**
   * Tests for an illegal input for the answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAnswer1() {
    yesNo1.answer("maybe");
  }

  /**
   * Tests for an illegal input for the answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAnswer2() {
    yesNo1.answer("");
  }

  /**
   * Tests for an illegal input for the answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAnswer3() {
    yesNo1.answer(null);
  }

  /**
   * Tests for an illegal input for the answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAnswer4() {
    yesNo1.answer("YEsS");
  }

  /**
   * Tests for an illegal input for the answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAnswer5() {
    yesNo1.answer("Nooooo!");
  }

}
