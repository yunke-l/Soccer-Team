package soccerteam;

import java.util.List;

/**
 * This interface represents the operations offered by the soccer team model. One object of the
 * model represents one U10 Soccer Team.
 */
public interface Team {
  /**
   * Add a player to the team.
   *
   * @param player the player to be added
   */
  void addPlayer(Player player);

  /**
   * Remove a player from the team.
   *
   * @param firstName the first name of the player to be removed
   * @param lastName the last name of the player to be removed
   */
  void removePlayer(String firstName, String lastName);


  /**
   * Create a team. the team must have a minimum of 10 players and a maximum of 20.
   * If there are less than 10 players, an exception will be raised to inform that the team
   * cannot be created unless more players are added. If the team has more than 20 players,
   * the ones with the lowest skill level must be ignored so that the team only have 20 players.
   * After the team is created, each player will be randomly assigned a unique jersey number,
   * and the starting line up will be selected. Then the players will be sorted by last name.
   *
   * @throws Exception if the team cannot be created
   */
  void createTeam() throws IllegalStateException;


  /**
   * Returns a copy of the team list.
   * @return a copy of the team list.
   */
  List<Player> getTeam();


  /**
   * Returns a copy of the starting line up list.
   * @return a copy of the starting line up list.
   */
  List<Player> getStartingLineUp();


  /**
   * Returns the size of the team.
   * @return the size of the team.
   */
  int getTeamSize();


  /**
   * Return a string that represents the team information, including team size,
   * each player's first name, last name and jersey number.
   *
   * @return the team information as a string
   */
  String teamInfo();


  /**
   * Return a string that represents the starting line up information, including
   * each player's first name, last name, jersey number and assigned position.
   *
   * @return the starting line up information as a string
   */
  String startingLineUpInfo();


}
