package doubledispatch;

/**
 * Katie Davenport
 * CS 5004 - Lab 6
 *
 * <p>Represents a Space Explorer that visits a planet.
 */
public interface ISpaceExplorer {
  /**
   * This method sends the Explorer to the planet Mercury.
   *
   * @param mercury - the plant Mercury
   */
  void visit(Mercury mercury);

  /**
   * This method sends the Explorer to the planet Mars.
   *
   * @param mars - the planet Mars
   */
  void visit(Mars mars);

  /**
   * This method sends the Explorer to the planet Venus.
   *
   * @param venus - the planet Venus
   */
  void visit(Venus venus);

  /**
   * This method adds a visit to the "captain's log" of all visits.
   *
   * @param aPlanet another planet
   */
  default void visit(IPlanet aPlanet) {
    // Default message if the planet does not exist.
    SimulationBuilder.addToLog("Visiting an unknown planet");
  }
}
