import static org.junit.Assert.assertEquals;

import artists.Poet;
import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS5004 - Lab 4
 *
 * <p>This is a JUnit test class for the Poet class. It tests the methods that are not already
 * tested in the IArtistTest class. These include: getAge(), getName(), getGenres(), and
 * getGenresAsSingleString(). The test for getGenresAsSingleString() also tests the getGenres()
 * method. The testCreatedInstances() method in the IArtist test class also tests the toString()
 * method.
 */
public class PoetTest {
  /**
   * The Genre 1.
   */
  String [] genre1 = {"Autobiographical Fiction"};
  /**
   * The Genre 2.
   */
  String [] genre2 = {""};
  /**
   * The Awards 1.
   */
  String [] awards1 = {"Pulitzer"};

  /**
   * The Maya 1.
   */
  Poet maya1;
  /**
   * The Maya 2.
   */
  Poet maya2;
  /**
   * The Maya 3.
   */
  Poet maya3;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    maya1 = new Poet("Maya Angelou", 86, genre1, awards1, "Random House");
    maya2 = new Poet("Maya Angelou", 86, null, awards1, "Random House");
    maya3 = new Poet("Maya Angelou", 86, genre2, awards1, "Random House");
  }

  /**
   * Test get age.
   */
  @Test
  public void testGetAge() {
    assertEquals(86, maya1.getAge());
  }

  /**
   * Test get name.
   */
  @Test
  public void testGetName() {
    assertEquals("Maya Angelou", maya1.getName());
  }

  /**
   * Test get genres as single string.
   */
  @Test
  public void testGetGenresAsSingleString() {
    assertEquals("[Autobiographical Fiction]", maya1.getGenresAsSingleString());
    assertEquals("", maya2.getGenresAsSingleString());
    assertEquals("[]", maya3.getGenresAsSingleString());
  }
}
