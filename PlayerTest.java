import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import soccerteam.Player;
import soccerteam.Position;

/**
 * Tests for Player.
 */
public class PlayerTest {
  private Player player1;
  private Player player2;
  private Player player3;

  /**
   * Setting up some objects of Player.
   */
  @Before
  public void setUp() {
    player1 = new Player("Ethan", "Smith", LocalDate.of(
        2013, 12, 1), Position.FORWARD, 3);
    player2 = new Player("Olivia", "Rodriguez", LocalDate.of(
        2014, 2, 14), Position.DEFENDER, 2);
    player3 = new Player("Mason", "Johnson", LocalDate.of(
        2015, 9, 5), Position.MIDFIELDER, 4);
  }

  /**
   * Tests for invalid date of birth, the age of each player must be under 10.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidDateOfBirth() {
    new Player("Ethan", "Smith", LocalDate.of(
        2012, 12, 1), Position.FORWARD, 3);
    new Player("Olivia", "Rodriguez", LocalDate.of(
        2009, 2, 14), Position.DEFENDER, 2);
  }

  /**
   * Tests for invalid skill level, should be between 1 and 5 (inclusive).
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidSkillLevel() {
    new Player("Ethan", "Smith", LocalDate.of(
        2013, 12, 1), Position.FORWARD, 0);
    new Player("Olivia", "Rodriguez", LocalDate.of(
        2014, 2, 14), Position.DEFENDER, -2);
    new Player("Olivia", "Rodriguez", LocalDate.of(
        2014, 2, 14), Position.DEFENDER, 6);
  }

  /**
   * Tests for assignJerseyNumber().
   */
  @Test
  public void testAssignJerseyNumber() {
    player1.assignJerseyNumber(1);
    player2.assignJerseyNumber(19);
    assertEquals(1, player1.getJerseyNumber());
    assertEquals(19, player2.getJerseyNumber());
  }

  /**
   * Tests for assignPosition().
   */
  @Test
  public void testAssignPosition() {
    player1.assignPosition(Position.DEFENDER);
    player2.assignPosition(Position.GOALIE);
    assertEquals(Position.DEFENDER, player1.getAssignedPosition());
    assertEquals(Position.GOALIE, player2.getAssignedPosition());
    assertEquals(Position.BENCH, player3.getAssignedPosition());
  }

  /**
   * Tests for getFirstName().
   */
  @Test
  public void testGetFirstName() {
    assertEquals("Ethan", player1.getFirstName());
    assertEquals("Olivia", player2.getFirstName());
  }

  /**
   * Tests for getLastName().
   */
  @Test
  public void testGetLastName() {
    assertEquals("Smith", player1.getLastName());
    assertEquals("Rodriguez", player2.getLastName());
  }

  /**
   * Tests for getDateOfBirth().
   */
  @Test
  public void testGetDateOfBirth() {
    assertEquals(LocalDate.of(2013, 12, 1), player1.getDateOfBirth());
    assertEquals(LocalDate.of(2014, 2, 14), player2.getDateOfBirth());
  }

  /**
   * Tests for getPreferredPosition().
   */
  @Test
  public void testGetPreferredPosition() {
    assertEquals(Position.FORWARD, player1.getPreferredPosition());
    assertEquals(Position.DEFENDER, player2.getPreferredPosition());
  }

  /**
   * Tests for getSkillLevel().
   */
  @Test
  public void testGetSkillLevel() {
    assertEquals(3, player1.getSkillLevel());
    assertEquals(2, player2.getSkillLevel());
  }

  /**
   * Tests for getAssignedPosition().
   */
  @Test
  public void testGetAssignedPosition() {
    player1.assignPosition(Position.DEFENDER);
    player2.assignPosition(Position.GOALIE);
    assertEquals(Position.DEFENDER, player1.getAssignedPosition());
    assertEquals(Position.GOALIE, player2.getAssignedPosition());
    assertEquals(Position.BENCH, player3.getAssignedPosition());
  }

  /**
   * Tests for getJerseyNumber().
   */
  @Test
  public void testGetJerseyNumber() {
    player1.assignJerseyNumber(1);
    player2.assignJerseyNumber(19);
    assertEquals(1, player1.getJerseyNumber());
    assertEquals(19, player2.getJerseyNumber());
  }

  /**
   * Tests for teamMemberInfo().
   */
  @Test
  public void testTeamMemberInfo() {
    player1.assignJerseyNumber(1);
    player2.assignJerseyNumber(19);
    String info1 = "Ethan                Smith                1                   \n";
    String info2 = "Olivia               Rodriguez            19                  \n";
    String info3 = "Mason                Johnson              0                   \n";
    assertEquals(info1, player1.teamMemberInfo());
    assertEquals(info2, player2.teamMemberInfo());
    assertEquals(info3, player3.teamMemberInfo());
  }

  /**
   * Tests for sluMemberInfo().
   */
  @Test
  public void testSluMemberInfo() {
    player1.assignJerseyNumber(1);
    player2.assignJerseyNumber(19);
    player1.assignPosition(Position.DEFENDER);
    player2.assignPosition(Position.GOALIE);
    String info1 = "Ethan                Smith                1                    "
        + "Defender            \n";
    String info2 = "Olivia               Rodriguez            19                   "
        + "Goalie              \n";
    String info3 = "Mason                Johnson              0                    "
        + "Bench               \n";
    assertEquals(info1, player1.sluMemberInfo());
    assertEquals(info2, player2.sluMemberInfo());
    assertEquals(info3, player3.sluMemberInfo());
  }
}