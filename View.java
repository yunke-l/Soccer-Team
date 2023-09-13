package soccerteam;

import java.time.LocalDate;

/**
 * Interface for a U10 Soccer Team's view.
 */
public interface View {

  /**
   * Add the Controller to the view.
   * @param f the implementation of the controller
   */
  void addFeatures(Features f);

  /**
   * Get the first name of the player.
   * @return the first name of the player
   */
  String getFirstName();

  /**
   * Get the last name of the player.
   * @return the last name of the player
   */
  String getLastName();

  /**
   * Get the date of birth of the player.
   * @return the date of birth of the player
   */
  LocalDate getDateOfBirth();

  /**
   * Get the skill level of the player.
   * @return the skill level of the player
   */
  int getSkillLevel();

  /**
   * Get the preferred position of the player.
   * @return the preferred position of the player
   */
  Position getPreferredPosition();

  /**
   * Add a player to the team.
   */
  void addPlayer();

  /**
   * Remove a player from the team.
   */
  void removePlayer();

  /**
   * Get the row value of the selected player.
   * @return the row value of the selected player
   */
  Object[] getRowValue();

  /**
   * Display the error message.
   * @param message the error message
   */
  void displayError(String message);

  /**
   * Display the team information.
   * @param teamInfo the team information
   */
  void displayTeam(String teamInfo);

  /**
   * Display the starting lineup information.
   * @param startingLineUpInfo the starting lineup information
   */
  void displayStartingLineUp(String startingLineUpInfo);

  /**
   * Reset the view.
   */
  void reset();

}
