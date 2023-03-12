import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import questionnaire.ShortAnswer;
import questionnaire.YesNo;

/**
 * Katie Davenport
 * CS 5004 - Homework 5
 *
 * <p>This is a JUnit test class for the ShortAnswer class.
 */
public class TestShortAnswer {

  private ShortAnswer shortAnswer1;
  private ShortAnswer shortAnswer2;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    // required question
    this.shortAnswer1 = new ShortAnswer("What is your favorite thing about your pet?",
            false);
    this.shortAnswer2 = new ShortAnswer("Where should we go on vacation?", true);
  }

  /**
   * Test getPrompt method.
   */
  @Test
  public void testGetPrompt() {
    assertEquals("What is your favorite thing about your pet?", shortAnswer1.getPrompt());
    assertEquals("Where should we go on vacation?", shortAnswer2.getPrompt());
  }

  /**
   * Test isRequired method.
   */
  @Test
  public void testIsRequired() {

    assertEquals(false, shortAnswer1.isRequired());
    assertEquals(true, shortAnswer2.isRequired());
  }

  /**
   * Tests for the answer and getAnswer methods.
   */
  @Test
  public void testAnswerAndGetAnswer() {
    shortAnswer1.answer("She loves to have her belly rubbed in the morning.");
    assertEquals("She loves to have her belly rubbed in the morning.",
            shortAnswer1.getAnswer());

    shortAnswer2.answer("Let's go to Hawaii!");
    assertEquals("Let's go to Hawaii!",
            shortAnswer2.getAnswer());
  }

  /**
   * Tests the equals method.
   */
  @Test
  public void testEquals() {
    assertEquals(false, shortAnswer1.equals(shortAnswer2));

    ShortAnswer newShortAnswer2 = new ShortAnswer("Where should we go on vacation?",
            true);
    assertEquals(true, shortAnswer2.equals(newShortAnswer2));
  }

  /**
   * Test copy.
   *
   * @throws CloneNotSupportedException the clone not supported exception
   */
  @Test
  public void testCopy() throws CloneNotSupportedException {
    ShortAnswer shortAnswer1Copy = shortAnswer1.copy();
    assertEquals(shortAnswer1, shortAnswer1Copy);

    ShortAnswer shortAnswer2Copy = shortAnswer2.copy();
    assertEquals(shortAnswer2, shortAnswer2Copy);
  }

  /**
   * Test to string.
   */
  @Test
  public void testToString() {
    shortAnswer1.answer("She loves to have her belly rubbed in the morning.");
    assertEquals("Question: What is your favorite thing about your pet? | "
            + "Answer: She loves to have her belly rubbed in the morning. | "
            + "Status: false", shortAnswer1.toString());

    shortAnswer2.answer("Let's go to Hawaii!");
    assertEquals("Question: Where should we go on vacation? | Answer: Let's go to Hawaii! "
            + "| Status: true", shortAnswer2.toString());
  }

  // TEST EXCEPTIONS
  /**
   * Tests for an illegal construction of a question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup1() {
    ShortAnswer emptyPrompt;
    emptyPrompt = new ShortAnswer("", true);
  }

  /**
   * Tests for an illegal construction of a question.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSetup2() {
    ShortAnswer nullPrompt;
    nullPrompt = new ShortAnswer(null, true);
  }

  /**
   * Tests for an illegal input for the answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAnswer1() {
    shortAnswer1.answer("My cat’s name is Tutu. Tutu is a girl and she is about 3 years old. "
            + "My favorite thing bout her is that she really loves tot have here belly rubbed "
            + "first thing in the morning. It is absolutely adorable! She meows and meows and "
            + "then when I come over she lays on her side and stretches out as far as she can "
            + "with her belly exposed. She just really wants me to rub her belly! When I do she "
            + "purrs. When I go off to do my homework and get my coffee I can tell that she gets "
            + "a bit sad.");
  }

  /**
   * Tests for an illegal input for the answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAnswer2() {
    shortAnswer1.answer("");
  }

  /**
   * Tests for an illegal input for the answer method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAnswer3() {
    shortAnswer1.answer(null);
  }
}
