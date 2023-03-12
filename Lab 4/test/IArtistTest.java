import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import artists.Actor;
import artists.IArtist;
import artists.Musician;
import artists.Poet;
import org.junit.Before;
import org.junit.Test;

/**
 * Katie Davenport
 * CS5004 - Lab 4
 *
 * <p>This is a JUnit test for all concrete Artist classes: Actor, Musician, and Poet.
 */
public class IArtistTest {

  /**
   * The Genre 1.
   */
  String [] genre1 = {"Action", "SciFi", "Drama"};
  /**
   * The Genre 2.
   */
  String [] genre2 = {"Rock", "Rock-Soul"};
  /**
   * The Genre 3.
   */
  String [] genre3 = {"Comedy", "Romantic Comedy"};
  /**
   * The Genre 4.
   */
  String [] genre4 = {"R&B", "Pop", "Rap"};
  /**
   * The Genre 5.
   */
  String [] genre5 = {"Autobiographical Fiction"};

  /**
   * The Awards.
   */
  String [] awards = {"Academy Award", "Golden Globe"};
  /**
   * The Awards 2.
   */
  String [] awards2 = {"Pulitzer"};
  /**
   * The Awards 3.
   */
  String [] awards3 = {"Emmy", "People's Choice"};
  /**
   * The Awards 4.
   */
  String [] awards4 = {"Grammy", "American Music Award"};
  /**
   * The Awards 5.
   */
  String [] awards5 = {"Grammy", "Billboard"};

  /**
   * The Movies.
   */
  String [] movies = {"Glory", "Flight", "Training Day", "Book of Eli", "Fences"};
  /**
   * The Movies 3.
   */
  String [] movies3 = {"Bridesmaids", "Tammy", "Life of the Party", "Ghostbusters"};

  /**
   * The Denzel.
   */
  IArtist denzel;
  /**
   * The Melissa.
   */
  IArtist melissa;
  /**
   * The Musician.
   */
  IArtist musician;
  /**
   * The Musician 2.
   */
  IArtist musician2;
  /**
   * The Poet.
   */
  IArtist poet;

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  @Before
  public void setUp() throws Exception {
    denzel = new Actor("Denzel Washington", 67, genre1, awards, movies);
    melissa = new Actor("Melissa McCarthy", 52, genre3, awards3, movies3);

    musician = new Musician("Bruce Springsteen", 73, genre2, awards4,
            "Only the Strong Survive", "Columbia Records");

    musician2 = new Musician("Lizzo", 34, genre4, awards5,
            "Special", "Atlantic Records");
    poet = new Poet("Maya Angelou", 86, genre5, awards2, "Random House");
  }

  /**
   * Test created instances.
   */
  @Test
  public void testCreatedInstances() {
    String test1 = "My name is Denzel Washington\n"
            + "My age is 67\n"
            + "I am an ACTOR\n"
            + "I make these types of movies: [Action, SciFi, Drama]\n"
            + "I have acted in these movies: [Glory, Flight, Training Day, Book of Eli, Fences]";
    assertEquals(test1, denzel.toString());

    String test2 = "My name is Melissa McCarthy\n"
            + "My age is 52\n"
            + "I am an ACTOR\n"
            + "I make these types of movies: [Comedy, Romantic Comedy]\n"
            + "I have acted in these movies: [Bridesmaids, Tammy, Life of the Party, Ghostbusters]";
    assertEquals(test2, melissa.toString());

    String test3 = "My name is Bruce Springsteen\n"
            + "My age is 73\n"
            + "I am an MUSICIAN\n"
            + "I make these types of music: [Rock, Rock-Soul]\n"
            + "My current album is: Only the Strong Survive\n"
            + "My recording company is: Columbia Records";
    assertEquals(test3, musician.toString());

    String test5 = "My name is Lizzo\n"
            + "My age is 34\n"
            + "I am an MUSICIAN\n"
            + "I make these types of music: [R&B, Pop, Rap]\n"
            + "My current album is: Special\n"
            + "My recording company is: Atlantic Records";
    assertEquals(test5, musician2.toString());

    String test6 = "My name is Maya Angelou\n"
            + "My age is 86\n"
            + "I am an POET\n"
            + "I make these types of poems: [Autobiographical Fiction]\n"
            + "My publishing company is: Random House";
    assertEquals(test6, poet.toString());
  }

  /**
   * Test receive award.
   */
  @Test
  public void testReceiveAward() {
    String [] testAwards = {"Pulitzer", "Tony"};
    poet.receiveAward("Tony");
    assertTrue(Arrays.equals(poet.getAwards(),testAwards));
  }

  /**
   * Test get awards.
   */
  @Test
  public void testGetAwards() {
    String [] testAwards = {"Academy Award", "Golden Globe"};
    assertTrue(Arrays.equals(denzel.getAwards(), testAwards));
  }

  /**
   * Test bad age.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadAge() {
    IArtist a = new Musician("Bruce Springsteen", 129, genre2, awards4,
            "Only the Strong Survive", "Columbia Records");
  }

  /**
   * Test bad age 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadAge2() {
    IArtist a = new Musician("Bruce Springsteen", -1, genre2, awards4,
            "Only the Strong Survive", "Columbia Records");
  }

  /**
   * Test bad name.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadName() {
    IArtist a = new Musician(null, 10, genre2, awards4,
            "Only the Strong Survive", "Columbia Records");
  }

  /**
   * Test bad name 2.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testBadName2() {
    IArtist a = new Musician("", 10, genre2, awards4,
            "Only the Strong Survive", "Columbia Records");
  }
}
