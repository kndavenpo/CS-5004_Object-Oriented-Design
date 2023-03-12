package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.*;
import model.Snapshot;


/**
 * Katie Davenport
 * CS 5004 - Homework 8 - Part II
 *
 *<p>The type Graphical view.
 */
public class GraphicalView extends JFrame {

  private Map<Snapshot, Map> snapshots;
  private int width;
  private int height;
  private int index;
  private JPanel infoPanel;
  private JPanel shapePanel;
  private JPanel buttonPanel;
  /**
   * The constant caption.
   */
  public static final String caption = "CS5004 Shapes Photo Album Viewer";


  /**
   * Instantiates a new Graphical view.
   *
   * @param maxCoordinates the max coordinates
   * @param snapshots      the snapshots
   */
  public GraphicalView(ArrayList<Integer> maxCoordinates, Map<Snapshot, Map> snapshots) {
    super(caption);
    this.snapshots = snapshots;
    this.width = maxCoordinates.get(1);
    this.height = maxCoordinates.get(2);
    this.index = 0; // default index is set to 0.

    // Configure board
    setSize(this.width, this.height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.infoPanel = addSnapshotInfo(); // WANT TO APPEAR ON TOP
    this.buttonPanel = addButtons();
    this.shapePanel = new JPanel(); // WANT TO APPEAR ON TOP
    shapePanel.setBackground(Color.BLUE);

    // Set layout and add panels
    setLayout(new BorderLayout());
    add(shapePanel, BorderLayout.CENTER);
    add(infoPanel, BorderLayout.NORTH);
    add(buttonPanel, BorderLayout.SOUTH);

  }

  private JPanel addSnapshotInfo() {
    // Get the snapshot id and description
    ArrayList<Snapshot> keyList = new ArrayList<>(snapshots.keySet());
    Snapshot snapshot = keyList.get(this.index);
    String snapshotId = snapshot.getSnapshotId();
    String description = snapshot.getDescription();

    // Create labels
    JLabel idLabel = new JLabel(snapshotId);
    JLabel descriptionLabel = new JLabel(description);

    // Create a panel and add the labels
    JPanel infoPanel = new JPanel();
    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
    infoPanel.add(idLabel);
    infoPanel.add(descriptionLabel);
    infoPanel.setBackground(Color.pink);

    // Return panel
    return infoPanel;
  }

  private JPanel addButtons() {
    // Create panel and set layout
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1, 0));

    // Create buttons and add listeners
    JButton previousButton = new JButton("<< Prev <<");
    previousButton.addActionListener(new PreviousListener());

    JButton selectButton = new JButton("^^ Select ^^");
    selectButton.addActionListener(new SelectListener());

    JButton nextButton = new JButton(">> Next >>");
    nextButton.addActionListener(new NextListener());

    JButton quitButton = new JButton("xx Quit xx");
    quitButton.addActionListener(new QuitListener());

    // Add buttons to the panel
    buttonPanel.add(previousButton);
    buttonPanel.add(selectButton);
    buttonPanel.add(nextButton);
    buttonPanel.add(quitButton);
    buttonPanel.setBackground(Color.yellow);

    // Return the panel
    return buttonPanel;
  }

  /**
   * Paint component.
   *
   * @param g the g
   */
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    ArrayList<Snapshot> keyList = new ArrayList<>(snapshots.keySet());
    Snapshot key = keyList.get(index);
    Map shapeMap = snapshots.get(key);
    ArrayList<String> shapeNames = new ArrayList<>(shapeMap.keySet());
    for (String each : shapeNames) {
      model.AbstractShape shape = (model.AbstractShape) shapeMap.get(each);
      String type = shape.getType();
      int x = shape.getX();
      int y = shape.getY();
      int width = shape.getWidth();
      int height = shape.getHeight();
      int red = shape.getRed();
      int green = shape.getGreen();
      int blue = shape.getBlue();
      if (type.equals("rect")) {
        g.setColor(new Color(red, green, blue));
        g.fillRect(x, y, width, height);
      } else if (type.equals("oval")) {
        g.setColor(new Color(red, green, blue));
        g.fillOval(x, y, width, height);
      }
    }
  }

  private class PreviousListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (index > 0) {
        index--;
        addSnapshotInfo();
        // how to update shapes?
      }
    }
  }

  private class NextListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (index < snapshots.size() - 2) {
        index++;
        addSnapshotInfo();
        // how to update shapes?
      }
    }
  }

  private class SelectListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      ArrayList<Snapshot> keyList = new ArrayList<>(snapshots.keySet());
      ArrayList<String> snapshotIdList = (ArrayList<String>) keyList.stream()
                      .map(s -> s.getSnapshotId()).collect(Collectors.toList());

      // add snapshots in a JOptionPane - WIP
      //      String message = (String) JOptionPane.showInputDialog(shapePanel, "Choose: ", "Menu",
      //              JOptionPane.INFORMATION_MESSAGE, null, new Snapshot[]{keyList.get(0)});
    }
  }

  private class QuitListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      System.exit(0);
    }
  }
}