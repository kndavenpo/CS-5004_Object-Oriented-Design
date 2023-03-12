package questionnaire;

/**
 * Katie Davenport
 * CS 5004 - Homework 5
 *
 * <p>This class represents a question that has a yes or no response.
 */
public class YesNo extends AbstractQuestion {
  private static String no = "no";
  private static String yes = "yes";

  /**
   * Instantiates a new YesNo question.
   *
   * @param prompt the prompt
   * @param status the status
   */
  public YesNo(String prompt, boolean status) {
    super(prompt, status);
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer == null || (!answer.equalsIgnoreCase(no)
            && (!answer.equalsIgnoreCase(yes)))) {
      throw new IllegalArgumentException("The answer must be yes or no.");
    }
    this.answer = answer;
  }

  /**
   * This method creates a copy of the YesNo question.
   *
   * @return YesNo
   */
  public YesNo copy() {
    YesNo copy = new YesNo(this.prompt, this.status);
    if (this.answer == "") {
      return copy;
    } else {
      copy.answer(this.answer);
      return copy;
    }
  }
}
