package soccerteam;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 * GUI Implementation of the View interface.
 */
public class ViewImpl extends JFrame implements View {

  private final JTextField firstNameField;
  private final JTextField lastNameField;
  private final DatePicker datePicker;
  private final JComboBox<Integer> skillLevelBox;
  private final JComboBox<String> preferredPositionBox;
  private final JButton addPlayerButton;
  private final JButton removePlayerButton;
  private final JButton createTeamButton;
  private final JButton reset;
  private final JButton exit;
  private final JTable teamTable;
  private final DefaultTableModel tableModel;
  private final JLabel rowCountLabel;
  private final JTextArea teamInfoTextArea;
  private final JTextArea startingLineUpTextArea;


  /**
   * Initialize the window.
   *
   * @param caption Caption for the window.
   */
  public ViewImpl(String caption) {
    super(caption);
    setSize(400, 300);
    setLocation(100,  100);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    // Input panel
    JPanel inputPanel = new JPanel(new FlowLayout());
    inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    // First name
    inputPanel.add(new JLabel("First name:"));
    firstNameField = new JTextField(10);
    inputPanel.add(firstNameField);
    // Last name
    inputPanel.add(new JLabel("Last name:"));
    lastNameField = new JTextField(10);
    inputPanel.add(lastNameField);
    // Date of birth
    inputPanel.add(new JLabel("Date of birth:"));
    datePicker = new DatePicker();
    inputPanel.add(datePicker);
    datePicker.setDate(LocalDate.now().format(datePicker.dateFormatter));
    // Skill level
    inputPanel.add(new JLabel("Skill level:"));
    Integer[] skillLevels = {1, 2, 3, 4, 5};
    skillLevelBox = new JComboBox<>(skillLevels);
    inputPanel.add(skillLevelBox);
    // Preferred position
    inputPanel.add(new JLabel("Preferred position:"));
    String[] positions = {"Forward", "Midfielder", "Defender", "Goalie"};
    preferredPositionBox = new JComboBox<>(positions);
    inputPanel.add(preferredPositionBox);
    // Add player
    addPlayerButton = new JButton("Add Player");
    inputPanel.add(addPlayerButton);


    // Generate panel
    JPanel generatePanel = new JPanel(new FlowLayout());
    generatePanel.setLayout(new BoxLayout(generatePanel, BoxLayout.Y_AXIS));
    generatePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    generatePanel.add(Box.createVerticalStrut(20));
    // Count players
    rowCountLabel = new JLabel("Players: 0");
    generatePanel.add(rowCountLabel);
    generatePanel.add(Box.createVerticalStrut(20));
    // Remove player
    removePlayerButton = new JButton("Remove Player");
    generatePanel.add(removePlayerButton);
    generatePanel.add(Box.createVerticalStrut(20));
    // Create team
    createTeamButton = new JButton("Create Team");
    generatePanel.add(createTeamButton);
    generatePanel.add(Box.createVerticalStrut(20));


    // ResetAndExit panel
    JPanel resetAndExitPanel = new JPanel(new FlowLayout());
    resetAndExitPanel.setLayout(new BoxLayout(resetAndExitPanel, BoxLayout.Y_AXIS));
    resetAndExitPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    resetAndExitPanel.add(Box.createVerticalStrut(50));
    // Reset
    reset = new JButton("Reset");
    resetAndExitPanel.add(reset);
    resetAndExitPanel.add(Box.createVerticalStrut(20));
    // Exit
    exit = new JButton("Exit");
    resetAndExitPanel.add(exit);
    resetAndExitPanel.add(Box.createVerticalStrut(20));

    // Bottom panel
    JPanel bottomPanel = new JPanel(new FlowLayout());
    bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    // Team info
    JLabel teamInfoLabel = new JLabel("Team:");
    bottomPanel.add(teamInfoLabel);
    teamInfoTextArea = new JTextArea(20, 40);
    teamInfoTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    teamInfoTextArea.setEditable(false);
    bottomPanel.add(teamInfoTextArea);
    // Starting line up
    JLabel startingLineUpLabel = new JLabel("Starting line up:");
    bottomPanel.add(startingLineUpLabel);
    startingLineUpTextArea = new JTextArea(20, 40);
    startingLineUpTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    startingLineUpTextArea.setEditable(false);
    bottomPanel.add(startingLineUpTextArea);

    // Team table
    String[] columnNames = {"First name", "Last name", "Date of birth", "Skill level",
        "Preferred position"};
    tableModel = new DefaultTableModel(columnNames, 0);
    teamTable = new JTable(tableModel);
    teamTable.setPreferredScrollableViewportSize(new Dimension(500, 15 * teamTable.getRowHeight()));
    JScrollPane scrollPane = new JScrollPane(teamTable);

    getContentPane().add(inputPanel, BorderLayout.NORTH);
    getContentPane().add(generatePanel, BorderLayout.WEST);
    getContentPane().add(resetAndExitPanel, BorderLayout.EAST);
    getContentPane().add(scrollPane, BorderLayout.CENTER);
    getContentPane().add(bottomPanel, BorderLayout.SOUTH);

    pack();
    setVisible(true);
  }

  @Override
  public void addFeatures(Features feature) {
    addPlayerButton.addActionListener(e -> feature.addPlayer());
    removePlayerButton.addActionListener(e -> feature.removeSelectedPlayer());
    createTeamButton.addActionListener(e -> feature.createTeam());
    reset.addActionListener(e -> feature.reset());
    exit.addActionListener(e -> feature.exit());
  }

  @Override
  public void addPlayer() {
    String firstName = getFirstName().toLowerCase();
    String lastName = getLastName().toLowerCase();
    // Capitalize the first letter of first name and last name
    firstName = String.format("%s%s", firstName.substring(0, 1).toUpperCase(),
        firstName.substring(1));
    lastName = String.format("%s%s", lastName.substring(0, 1).toUpperCase(), lastName.substring(1));
    LocalDate dateOfBirth = getDateOfBirth();
    Position preferredPosition = getPreferredPosition();
    int skillLevel = getSkillLevel();

    Object[] rowData = {firstName, lastName, dateOfBirth, skillLevel, preferredPosition};
    tableModel.addRow(rowData);
    rowCountLabel.setText("Players: " + tableModel.getRowCount());
  }

  @Override
  public void displayError(String msg) {
    JOptionPane.showMessageDialog(null, msg);
  }

  @Override
  public Object[] getRowValue() {
    int selectedRow = teamTable.getSelectedRow();
    if (selectedRow != -1) {
      String firstName = tableModel.getValueAt(selectedRow, 0).toString();
      String lastName = tableModel.getValueAt(selectedRow, 1).toString();
      String dateString = tableModel.getValueAt(selectedRow, 2).toString();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate dateOfBirth = LocalDate.parse(dateString, formatter);
      int skillLevel = Integer.parseInt(tableModel.getValueAt(selectedRow, 3).toString());
      Position preferredPosition = Position.valueOf(
          tableModel.getValueAt(selectedRow, 4).toString().toUpperCase());

      return new Object[]{firstName, lastName, dateOfBirth, skillLevel, preferredPosition};
    }
    return null;
  }

  @Override
  public void removePlayer() {
    int selectedRow = teamTable.getSelectedRow();
    tableModel.removeRow(selectedRow);
    rowCountLabel.setText("Players: " + tableModel.getRowCount());

  }

  @Override
  public String getFirstName() {
    return firstNameField.getText();
  }

  @Override
  public String getLastName() {
    return lastNameField.getText();
  }

  @Override
  public int getSkillLevel() {
    return (int) skillLevelBox.getSelectedItem();
  }

  @Override
  public Position getPreferredPosition() {
    return Position.valueOf(preferredPositionBox.getSelectedItem()
            .toString().toUpperCase());
  }

  @Override
  public LocalDate getDateOfBirth() {
    String date = datePicker.getDate();
    return LocalDate.parse(date, datePicker.dateFormatter);
  }

  @Override
  public void displayTeam(String teamInfo) {
    teamInfoTextArea.setText("");
    teamInfoTextArea.setText(teamInfo);
  }

  @Override
  public void displayStartingLineUp(String startingLineUp) {
    startingLineUpTextArea.setText("");
    startingLineUpTextArea.setText(startingLineUp);
  }

  @Override
  public void reset() {
    firstNameField.setText("");
    lastNameField.setText("");
    datePicker.setDate(LocalDate.now().format(datePicker.dateFormatter));
    skillLevelBox.setSelectedIndex(0);
    preferredPositionBox.setSelectedIndex(0);
    tableModel.setRowCount(0);
    rowCountLabel.setText("Players: " + tableModel.getRowCount());
    teamInfoTextArea.setText("");
    startingLineUpTextArea.setText("");
  }

}
