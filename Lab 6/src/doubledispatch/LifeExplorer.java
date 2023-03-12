package doubledispatch;

/**
 * Katie Davenport
 * CS 5004 - Lab 6
 *
 * <p>A concrete class that represents a Life Explorer that explores a planet for life.
 */
public class LifeExplorer implements ISpaceExplorer {
  @Override
  public void visit(Mercury mercury) {
    SimulationBuilder.addToLog("Landing on Mercury...exploring for life");
  }

  @Override
  public void visit(Mars mars) {
    SimulationBuilder.addToLog("Landing on Mars...exploring for life");
  }

  @Override
  public void visit(Venus venus) {
    SimulationBuilder.addToLog("Landing on Venus...exploring life");
  }
}
