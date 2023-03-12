package artists;

import java.util.Arrays;

/**
 * Katie Davenport
 * CS 5004 - Lab 4
 *
 * <p>The type Poet.
 */
public class Poet extends AbstractArtist {

  private String publisher;

  /**
   * Instantiates a new Poet.
   *
   * @param name      the name
   * @param age       the age
   * @param genres    the genres
   * @param awards    the awards
   * @param publisher the publisher
   */
  public Poet(String name, int age, String [] genres, String [] awards,
              String publisher) {
    super(name, age, genres, awards);
    this.publisher = publisher;
  }

  @Override
  public String toString() {
    String string = super.toString();
    return string
            + "I am an POET"
            + "\nI make these types of poems: " + Arrays.toString(super.getGenres())
            + "\nMy publishing company is: " + this.publisher;
  }




}
