package questionnaire;

/**
 * Katie Davenport
 * CS 5004 - Homework 5
 *
 * <p>This class represents a question that has a short answer response.
 */
public class ShortAnswer extends AbstractQuestion {

  /**
   * Instantiates a new ShortAnswer question.
   *
   * @param prompt the prompt
   * @param status the status
   */
  public ShortAnswer(String prompt, boolean status) {
    super(prompt, status);
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer == null || answer.length() > 280 || answer.length() == 0) {
      throw new IllegalArgumentException("The answer cannot be null, empty, or greater than 280 "
              + "characters.");
    }
    this.answer = answer;
  }

  /**
   * This method creates a copy of the ShortAnswer question.
   *
   * @return ShortAnswer
   */
  public ShortAnswer copy() {
    ShortAnswer copy = new ShortAnswer(this.prompt, this.status);
    if (this.answer == "") {
      return copy;
    } else {
      copy.answer(this.answer);
      return copy;
    }
  }
}
