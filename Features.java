package soccerteam;

/**
 * Interface for a U10 Soccer Team's controller.
 */
public interface Features {

  /**
   * Provide view with all the callbacks.
   * @param v the view.
   */
  public void setView(View v);

  /**
   * Add a player to the team.
   */
  void addPlayer();

  /**
   * Remove the selected player from the team.
   */
  void removeSelectedPlayer();

  /**
   * Create the team.
   */
  void createTeam();

  /**
   * Reset the team.
   */
  void reset();

  /**
   * Exit the program.
   */
  void exit();
}
