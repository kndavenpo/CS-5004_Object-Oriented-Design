package questionnaire;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Katie Davenport
 * CS 5004 - Homework 5
 *
 * <p>This is the concrete class that implements the methods in the Questionnaire interface. This
 * class also returns the linked hashmap that contains the question identifier and the question.
 */
public class QuestionnaireImpl implements Questionnaire {

  private String identifier;
  private Question q;
  private Map<String, Question> questionHash;

  /**
   * Instantiates a new Questionnaire with a linked hashmap where the key is the string identifier
   * and the value is the question.
   */
  public QuestionnaireImpl() {
    this.questionHash = new LinkedHashMap<>();
  }


  /**
   * Gets question hash.
   *
   * @return the question hash
   */
  public Map<String, Question> getQuestionHash() {
    return this.questionHash;
  }

  @Override
  public void addQuestion(String identifier, Question q) throws IllegalArgumentException {
    if (identifier == null || identifier.length() == 0 || q == null
            || questionHash.containsKey(identifier) || questionHash.containsValue(q)) {
      throw new IllegalArgumentException("The identifier cannot be null or an empty string. "
              + "The question cannot be null. In addition, we cannot add an identifier or a "
              + "question that is already in the questionnaire to preserve uniqueness.");
    }
    questionHash.put(identifier, q);
  }

  @Override
  public void removeQuestion(String identifier) throws NoSuchElementException {
    if (!questionHash.containsKey(identifier)) {
      throw new NoSuchElementException("No such element exists.");
    }
    questionHash.remove(identifier);
  }

  @Override
  public Question getQuestion(int num) throws IndexOutOfBoundsException {
    if (num > questionHash.size() || num < 1) {
      throw new IndexOutOfBoundsException("No such element exists.");
    }
    // Adjust the order to an index
    int index = num - 1;

    // Convert the questions to a list and return the question at the index
    List<Question> questions = new ArrayList<Question>(questionHash.values());
    return questions.get(index);
  }

  @Override
  public Question getQuestion(String identifier) throws NoSuchElementException {
    if (!questionHash.containsKey(identifier)) {
      throw new NoSuchElementException("No such element exists.");
    }
    return questionHash.get(identifier);
  }

  @Override
  public List<Question> getRequiredQuestions() {
    // Create a collection of questions
    Collection<Question> questions = questionHash.values();

    // Filter only required questions
    List<Question> requiredQuestions = questions.stream().filter(Question
            -> Question.isRequired() == true).collect(Collectors.toList());

    return requiredQuestions;
  }

  @Override
  public List<Question> getOptionalQuestions() {
    // Create a collection of questions
    Collection<Question> questions = questionHash.values();

    // Filter only optional questions
    List<Question> optionalQuestions = questions.stream().filter(Question
            -> Question.isRequired() == false).collect(Collectors.toList());

    return optionalQuestions;
  }

  @Override
  public boolean isComplete() {
    // Get a list of required questions
    List<Question> requiredQuestions = getRequiredQuestions();

    // Check that all required questions have a response (are not empty)
    List<Question> requiredResponses = requiredQuestions.stream().filter(Question
            -> Question.getAnswer() != "").collect(Collectors.toList());
    return requiredQuestions.size() == requiredResponses.size();
  }

  @Override
  public List<String> getResponses() {
    // Create a collection of questions
    Collection<Question> questions = questionHash.values();

    // Map questions to responses
    List<String> responses = questions.stream().map(q
            -> q.getAnswer()).collect(Collectors.toList());
    return responses;
  }

  @Override
  public Questionnaire filter(Predicate<Question> pq) throws IllegalArgumentException {
    if (pq == null) {
      throw new IllegalArgumentException("The Predicate cannot be null.");
    }

    // Return a list of the key identifiers
    List<String> keyList = new ArrayList<>(questionHash.keySet());

    // Create a new questionnaire
    Questionnaire filteredQuestionnaire = new QuestionnaireImpl();

    // loop through the key identifier list and add a copy of the corresponding question to the
    // new questionnaire
    for (String identifier:keyList) {
      if (pq.test(questionHash.get(identifier))) {
        filteredQuestionnaire.addQuestion( identifier, questionHash.get(identifier).copy());
      }
    }
    return filteredQuestionnaire;
  }

  @Override
  public void sort(Comparator<Question> comp) throws IllegalArgumentException {
    if (comp == null) {
      throw new IllegalArgumentException("The Comparator cannot be null.");
    }

    // Sort the hashmap by the comparator
    questionHash = questionHash.entrySet().stream().sorted(Map.Entry.comparingByValue(comp))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a,
                    LinkedHashMap::new));
  }

  @Override
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) throws IllegalArgumentException {
    if (bf == null || seed == null) {
      throw new IllegalArgumentException("The BiFunction and seed cannot be null.");
    }

    // Create a list of the questions
    List<Question> questionList = new ArrayList<>(questionHash.values());

    // Loop through the list and apply the BiFunction to the seed value
    for (Question q:questionList) {
      seed = bf.apply(q, seed);
    }
    return seed;
  }

  @Override
  public String toString() {
    // Create a collection of questions
    Collection<Question> questions = questionHash.values();

    // Apply a BiFunction to the list to generate the String representation of the questions
    BiFunction<Question, String, String> stringBF = (a,b) -> b + "Question: " + a.getPrompt()
            + "\n\n" + "Answer: " + a.getAnswer() + "\n\n";

    String summary = this.fold(stringBF, "");

    // Strip the spaces off after the blanks and return the summary
    return summary.strip() + " ";
  }
}
