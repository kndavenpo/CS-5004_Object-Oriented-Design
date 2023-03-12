package views;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import model.AlbumImpl;
import model.Color;
import model.Oval;
import model.Point;
import model.Rectangle;
import model.Shape;
import model.Snapshot;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part II
 *
 * <p>The controller.
 */
class Controller {
  private final String filename;
  private final ArrayList<Integer> maxCoordinates;
  /**
   * The Model.
   */
  AlbumImpl model;
  /**
   * The View.
   */
  GraphicalView graphicalView;

  /**
   * The View.
   */
  WebView webView;

  /**
   * The Type.
   */
  String type;
  /**
   * The Output file.
   */
  String outputFile;

  /**
   * Instantiates a new Controller.
   *
   * @param viewType       the view type
   * @param maxCoordinates the max coordinates
   * @param filename       the filename
   * @param outputFile     the output file
   */
  public Controller(String viewType, ArrayList<Integer> maxCoordinates, String filename,
                    String outputFile) {
    this.type = viewType;
    this.model = null;
    this.filename = filename;
    this.maxCoordinates = maxCoordinates;
    this.outputFile = outputFile;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public String getType() {
    return this.type;
  }

  /**
   * Gets model.
   *
   * @return the model
   */
  public AlbumImpl getModel() {
    return this.model;
  }

  /**
   * Gets filename.
   *
   * @return the filename
   */
  public String getFilename() {
    return this.filename;
  }

  /**
   * Output file string.
   *
   * @return the string
   */
  public String getOutputFile() {
    return this.outputFile;
  }

  /**
   * Read file array list.
   *
   * @return the array list
   * @throws FileNotFoundException the file not found exception
   */
  public ArrayList<String> readFile() throws FileNotFoundException {
    java.io.File file = new java.io.File(filename);
    Scanner input = new Scanner(file);
    ArrayList<String> fileContents = new ArrayList<>();
    while (input.hasNext()) {
      fileContents.add(input.nextLine());
    }
    return fileContents;
  }

  /**
   * Write html.
   *
   * @param htmlString the html string
   * @throws IOException the io exception
   */
  public void writeHtml(String htmlString) throws IOException {
    File file = new File(filename);
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(file));
      bw.write(htmlString);
      bw.close();
    } catch (IOException e) {
     e.printStackTrace();
    }
  }

  /**
   * Parse the file contents and create an album.
   *
   * @throws FileNotFoundException the file not found exception
   */
  public void createAlbum() throws FileNotFoundException {
    ArrayList<String> fileContents = this.readFile();
    AlbumImpl album = new AlbumImpl();
    for (String line : fileContents) {
      String[] line1 = line.split(" ");
      ArrayList<String> line2 = new ArrayList<String>(Arrays.asList(line1));
      if (line2.get(0).equals("shape")) {
        // Parse elements from line
        String name = line2.get(1);
        int x = Integer.parseInt(line2.get(3));
        int y = Integer.parseInt(line2.get(4));
        int width = Integer.parseInt(line2.get(5));
        int height = Integer.parseInt(line2.get(6));
        int r = Integer.parseInt(line2.get(7));
        int b = Integer.parseInt(line2.get(8));
        int g = Integer.parseInt(line2.get(9));
        // Create shapes
        if (line2.get(2).equals("rectangle")) {
          Rectangle shape = new Rectangle(new Point(x, y), new Color(r, b, g), width, height);
          album.addShape(name, shape);
        } else if (line2.get(2).equals("oval")) {
          Oval shape = new Oval(new Point(x, y), new Color(r, b, g), width, height);
          album.addShape(name, shape);
        }
      } else if (line2.get(0).equals("move")) {
        // Parse elements from line
        String name = line2.get(1);
        int x = Integer.parseInt(line2.get(2));
        int y = Integer.parseInt(line2.get(3));
        // get shape with the name and move to new location
        Map shapes = album.getShapes();
        Shape shape = (Shape) shapes.get(name);
        shape.moveTo(new Point(x, y));
      } else if (line2.get(0).equals("color")) {
        // Parse elements from line
        String name = line2.get(1);
        int r = Integer.parseInt(line2.get(2));
        int b = Integer.parseInt(line2.get(3));
        int g = Integer.parseInt(line2.get(4));
        // get shape with the name and change color
        Map shapes = album.getShapes();
        Shape shape = (Shape) shapes.get(name);
        shape.changeColor(new Color(r, b, g));
      } else if (line2.get(0).equals("resize")) {
        // Parse elements from line
        String name = line2.get(1);
        int width = Integer.parseInt(line2.get(2));
        int height = Integer.parseInt(line2.get(3));
        // get shape with the name and resize
        Map shapes = album.getShapes();
        Shape shape = (Shape) shapes.get(name);
        shape.resize(width, height);
      } else if (line2.get(0).equals("remove")) {
        // Parse elements from line
        String name = line2.get(1);
        // Remove shape
        album.removeShape(name);
      } else if (line2.get(0).equals("snapshot")) {
        if (line2.size() == 1) {
          album.takeSnapshot(" ");
        } else if (line2.size() > 1) {
          line2.remove(0);
          String name = "";
          for (String each : line2) {
            name = name + each + " ";
          }
          album.takeSnapshot(name);
        }
      }
    }
    this.model = album;
  }


  //-in buildings.txt -v graphical 800 800
  //-in buildings.txt -out myWeb.html -v web

  /**
   * Go.
   *
   * @throws IOException the io exception
   */
  public void go() throws IOException {
    this.readFile();
    this.createAlbum();
    if (this.type.equals("graphical")) {
      Map<Snapshot, Map> snapshots = model.getSnapshots();
      GraphicalView graphicalView = new GraphicalView(maxCoordinates, snapshots);
      graphicalView.setVisible(true);
    } else if (this.type.equals("web")) {
      WebView webView = new WebView(model);
      String htmlString = webView.generateHtml();
      writeHtml(htmlString);
    }
  }
}