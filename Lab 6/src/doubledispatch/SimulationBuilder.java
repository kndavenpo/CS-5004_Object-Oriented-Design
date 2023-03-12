package doubledispatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Katie Davenport
 * CS 5004 - Lab 6
 *
 * <p>This class serves as a simulation engine for the Explorers to visit the Planet. The class
 * creates the planets and explorers, logs visits to planets, and returns the log.
 */
public class SimulationBuilder {

  private static final List<String> logs = new ArrayList<>();

  /**
   * Create and return an instance of the planet requested (case-insensitive). Return null if the
   * type of planet does not exist.
   *
   * @param name - the name of the planet type
   * @return the planet
   */
  public static IPlanet createPlanet(String name) {
    if (name.equalsIgnoreCase("Mars")) {
      return new Mars();
    } else if (name.equalsIgnoreCase("Mercury")) {
      return new Mercury();
    } else if (name.equalsIgnoreCase("Venus")) {
      return new Venus();
    } else {
      return null;
    }
  }

  /**
   * Create and return an instance of the space explorer requested (case-insensitive). Return null
   * if the type of explorer does not exist.
   *
   * @param name - the name of the explorer type
   * @return the space explorer
   */
  public static ISpaceExplorer createExplorer(String name) {
    if (name.equalsIgnoreCase("LifeExplorer")) {
      return new LifeExplorer();
    } else if (name.equalsIgnoreCase("TerrainExplorer")) {
      return new TerrainExplorer();
    } else {
      return null;
    }
  }

  /**
   * Logs a visit to the "captain's log" of all planetary exploration.
   *
   * @param message - the message that is added to the log
   */
  public static void addToLog(String message) {
    logs.add(message);
  }

  /**
   * Return the simulation log.
   *
   * @return the simulation log
   */
  public static List<String> getSimulationLog() {
    return logs;
  }
}
