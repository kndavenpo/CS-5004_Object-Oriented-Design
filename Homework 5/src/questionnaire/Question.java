package questionnaire;

/**
 * Katie Davenport
 * CS 5004 - Homework 5
 *
 * <p>This interface represents a question on a questionnaire. All questions allow users to answer
 * the question, create a copy of itself, and write a String representation of itself. Questions
 * can also answer the question prompt, if the question is required, and this response.
 */
public interface Question {
  /**
   * This method answers the question text.
   *
   * @return the prompt
   */
  String getPrompt();

  /**
   * This method answers if the question is required or optional: true means the question is
   * required, false means the question is optional.
   *
   * @return the string
   */
  boolean isRequired();

  /**
   * This method inputs an answer to the question.
   *
   * @param answer the answer
   */
  void answer(String answer);

  /**
   * Gets answer.
   *
   * @return the answer
   */
  String getAnswer();

  /**
   * This method copies the question.
   *
   * @return the question
   */
  Question copy();
}
