package soccerteam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class represents a U10 Soccer Team.
 * It can create a new team with a list of team members, and a list of starting line up.
 * It has methods to add players, create team and starting line up, and toStrings to
 * return the information of the two lists.
 * It offers all the operations mandated by the Team interface, and four helper functions.
 */
public class TeamImpl implements Team {

  private List<Player> team;
  private List<Player> startingLineUp;

  /**
   * Constructor to create a new U10 Soccer Team.
   * Initialize the team with an empty list of team members, and an empty list of
   * starting line up.
   */
  public TeamImpl() {
    this.team = new ArrayList<>();
    this.startingLineUp = new ArrayList<>();
  }


  @Override
  public void addPlayer(Player player) {
    team.add(player);
  }

  @Override
  public void removePlayer(String firstName, String lastName) {
    for (Player player : team) {
      if (player.getFirstName().equals(firstName) && player.getLastName().equals(lastName)) {
        team.remove(player);
        break;
      }
    }
  }

  @Override
  public void createTeam() throws IllegalArgumentException {
    int teamSize = team.size();
    if (teamSize < 10) {
      throw new IllegalArgumentException("Not enough players to create a team.");
    }
    if (teamSize > 20) {
      // sort players by skill level (decreasing order)
      sortPlayersBySkillLevel(team);
      // keep the top 20 players with the highest skill level
      team = (team).subList(0, 20);
    }
    //assign random unique jersey numbers to players
    generateJerseyNumbers(team);
    // select starting line up
    selectStartingLineUp();
    // sort players by last name
    sortPlayersByLastName(team);
  }

  @Override
  public String teamInfo() {
    String format = "%1$-15s %2$-15s %3$-15s\n";
    String headers = String.format(format, "First Name", "Last Name", "Jersey Number");
    StringBuilder teamInfo = new StringBuilder(String.format("U10 Soccer Team\n"
        + "Team Size: %d\n"
        + "------------------------\n", team.size())).append(headers);
    for (Player player : team) {
      teamInfo.append(player.teamMemberInfo());
    }
    return teamInfo.toString();
  }

  @Override
  public String startingLineUpInfo() {
    String format = "%1$-15s %2$-15s %3$-15s %4$-15s\n";
    String headers = String.format(format, "First Name", "Last Name", "Jersey Number", "Position");
    StringBuilder startingLineUpInfo = new StringBuilder("Starting Line Up\n"
        + "------------------------\n").append(headers);
    for (Player player : startingLineUp) {
      startingLineUpInfo.append(player.sluMemberInfo());
    }
    return startingLineUpInfo.toString();
  }


  @Override
  public List<Player> getTeam() {
    return new ArrayList<>(team);
  }

  @Override
  public List<Player> getStartingLineUp() {
    return new ArrayList<>(startingLineUp);
  }


  @Override
  public int getTeamSize() {
    return team.size();
  }


  /**
   * Sorts the list of players by skill level (decreasing order).
   * @param playerList a list of Player.
   */
  private void sortPlayersBySkillLevel(List<Player> playerList) {
    playerList.sort(Comparator.comparingInt(Player::getSkillLevel).reversed());
  }

  /**
   * Sorts the list of players by last name (alphabetical order).
   * @param playerList a list of Player.
   */
  private void sortPlayersByLastName(List<Player> playerList) {
    playerList.sort(Comparator.comparing(Player::getLastName));
  }

  /**
   * Sorts the list of players by position then by last name (alphabetical order).
   * @param playerList a list of Player.
   */
  private void sortPlayersByPositionThenByLastName(List<Player> playerList) {
    playerList.sort(Comparator.comparing(Player::getAssignedPosition).thenComparing(
        Player::getLastName));
  }


  /**
   * Assigns random unique jersey numbers to players，numbers range from 1 to 20 (inclusive).
   * @param playerList a list of Player.
   */
  private void generateJerseyNumbers(List<Player> playerList) {
    // create a list of numbers from 1 to 20
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i <= 20; i++) {
      numbers.add(i);
    }
    // shuffle the list to generate random numbers
    Collections.shuffle(numbers);
    // assign jersey numbers to players
    for (int i = 0; i < playerList.size(); i++) {
      playerList.get(i).assignJerseyNumber(numbers.get(i));
    }
  }

  /**
   * Select the starting line up from the team.
   * The starting line up is composed of 7 players: 1 goalie, 2 defenders, 3 midfielders,
   * and 1 forward.
   * The starting line up is selected based on the player's skill level (Top 7). The players
   * with the highest skill level are selected first, then the players with the second highest.
   * If a player has a preferred position which is available, then the player is assigned to
   * that position. Otherwise, the player is assigned to the first available position.
   * The starting line up is first sorted by position (Goalie, Defender, Midfielder, Forward),
   * then by last name.
   */
  private void selectStartingLineUp() {
    // create a copy of the team to avoid modifying the original list
    List<Player> teamComposition = getTeam();
    // sort players by skill level (decreasing order)
    sortPlayersBySkillLevel(teamComposition);
    // clear all the preassigned positions, change all to bench
    for (Player player : teamComposition) {
      player.assignPosition(Position.BENCH);
    }
    // select the top 7 players with the highest skill level
    startingLineUp = teamComposition.subList(0, 7);
    // create a list of available positions
    List<Position> availablePositions = Arrays.asList(
        Position.GOALIE,
        Position.DEFENDER,
        Position.DEFENDER,
        Position.MIDFIELDER,
        Position.MIDFIELDER,
        Position.MIDFIELDER,
        Position.FORWARD
    );
    // create a copy of the available positions to avoid modifying the original list
    List<Position> availablePositionsCopy = new ArrayList<>(availablePositions);
    // assign the player's preferred position if available
    for (Player player : startingLineUp) {
      Position pos = player.getPreferredPosition();
      if (availablePositionsCopy.contains(pos)) {
        player.assignPosition(pos);
        availablePositionsCopy.remove(pos);
      }
    }
    // assign remaining positions to players
    for (Player player : startingLineUp) {
      if (player.getAssignedPosition() == Position.BENCH) {
        Position pos = availablePositionsCopy.get(0);
        player.assignPosition(pos);
        availablePositionsCopy.remove(pos);
      }
    }
    // sort players by Position then by last name
    sortPlayersByPositionThenByLastName(startingLineUp);
  }

}
