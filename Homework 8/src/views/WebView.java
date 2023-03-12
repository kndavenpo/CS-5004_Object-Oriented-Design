package views;

import java.util.ArrayList;
import java.util.Map;
import model.AbstractShape;
import model.AlbumImpl;
import model.Snapshot;

/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part II
 *
 * <p>The type Web view.
 */
public class WebView {
  AlbumImpl album;
  String htmlText;

  /**
   * Instantiates a new Web view.
   *
   * @param album the album
   */
  public WebView(AlbumImpl album) {
    this.album = album;
    this.htmlText = generateHtml();
  }

  /**
   * Generate html string.
   *
   * @return the string
   */
  public String generateHtml() {
    String htmlString = "<!DOCTYPE html>" + "\n<html>" + "\n<head>" + "\n\t<style>"
            + "\n\t.snapshot {" + "\n\t\t\tborder: 5px outset red;"
            + "\n\t\t\tbackground-color: lightblue;" + "\n\t}"
            + "\n</style>" + "\n</head>" + "\n<body>"
            + "\n<h1>HTML for Photo Album</h1>";

    // Get snapshots
    Map<Snapshot, Map> snapshots = album.getSnapshots();

    // Loop through the snapshots and format text
    ArrayList<Snapshot> keyList = new ArrayList<>(snapshots.keySet());
    int counter = 1;
    for (Snapshot identifier : keyList) {
      String snapshotDetail = "\n<div class = \"snapshot\">"
              + "\n\t<h2>5004 Picture " + counter + "</h2>"
              + "\n\t<svg width=\"1000\" height=\"1000\">";
      htmlString = htmlString + snapshotDetail;
      counter++;
      // Get shapes
      Map shapes = snapshots.get(identifier);
      ArrayList<String> keyList2 = new ArrayList<>(shapes.keySet());
      // Loop through the shapes and format text
      for (String identifier2 : keyList2) {
        AbstractShape shape = (AbstractShape) shapes.get(identifier2);
        if (shape.getType() == "rect") {
          String shapeDetail = "\n\t\t<" + shape.getType() + " id=\"" + shape.getName() + "\" "
                + "x=\"" + shape.getX() + "\" y=\"" + shape.getY() + "\" width=\""
                + shape.getWidth() + "\" height=\"" + shape.getHeight() + "\" fill=\"rgb"
                + shape.getColor() + "\">"
                + "\n\t\t</" + shape.getType() + ">";
          htmlString = htmlString + shapeDetail;
        } else if (shape.getType() == "oval") {
          String shapeDetail = "\n\t\t<" + shape.getType() + " id=\"" + shape.getName() + "\" "
                  + "cx=\"" + shape.getX() + "\" cy=\"" + shape.getY() + "\" rx=\""
                  + shape.getWidth() + "\" ry=\"" + shape.getHeight() + "\" fill=\"rgb"
                  + shape.getColor() + "\">"
                  + "\n\t\t</" + shape.getType() + ">";
          htmlString = htmlString + shapeDetail;
        }
      }
      htmlString = htmlString + "\n\t</svg>" + "\n</div>\n<div>";
    }
    htmlString = htmlString + "\n</body>" + "\n</html";
    return htmlString;
  }
}