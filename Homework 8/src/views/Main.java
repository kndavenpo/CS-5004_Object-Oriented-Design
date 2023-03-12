package views;

import java.io.IOException;
import java.util.ArrayList;

import model.AlbumImpl;

/**
 * The type Main.
 */
public class Main {
  /**
   * Katie Davenport
   * CS 5004 - Homework 8 - Part II
   *
   * <p>The entry point of application.
   *
   * @param args the input arguments
   * @throws IOException the io exception
   */
  public static void main(String[] args) throws IOException {
    // Parse the command line arguments
    // Create an ArrayList of the command-line arguments
    ArrayList<String> input = new ArrayList<>();
    for (String arg : args) {
      input.add(arg);
    }

    // Get filename: required  - ADD IN EXCEPTION HANDLING
    int fileNameIndex = input.indexOf("-in") + 1; //
    String fileName = input.get(fileNameIndex);

    // Get view type: required - ADD IN EXCEPTION HANDLING
    int viewTypeIndex1 = input.indexOf("-v") + 1;
    int viewTypeIndex2 = input.indexOf("-view") + 1;
    String viewType;
    if (viewTypeIndex1 > 0) {
      viewType = input.get(viewTypeIndex1);
    } else {
      viewType = input.get(viewTypeIndex2);
    }

    // Get output type: optional (only relevant for html view)
    int outputTypeIndex = input.indexOf("-out") + 1;
    String outputFile;
    if (outputTypeIndex > 0) {
      outputFile = input.get(outputTypeIndex);
    } else {
      outputFile = " ";
    }

    // Get max coordinates: optional - ADD IN THE DEFAULT VALUES.
    ArrayList<Integer> maxCoordinates = new ArrayList<>();
    maxCoordinates.add(1); // Add a default value in the beginning so the ArrayList is not empty
    for (String each : input) {
      if (each.matches("[0-9]+")) {
        Integer eachInt = Integer.valueOf(each);
        maxCoordinates.add(eachInt);
      }
    }

    // Add in default values
    if (maxCoordinates.size() == 1) {
      maxCoordinates.add(1000);
      maxCoordinates.add(1000);
    }

    // Instantiate the controller
    Controller controller = new Controller(viewType, maxCoordinates, fileName, outputFile);
    controller.go();

    AlbumImpl model = controller.getModel();
    // Smoke tests
    System.out.println(model.toString());
    System.out.println(controller.getFilename());
    System.out.println(controller.getType());
    System.out.println(controller.getOutputFile());
  }
}