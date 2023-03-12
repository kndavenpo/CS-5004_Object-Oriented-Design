package artists;

import java.util.Arrays;

/**
 * Katie Davenport
 * CS 5004 - Lab 4
 *
 * <p>The type Actor.
 */
public class Actor extends AbstractArtist {

  private String[] movies;

  /**
   * Instantiates a new Actor.
   *
   * @param name   the name
   * @param age    the age
   * @param genres the genres
   * @param awards the awards
   * @param movies the movies
   */
  public Actor(String name, int age, String [] genres, String [] awards,
               String [] movies) {
    super(name, age, genres, awards);
    this.movies = movies;
  }

  @Override
  public String toString() {
    String string = super.toString();
    return string
            + "I am an ACTOR"
            + "\nI make these types of movies: " + Arrays.toString(super.getGenres())
            + "\nI have acted in these movies: " + Arrays.toString(this.movies);
  }
}
