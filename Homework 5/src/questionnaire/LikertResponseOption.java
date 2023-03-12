package questionnaire;

/**
 * The enum Likert response option.
 */
enum LikertResponseOption {
  /**
   * The Strongly disagree.
   */
  STRONGLY_DISAGREE("Strongly Disagree"),
  /**
   * Disagree likert response option.
   */
  DISAGREE("Disagree"),
  /**
   * The Neutral.
   */
  NEUTRAL("Neither Agree Nor Disagree"),
  /**
   * Agree likert response option.
   */
  AGREE("Agree"),
  /**
   * The Strongly agree.
   */
  STRONGLY_AGREE("Strongly Agree");

  private final String txt;

  LikertResponseOption(String txt) {
    this.txt = txt;
  }

  /**
   * Gets text.
   *
   * @return the text
   */
  String getText() {
    return txt;
  }
}
