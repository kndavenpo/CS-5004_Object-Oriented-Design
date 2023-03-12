package artists;

import java.util.Arrays;

/**
 * Katie Davenport
 * CS 5004 - Lab 4
 *
 * <p>The type Musician.
 */
public class Musician extends AbstractArtist {

  private String company;
  private String album;

  /**
   * Instantiates a new Musician.
   *
   * @param name             the name
   * @param age              the age
   * @param genres           the genres
   * @param awards           the awards
   * @param currentAlbum     the current album
   * @param recordingCompany the recording company
   */
  public Musician(String name, int age, String [] genres, String [] awards,
                  String currentAlbum, String recordingCompany) {
    super(name, age, genres, awards);
    this.album = currentAlbum;
    this.company = recordingCompany;
  }

  @Override
  public String toString() {
    String string = super.toString();
    return string
            + "I am an MUSICIAN"
            + "\nI make these types of music: " + Arrays.toString(super.getGenres())
            + "\nMy current album is: " + this.album
            + "\nMy recording company is: " + this.company;
  }

}
