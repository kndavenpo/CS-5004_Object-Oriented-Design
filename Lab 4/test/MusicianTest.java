import static org.junit.Assert.assertEquals;

import artists.Musician;
import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS5004 - Lab 4
 *
 * <p>This is a JUnit test class for the Musician class. It tests the methods that are not already
 * tested in the IArtistTest class. These include: getAge(), getName(), getGenres(), and
 * getGenresAsSingleString(). The test for getGenresAsSingleString() also tests the getGenres()
 * method. The testCreatedInstances() method in the IArtist test class also tests the toString()
 * method.
 */
public class MusicianTest {
  /**
   * The Genre 1.
   */
  String [] genre1 = {"R&B", "Pop", "Rap"};
  /**
   * The Genre 2.
   */
  String [] genre2 = {""};
  /**
   * The Awards 1.
   */
  String [] awards1 = {"Grammy", "Billboard"};


  /**
   * The Lizzo 1.
   */
  Musician lizzo1;
  /**
   * The Lizzo 2.
   */
  Musician lizzo2;
  /**
   * The Lizzo 3.
   */
  Musician lizzo3;


  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    lizzo1 = new Musician("Lizzo", 34, genre1, awards1,
            "Special", "Atlantic Records");
    lizzo2 = new Musician("Lizzo", 34, null, awards1,
            "Special", "Atlantic Records");
    lizzo3 = new Musician("Lizzo", 34, genre2, awards1,
            "Special", "Atlantic Records");
  }

  /**
   * Test get age.
   */
  @Test
  public void testGetAge() {
    assertEquals(34, lizzo1.getAge());
  }

  /**
   * Test get name.
   */
  @Test
  public void testGetName() {
    assertEquals("Lizzo", lizzo1.getName());
  }

  /**
   * Test get genres as single string.
   */
  @Test
  public void testGetGenresAsSingleString() {
    assertEquals("[R&B, Pop, Rap]", lizzo1.getGenresAsSingleString());
    assertEquals("", lizzo2.getGenresAsSingleString());
    assertEquals("[]", lizzo3.getGenresAsSingleString());
  }
}