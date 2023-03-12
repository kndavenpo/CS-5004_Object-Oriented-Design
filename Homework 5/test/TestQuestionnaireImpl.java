import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import questionnaire.Likert;
import questionnaire.Question;
import questionnaire.QuestionnaireImpl;
import questionnaire.ShortAnswer;
import questionnaire.YesNo;

/**
 * Katie Davenport
 * CS 5004 - Homework 5
 *
 * <p>This is a JUnit test class for the QuestionnaireImpl class.
 */

public class TestQuestionnaireImpl {
  private QuestionnaireImpl questionnaire1;
  private QuestionnaireImpl questionnaire2;
  private QuestionnaireImpl questionnaire3;
  private YesNo question1;
  private YesNo question2;
  private ShortAnswer question3;
  private ShortAnswer question4;
  private Likert question5;
  private Likert question6;

  /**
   * Set up tests.
   */
  @Before
  public void setUp() {
    question1 = new YesNo("Do you have a reservation?", true);
    question1.answer("Yes");
    question2 = new YesNo("Would you like a booth?", false);
    question2.answer("no");
    question3 = new ShortAnswer("How many in your party?", true);
    question4 = new ShortAnswer("What would you like to drink?", true);
    question4.answer("A gimlet please.");
    question5 = new Likert("Our service was excellent", false);

    // Required and optional questions. Not all required questions have a response
    this.questionnaire1 = new QuestionnaireImpl();
    questionnaire1.addQuestion("question1", question1);
    questionnaire1.addQuestion("question2", question2);
    questionnaire1.addQuestion("question3", question3);

    // Empty questionnaire
    this.questionnaire2 = new QuestionnaireImpl();

    // Questionnaire with multiple optional questions. Some have responses.
    this.questionnaire3 = new QuestionnaireImpl();
    questionnaire3.addQuestion("question2", question2);
    questionnaire3.addQuestion("question4", question4);
    questionnaire3.addQuestion("question5", question5);
  }

  // METHOD TESTS

  /**
   * Test the getQuestionHash method.
   */
  @Test
  public void testGetQuestionHash() {
    // multiple questions
    assertEquals("[Question: Do you have a reservation? | Answer: Yes | Status: true, "
                    + "Question: Would you like a booth? | Answer: no | Status: false, "
                    + "Question: How many in your party? | Answer:  | Status: true]",
            questionnaire1.getQuestionHash().values().toString());

    // no questions
    assertEquals("[]",
            questionnaire2.getQuestionHash().values().toString());
  }

  /**
   * Test the addQuestion method.
   */
  @Test
  public void testAddQuestion() {
    // Add 1 question
    int sizeBefore = questionnaire1.getQuestionHash().size();
    questionnaire1.addQuestion("question4", question4);
    assertEquals(sizeBefore + 1, questionnaire1.getQuestionHash().size());

    // Add multiple questions
    int sizeBefore2 = questionnaire2.getQuestionHash().size();
    questionnaire2.addQuestion("question1", question1);
    questionnaire2.addQuestion("question2", question2);
    assertEquals(sizeBefore2 + 2, questionnaire2.getQuestionHash().size());
  }

  /**
   * Test the removeQuestion method.
   */
  @Test
  public void testRemoveQuestion() {
    // Remove question
    int sizeBefore = questionnaire1.getQuestionHash().size();
    questionnaire1.removeQuestion("question3");
    assertEquals(sizeBefore - 1, questionnaire1.getQuestionHash().size());

    // Add multiple questions
    int sizeBefore2 = questionnaire3.getQuestionHash().size();
    questionnaire3.removeQuestion("question2");
    questionnaire3.removeQuestion("question4");
    assertEquals(sizeBefore2 - 2, questionnaire3.getQuestionHash().size());
  }

  /**
   * Test the getQuestion method with the order that it was added.
   */
  @Test
  public void testGetQuestionIntInput() {
    assertEquals("Question: Do you have a reservation? | Answer: Yes | Status: true",
            questionnaire1.getQuestion(1).toString());

    assertEquals("Question: Would you like a booth? | Answer: no | Status: false",
            questionnaire1.getQuestion(2).toString());

    assertEquals("Question: How many in your party? | Answer:  | Status: true",
            questionnaire1.getQuestion(3).toString());
  }

  /**
   * Test the getQuestion method with the String identifier input.
   */
  @Test
  public void testGetQuestionStringInput() {
    assertEquals("Question: Do you have a reservation? | Answer: Yes | Status: true",
            questionnaire1.getQuestion("question1").toString());

    assertEquals("Question: Would you like a booth? | Answer: no | Status: false",
            questionnaire1.getQuestion("question2").toString());

    assertEquals("Question: How many in your party? | Answer:  | Status: true",
            questionnaire1.getQuestion("question3").toString());
  }

  /**
   * Test the requiredQuestion method.
   */
  @Test
  public void testRequiredQuestion() {
    List<Question> requiredQuestions1 = questionnaire1.getRequiredQuestions();
    assertEquals("[Question: Do you have a reservation? | Answer: Yes | Status: true, "
                    + "Question: How many in your party? | Answer:  | Status: true]",
            requiredQuestions1.toString());

    List<Question> requiredQuestions2 = questionnaire3.getRequiredQuestions();
    assertEquals("[Question: What would you like to drink? | Answer: A gimlet please. "
                    + "| Status: true]",
            requiredQuestions2.toString());
  }

  /**
   * Test the optionalQuestion method.
   */
  @Test
  public void testOptionalQuestion() {
    List<Question> optionalQuestions1 = questionnaire1.getOptionalQuestions();
    assertEquals("[Question: Would you like a booth? | Answer: no | Status: false]",
            optionalQuestions1.toString());

    List<Question> optionalQuestions2 = questionnaire3.getOptionalQuestions();
    assertEquals("[Question: Would you like a booth? | Answer: no | Status: false, "
                    + "Question: Our service was excellent | Answer:  | Status: false]",
            optionalQuestions2.toString());
  }

  /**
   * Test the IsComplete method.
   */
  @Test
  public void testIsComplete() {
    assertEquals(false, questionnaire1.isComplete());
    assertEquals(true, questionnaire3.isComplete());
  }

  /**
   * Test the GetResponses method.
   */
  @Test
  public void testGetResponses() {
    assertEquals("[Yes, no, ]", questionnaire1.getResponses().toString());
    assertEquals("[no, A gimlet please., ]", questionnaire3.getResponses().toString());
  }

  /**
   * Test the Filter method.
   */
  @Test
  public void testFilter() {
    // Required questions for first questionnaire
    assertEquals("Question: Do you have a reservation?\n\n"
            + "Answer: Yes\n\n"
            + "Question: How many in your party?\n\n"
            + "Answer: ", questionnaire1.filter(Question::isRequired).toString());

    // Required questions for second questionnaire
    assertEquals("Question: What would you like to drink?\n\n"
                    + "Answer: A gimlet please. ",
            questionnaire3.filter(Question::isRequired).toString());

    // Required questions for second questionnaire
    assertEquals("Question: What would you like to drink?\n\n"
                    + "Answer: A gimlet please. ",
            questionnaire3.filter(Question::isRequired).toString());
  }

  /**
   * Test the sort method.
   */
  @Test
  public void testSort() {
    // Return a hashmap of the questions
    Map<String, Question> questionHash = questionnaire1.getQuestionHash();

    // Create a list of questions
    List<Question> questionList = new ArrayList<>(questionHash.values());

    // Create a comparator
    TestComparator x = new TestComparator();

    // Sort the questions by the comparator
    Collections.sort(questionList, x);

    // Get the first question in the list and test that it is what we expect based on the comparator
    Question firstQuestion = questionList.get(0);
    assertEquals("Question: How many in your party? | Answer:  | Status: true",
            firstQuestion.toString());
  }

  /**
   * Test the sort method.
   */
  @Test
  public void testFold() {
    // Return a hashmap of the questions
    Map<String, Question> questionHash = questionnaire1.getQuestionHash();

    // Create a collection of questions
    Collection<Question> questions = questionHash.values();

    // Apply a BiFunction that calculates the sum of the length of the answers in the questionnaire
    BiFunction<Question, Integer, Integer> stringBF = (a, b) -> b + a.getAnswer().length();
    Integer sumLength = questionnaire1.fold(stringBF, 0);

    assertEquals(5, sumLength, 0.001);
  }

  /**
   * Test the toString method. This is also a test of the fold method.
   */
  @Test
  public void testToStringAndFold() {
    assertEquals("Question: Do you have a reservation?\n\n" + "Answer: Yes\n\n"
            + "Question: Would you like a booth?\n\n" + "Answer: no\n\n"
            + "Question: How many in your party?\n\n" + "Answer: ", questionnaire1.toString());

    assertEquals("Question: Would you like a booth?\n\n" + "Answer: no\n\n"
                    + "Question: What would you like to drink?\n\n" + "Answer: A gimlet please.\n\n"
                    + "Question: Our service was excellent\n\n" + "Answer: ",
            questionnaire3.toString());
  }

  /// TESTS FOR ILLEGAL PARAMETER VALUES
  /**
   * Tests for an illegal call of the addQuestion method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAddQuestion1() {
    // Add a new question with a null identifier
    questionnaire1.addQuestion(null, question6);
  }

  /**
   * Tests for an illegal call of the addQuestion method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAddQuestion2() {
    // Add a new question with an empty string identifier
    questionnaire1.addQuestion("", question6);
  }

  /**
   * Tests for an illegal call of the addQuestion method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAddQuestion3() {
    // Add a new question with a null question
    questionnaire1.addQuestion("question7", null);
  }

  /**
   * Tests for an illegal call of the addQuestion method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAddQuestion4() {
    // Add an identifier already there
    questionnaire1.addQuestion("question1", question6);
  }

  /**
   * Tests for an illegal call of the addQuestion method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalAddQuestion5() {
    // Add a question already there
    questionnaire1.addQuestion("question7", question1);
  }

  /**
   * Tests for an illegal call of the removeQuestion method.
   */
  @Test(expected = NoSuchElementException.class)
  public void illegalRemoveQuestion() {
    questionnaire1.removeQuestion("question7");
  }

  /**
   * Tests for an illegal call of the getQuestion method.
   */
  @Test(expected = NoSuchElementException.class)
  public void illegalGetQuestion() {
    questionnaire1.getQuestion("question7");
  }

  /**
   * Tests for an illegal call of the getQuestion method with the String identifier parameter.
   */
  @Test(expected = NoSuchElementException.class)
  public void illegalGetQuestionString() {
    questionnaire1.getQuestion("question7");
  }

  /**
   * Tests for an illegal call of the getQuestion method with the int order parameter.
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void illegalGetQuestionInt1() {
    questionnaire1.getQuestion(0);
  }

  /**
   * Tests for an illegal call of the getQuestion method with the int order parameter.
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void illegalGetQuestionInt2() {
    questionnaire1.getQuestion(-10);
  }

  /**
   * Tests for an illegal call of the getQuestion method with the int order parameter.
   */
  @Test(expected = IndexOutOfBoundsException.class)
  public void illegalGetQuestionInt3() {
    questionnaire1.getQuestion(15);
  }

  /**
   * Tests for an illegal call of the filter method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalFilter() {
    questionnaire1.filter(null);
  }

  /**
   * Tests for an illegal call of the sort method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalSort() {
    questionnaire1.sort(null);
  }

  /**
   * Tests for an illegal call of the fold method.
   */
  @Test(expected = IllegalArgumentException.class)
  public void illegalFold1() {
    questionnaire1.fold(null, 0);
  }

  // ADD - illegal call of the fold method where the BiFunction is null.

}
