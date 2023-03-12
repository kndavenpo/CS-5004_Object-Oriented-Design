package doubledispatch;

/**
 * Katie Davenport
 * CS 5004 - Lab 6
 *
 * <p>A concrete class that represents the Planet Mars.
 */
public class Mars implements IPlanet {

  @Override
  public void accept(ISpaceExplorer explorer) {
    explorer.visit(this);
  }
}
