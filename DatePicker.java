package soccerteam;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 * A date picker component.
 */
public class DatePicker extends JPanel {
  public final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
  private final JFormattedTextField dateTextField;

  /**
   * Constructor.
   */
  public DatePicker() {
    setLayout(new BorderLayout());
    dateTextField = new JFormattedTextField(dateFormatter);
    dateTextField.setColumns(10);   // set layout

    JButton dateButton = new JButton("set");
    dateButton.addActionListener(e -> {
      LocalDate selectedDate = LocalDate.now();
      String dateText = dateTextField.getText();
      if (!dateText.isEmpty()) {
        selectedDate = LocalDate.parse(dateText, dateFormatter);
      }

      JSpinner spinner = new JSpinner(new SpinnerDateModel(java.sql.Date.valueOf(selectedDate),
          null, null, java.util.Calendar.DAY_OF_MONTH));
      // format of date shown in spinner
      JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "MM/dd/yyyy");
      spinner.setEditor(editor);
      int option = JOptionPane.showOptionDialog(null, spinner, "Select Date",
          JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null,
          null);
      if (option == JOptionPane.OK_OPTION) {
        LocalDate selectedDateValue = ((java.util.Date) spinner.getValue()).toInstant()
            .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        dateTextField.setText(dateFormatter.format(selectedDateValue));
      }
    });

    add(dateTextField, BorderLayout.CENTER);
    add(dateButton, BorderLayout.EAST);
  }

  /**
   * Get the currently selected date in the format of a String.
   *
   * @return the date.
   */
  public String getDate() {
    return dateTextField.getText();
  }

  /**
   * Set the date in the dateTextField field to the specified String date value.
   *
   * @param date the date.
   */
  public void setDate(String date) {
    dateTextField.setText(date);
  }

}
