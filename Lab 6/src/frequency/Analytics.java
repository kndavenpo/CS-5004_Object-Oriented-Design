package frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * Katie Davenport
 * CS 5004 - Lab 6
 *
 * <p>This class provides a single class method that takes a String message as an input and returns
 * a frequency count of the words in the message.
 */
public class Analytics {

  /**
   * Word frequency map.
   *
   * @param message the message
   * @return the map
   */
  public static Map<String, Double> wordFrequency(String message) {
    if (message == null || message.equals("")) {
      return null;
    }

    // Create a list of the words with punctuation removed
    message = message.replaceAll("\\p{Punct}","");

    // Split the message into words, capitalize, and add words to the array.
    String[] words = message.toUpperCase().split("\\p{Blank}");

    // Create an empty hashmap
    Map<String, Double> map = new HashMap<>();

    //Create a count of the words
    int count = words.length;

    // Add words to the map as keys and the count of words in the string as values
    for (String word : words) {
      if (map.containsKey(word)) {
        Double val = map.get(word) + 1;
        map.put(word, val);
      } else {
        map.put(word, 1.0);
      }
    }
    // Convert the word counts to a frequency by dividing by the word count
    map.forEach((k, v) -> map.put(k, v / count));
    return map;
  }
}