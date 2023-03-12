package doubledispatch;

/**
 * Katie Davenport
 * CS 5004 - Lab 6
 *
 * <p>A concrete class that represents a Terrain Explorer that navigates and maps the planet.
 */
public class TerrainExplorer implements ISpaceExplorer {
  @Override
  public void visit(Mercury mercury) {
    SimulationBuilder.addToLog("Navigating and mapping Mercury");
  }

  @Override
  public void visit(Mars mars) {
    SimulationBuilder.addToLog("Navigating and mapping Mars");
  }

  @Override
  public void visit(Venus venus) {
    SimulationBuilder.addToLog("Navigating and mapping Venus");
  }
}
