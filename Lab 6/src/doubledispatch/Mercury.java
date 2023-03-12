package doubledispatch;

/**
 * Katie Davenport
 * CS 5004 - Lab 6
 *
 * <p>A concrete class that represents the Planet Mercury.
 */
public class Mercury implements IPlanet {
  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}
