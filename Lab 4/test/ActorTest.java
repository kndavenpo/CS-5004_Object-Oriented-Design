import static org.junit.Assert.assertEquals;

import artists.Actor;
import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS5004 - Lab 4
 *
 * <p>This is a JUnit test class for the Actor class. It tests the methods that are not already
 * tested in the IArtistTest class. These include: getAge(), getName(), getGenres(), and
 * getGenresAsSingleString(). The test for getGenresAsSingleString() also tests the getGenres()
 * method. The testCreatedInstances() method in the IArtist test class also tests the toString()
 * method.
 */
public class ActorTest {
  /**
   * The Genre 1.
   */
  String [] genre1 = {"Action", "SciFi", "Drama"};
  /**
   * The Genre 2.
   */
  String [] genre2 = {""};

  /**
   * The Awards.
   */
  String [] awards = {"Academy Award", "Golden Globe"};

  /**
   * The Movies.
   */
  String [] movies = {"Glory", "Flight", "Training Day", "Book of Eli", "Fences"};

  /**
   * The Denzel 1.
   */
  Actor denzel1;
  /**
   * The Denzel 2.
   */
  Actor denzel2;
  /**
   * The Denzel 3.
   */
  Actor denzel3;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    denzel1 = new Actor("Denzel Washington", 67, genre1, awards, movies);
    denzel2 = new Actor("Denzel Washington", 67, null, awards, movies);
    denzel3 = new Actor("Denzel Washington", 67, genre2, awards, movies);
  }

  /**
   * Test get age.
   */
  @Test
  public void testGetAge() {
    assertEquals(67, denzel1.getAge());
  }

  /**
   * Test get name.
   */
  @Test
  public void testGetName() {
    assertEquals("Denzel Washington", denzel1.getName());
  }

  /**
   * Test get genres as single string.
   */
  @Test
  public void testGetGenresAsSingleString() {
    assertEquals("[Action, SciFi, Drama]", denzel1.getGenresAsSingleString());
    assertEquals("", denzel2.getGenresAsSingleString());
    assertEquals("[]", denzel3.getGenresAsSingleString());
  }
}