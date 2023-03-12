package questionnaire;

import java.util.Objects;

/**
 * Katie Davenport
 * CS 5004 - Homework 5
 *
 * <p>This is the abstract superclass of all Question concrete classes. It implements the
 * Question interface and serves as the "repository" of reuse code for certain common services.
 */
public abstract class AbstractQuestion implements Question {

  /**
   * The question prompt.
   */
  protected String prompt;
  /**
   * The status: required (true) or optional (false).
   */
  protected boolean status;
  /**
   * The answer to the question.
   */
  protected String answer;


  /**
   * Abstract Question constructor.
   * This class cannot be instantiated, but this creation mechanism ensures the superclass
   * portion of all subclasses is appropriately initialized with a question prompt and status.
   *
   * @param prompt the prompt
   * @param status the status
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractQuestion(String prompt, boolean status) throws IllegalArgumentException {
    if (prompt == null || prompt.length() == 0) {
      throw new IllegalArgumentException("The question prompt cannot be null.");
    }
    this.prompt = prompt;
    this.status = status;
    this.answer = "";
  }

  public String getPrompt() {
    return this.prompt;
  }

  public boolean isRequired() {
    return this.status;
  }

  public String getAnswer() {
    return this.answer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractQuestion that = (AbstractQuestion) o;
    return status == that.status && prompt.equals(that.prompt) && answer.equals(that.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prompt, status, answer);
  }

  @Override
  public String toString() {
    return "Question: " + this.getPrompt() + " | Answer: " + this.getAnswer()
            + " | Status: " + Boolean.toString(this.isRequired());
  }
}
