package doubledispatch;

/**
 * Katie Davenport
 * CS 5004 - Lab 6
 *
 * <p>Represents a Planet that accepts an explorer.
 */
public interface IPlanet {
  /**
   * This method accepts the explorer to the planet.
   *
   * @param explorer the explorer
   */
  void accept(ISpaceExplorer explorer);
}
