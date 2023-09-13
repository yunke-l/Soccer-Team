package soccerteam;

import static java.lang.String.format;

import java.time.LocalDate;
import java.time.Period;

/**
 * This class represents a soccer player.
 * It can create a new Player with given first name, last name, date of birth, preferred position,
 * and skill level.
 * It can be assigned a given jersey number and an assigned position.
 * It also has getter methods to get all the attributes.
 */
public class Player {
  private final String firstName;
  private final String lastName;
  private final LocalDate dateOfBirth;
  private final Position preferredPosition;
  private final int skillLevel;
  private Position assignedPosition;
  private int jerseyNumber;

  /**
   * Constructor to create a new soccer player. The player's assigned position is initialized
   * as Bench, and jersey number is initialized as 0.
   * @param firstName first name of the player.
   * @param lastName last name of the player.
   * @param dateOfBirth date of birth of the player.
   * @param preferredPosition preferred position of the player.
   * @param skillLevel skill level of the player, between 1 and 5 (inclusive).
   * @throws IllegalArgumentException throws when player's age is older than 10, or skill
   *                                  level is not between 1 and 5 (inclusive).
   */
  public Player(String firstName, String lastName, LocalDate dateOfBirth,
      Position preferredPosition, int skillLevel) throws IllegalArgumentException {

    // players must be under 10 years old
    if (Period.between(dateOfBirth, LocalDate.now()).getYears() > 10) {
      throw new IllegalArgumentException("Players must be under 10 years old");
    }
    // skill level must be between 1 and 5 (inclusive)
    if (skillLevel < 1 || skillLevel > 5) {
      throw new IllegalArgumentException("Skill level must be between 1 and 5 (inclusive)");
    }

    firstName = String.format("%s%s", firstName.substring(0, 1).toUpperCase(),
        firstName.substring(1));
    lastName = String.format("%s%s", lastName.substring(0, 1).toUpperCase(), lastName.substring(1));

    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.preferredPosition = preferredPosition;
    this.skillLevel = skillLevel;
    this.assignedPosition = Position.BENCH;   // initialized as BENCH
    this.jerseyNumber = 0;                    // initialized as 0
  }

  /**
   * Assign a jersey number to the player.
   * @param jerseyNumber the jersey number to be assigned
   */
  public void assignJerseyNumber(int jerseyNumber) {
    this.jerseyNumber = jerseyNumber;
  }


  /**
   * Assign a position to the player.
   * @param position the position to be assigned
   */
  public void assignPosition(Position position) {
    this.assignedPosition = position;
  }

  /**
   * Get the player's first name.
   * @return the first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the player's last name.
   * @return the last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the player's date of birth.
   * @return the date of birth.
   */
  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  /**
   * Get the player's preferred position.
   * @return the preferred position.
   */
  public Position getPreferredPosition() {
    return preferredPosition;
  }

  /**
   * Get the player's skill level.
   * @return the skill level.
   */
  public int getSkillLevel() {
    return skillLevel;
  }

  /**
   * Get the player's assigned position.
   * @return the assigned position.
   */
  public Position getAssignedPosition() {
    return assignedPosition;
  }

  /**
   * Get the player's jersey number.
   * @return the jersey number.
   */
  public int getJerseyNumber() {
    return jerseyNumber;
  }


  /**
   * Get the player's information as a string if the player is in the team, including the
   * player's first name, last name and jersey number.
   * @return the info string of the player in a team.
   */
  public String teamMemberInfo() {
    String format = "%1$-20s %2$-20s %3$-20s\n";
    String[] str = { String.valueOf(firstName), String.valueOf(lastName),
        String.valueOf(jerseyNumber) };
    return String.format(format, (Object[]) str);
  }

  /**
   * Get the player's information as a string if the player is in the starting line up,
   * including the player's first name, last name, jersey number and assigned position.
   * @return the info string of the player in the starting line up.
   */
  public String sluMemberInfo() {
    String format = "%1$-20s %2$-20s %3$-20s %4$-20s\n";
    String[] str = { String.valueOf(firstName), String.valueOf(lastName),
        String.valueOf(jerseyNumber), String.valueOf(assignedPosition)};
    return String.format(format, (Object[]) str);
  }
}

