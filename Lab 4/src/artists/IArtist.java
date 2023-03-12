package artists;

/**
 *  Katie Davenport
 *  CS 5004 - Lab 4
 *
 * <p>This interface represents an artist. All types of artists can receive an award and get an
 * award.
 */
public interface IArtist {
  /**
   * Receive award.
   *
   * @param award the award
   */
  void receiveAward(String award);

  /**
   * Get awards string [ ].
   *
   * @return the string [ ]
   */
  String [] getAwards();

}
