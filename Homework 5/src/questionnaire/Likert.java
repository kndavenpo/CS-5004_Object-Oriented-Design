package questionnaire;

import java.util.ArrayList;
import java.util.List;

/**
 * Katie Davenport
 * CS 5004 - Homework 5
 *
 * <p>This class represents a question that can be answered on a fixed, 5-point Likert scale:
 * Strongly Agree, Agree, Neither Agree not Disagree, Disagree, Strongly Disagree.
 */
public class Likert extends AbstractQuestion {
  private static List<String> responses = new ArrayList<String>();

  /**
   * Instantiates a new Likert question.
   *
   * @param prompt the prompt
   * @param status the status
   */
  public Likert(String prompt, boolean status) {
    super(prompt, status);
  }

  @Override
  public void answer(String answer) throws IllegalArgumentException {
    if (answer == null) {
      throw new IllegalArgumentException("The answer cannot be null.");
    }
    responses.add(LikertResponseOption.STRONGLY_AGREE.getText().toUpperCase());
    responses.add(LikertResponseOption.AGREE.getText().toUpperCase());
    responses.add(LikertResponseOption.NEUTRAL.getText().toUpperCase());
    responses.add(LikertResponseOption.DISAGREE.getText().toUpperCase());
    responses.add(LikertResponseOption.STRONGLY_DISAGREE.getText().toUpperCase());

    if (!responses.contains(answer.toUpperCase()) || answer == null) {
      throw new IllegalArgumentException("The answer must be on the Likert scale.");
    }
    this.answer = answer;
  }

  /**
   * This method creates a copy of the likert question.
   *
   * @return Likert
   */
  public Likert copy() {
    Likert copy = new Likert(this.prompt, this.status);
    if (this.answer == "") {
      return copy;
    } else {
      copy.answer(this.answer);
      return copy;
    }
  }
}