package model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This is the concrete class that implements the Album interface. This class also returns a map
 * of current shapes added by the user and a String representation of all snapshots.
 */
public class AlbumImpl implements IAlbum {

  private Map<String, Shape> shapes;
  private Map<Snapshot, Map> snapshots;

  /**
   * Instantiates a new Album.
   */
  public AlbumImpl() {
    this.shapes = new LinkedHashMap<>();
    this.snapshots = new LinkedHashMap<>();
  }

  @Override
  public void addShape(String name, Shape shape) throws IllegalArgumentException {
    if (shape == null) {
      throw new IllegalArgumentException("The shape cannot be null.");
    }
    if (shapes.containsKey(name) || shapes.containsValue(shape)) {
      throw new IllegalArgumentException("The shape name or shape already exists.");
    }
    shape.setName(name); // exceptions handled in the AbstractShape class
    shapes.put(name, shape);
  }

  @Override
  public void removeShape(String name) throws NoSuchElementException {
    if (!shapes.containsKey(name)) {
      throw new NoSuchElementException("That shape does not exist.");
    }
    shapes.remove(name);
  }

  @Override
  public void takeSnapshot(String description) {
    // Take a snapshot
    // Note: exceptions for a null and empty description are in the Snapshot class
    Snapshot snapshot = new Snapshot(description);

    // Create a list keys from the map of shapes
    ArrayList<String> keyList = new ArrayList<>(shapes.keySet());

    // Create a new map for the shapes that will be saved in the map of snapshots
    Map snapshotShapes = new LinkedHashMap<>();

    // Loop through the existing list of shapes
    for (String identifier : keyList) {
      // Get the shape and create a copy of the shape
      Shape shape = shapes.get(identifier);
      Shape shapeCopy = shape.copy();

      // Add the identifier and the copy of the shape into the new map of shapes
      snapshotShapes.put(identifier, shapeCopy);
    }
    // Add the snapshot and the new list of shapes to the map
    snapshots.put(snapshot, snapshotShapes);
  }

  /**
   * Gets a map of shapes. Keys are a user-defined names and values are shapes.
   *
   * @return the shapes
   */
  public Map getShapes() {
    return shapes;
  }


  // THIS IS NEW - RETURN ACTUAL SNAPSHOTS RATHER THAN TOSTRING
  @Override
  public Map getSnapshots() {
    return snapshots;
  }


  @Override
  public String toString() {
    // Check if there are no snapshots
    if (snapshots.size() == 0) {
      return "No snapshots have been taken.";
    } else {
      // Start the printout
      String printout = "Printing Snapshots";

      // Create a list of snapshots
      ArrayList<Snapshot> keyList = new ArrayList<>(snapshots.keySet());

      // Loop through each snapshot
      for (Snapshot identifier : keyList) {
        // Add the String representation of the snapshot plus an into to the shapes
        printout = printout + "\n\n" + identifier.toString() + "\nShape Information:";

        // Get the map of shapes associated with the snapshot
        shapes = snapshots.get(identifier);

        // Retrieve the list of shapes from the map
        ArrayList<String> keyList2 = new ArrayList<>(shapes.keySet());

        // Check if there are no shapes
        if (keyList2.isEmpty() == true) {
          printout = printout + " There are no shapes.";
        } else {
          // Loop through the list and add the String representation of each shape
          for (String identifier2 : keyList2) {
            printout = printout + "\n" + shapes.get(identifier2).toString();
          }
        }
      }
      return printout;
    }
  }
}