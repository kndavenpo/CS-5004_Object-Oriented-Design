package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part I
 *
 * <p>This class represents a snapshot of the Album. The snapshot has a description, a snapshot ID,
 * and a timestamp. The snapshot ID and timestamp are different formats of the datetime that the
 * snapshot was taken.
 */
public class Snapshot {
  private String description;
  private String snapshotId;
  private String timestamp;

  /**
   * Instantiates a new Snapshot.
   *
   * @param description the description
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Snapshot(String description) throws IllegalArgumentException {
    if (description == null || description.length() == 0) {
      throw new IllegalArgumentException("The description cannot be null or empty.");
    }

    this.description = description;
    Date datetime = new Date();
    this.snapshotId = new SimpleDateFormat("yyyy-MM-dd' T 'HH:mm:ss.SS").format(datetime);
    this.timestamp = new SimpleDateFormat("dd-MM-yyyy HH:mm.ss.SS").format(datetime);
  }

  /**
   * Gets the snapshotID.
   *
   * @return the snapshot id
   */
  public String getSnapshotId() {
    return snapshotId;
  }

  /**
   * Gets the timestamp.
   *
   * @return the timestamp
   */
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * Gets the description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }


  // ADD THIS METHOD
  /**
   * Sets description.
   *
   * @param newDescription the new description
   */
  public void setDescription(String newDescription) {
    this.description = newDescription;
  }

  @Override
  public String toString() {
    return "Snapshot ID: " + this.snapshotId
            + "\nTimestamp: " + this.timestamp
            + "\nDescription: " + this.description;
  }
}