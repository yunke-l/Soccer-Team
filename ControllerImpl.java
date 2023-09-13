package soccerteam;

import java.time.LocalDate;

/**
 * This is the controller of the program, which implements the Features interface.
 */
public class ControllerImpl implements Features {
  private Team team;
  private View view;

  /**
   * Constructor for the controller.
   *
   * @param m the model of the soccer team.
   * @param v the view of the soccer team.
   */
  public ControllerImpl(Team m, View v) {
    team = m;
    view = v;
  }

  @Override
  public void setView(View v) {
    v.addFeatures(this);
  }

  @Override
  public void addPlayer() {
    String firstName = view.getFirstName();
    String lastName = view.getLastName();
    LocalDate dateOfBirth = view.getDateOfBirth();
    int skillLevel = view.getSkillLevel();
    Position preferredPosition = view.getPreferredPosition();

    try {
      Player p = new Player(firstName, lastName, dateOfBirth, preferredPosition, skillLevel);
      team.addPlayer(p);
      view.addPlayer();
    } catch (IllegalArgumentException e) {
      view.displayError(e.getMessage());
    }
  }

  @Override
  public void removeSelectedPlayer() {
    Object[] rowValue = view.getRowValue();
    if (rowValue != null) {
      String firstName = (String) rowValue[0];
      String lastName = (String) rowValue[1];
      team.removePlayer(firstName, lastName);
      view.removePlayer();
    }
  }

  @Override
  public void createTeam() {
    try {
      team.createTeam();
    } catch (IllegalArgumentException e) {
      view.displayError(e.getMessage());
      return;
    }

    view.displayTeam(team.teamInfo());
    view.displayStartingLineUp(team.startingLineUpInfo());
  }

  public void reset() {
    team = new TeamImpl();
    view.reset();
  }

  public void exit() {
    System.exit(0);
  }

}
