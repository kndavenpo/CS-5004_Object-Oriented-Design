package model;

import java.util.NoSuchElementException;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>Represents a collection of Shapes to add to an album. All albums allow users to add a shape,
 * remove a shape, and take a snapshot. The snapshot allows users to create multiple pages where
 * each snapshot represents a different page.
 */
public interface Album {
  /**
   * Add shape.
   *
   * @param name  the name
   * @param shape the shape
   * @throws IllegalArgumentException the illegal argument exception
   */
  void addShape(String name, Shape shape) throws IllegalArgumentException;

  /**
   * Remove a shape from the album.
   *
   * @param identifier the identifier of the shape
   * @throws NoSuchElementException the no such element exception
   */
  void removeShape(String identifier) throws NoSuchElementException;

  /**
   * Take a snapshot of the album at a point in time.
   *
   * @param description the description
   */
  void takeSnapshot(String description);
}
