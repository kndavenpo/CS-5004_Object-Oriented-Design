import java.util.Comparator;

import questionnaire.Question;

/**
 * Katie Davenport
 * CS 5004 - Homework 5
 *
 * <p>This is a comparator created to test the Questionnaire sort method.
 */
public class TestComparator implements Comparator<Question> {

  /**
   * This method compares two questions based on the length of their response.
   *
   * @param question1 the first object to be compared.
   * @param question2 the second object to be compared.
   * @return int
   */
  public int compare(Question question1, Question question2) {
    String answer1 = question1.getAnswer();
    String answer2 = question2.getAnswer();
    if (answer1.length() == answer2.length()) {
      return 0;
    }
    else if (answer1.length() > answer2.length()) {
      return 1;
    }
    return -1;
  }
}