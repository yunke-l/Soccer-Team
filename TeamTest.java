import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import soccerteam.Player;
import soccerteam.Position;
import soccerteam.Team;
import soccerteam.TeamImpl;

/**
 * Tests for Team.
 */
public class TeamTest {
  private Team team9;
  private Team team16;
  private Team team21;
  private Player player1;
  private Player player2;
  private Player player3;
  private Player player4;
  private Player player5;
  private Player player6;
  private Player player7;
  private Player player8;
  private Player player9;
  private Player player10;
  private Player player11;
  private Player player12;
  private Player player13;
  private Player player14;
  private Player player15;
  private Player player16;
  private Player player17;
  private Player player18;
  private Player player19;
  private Player player20;
  private Player player21;

  /**
   * Setting up some objects of Team and Player.
   */
  @Before
  public void setUp() {
    team9 = new TeamImpl();
    team16 = new TeamImpl();
    team21 = new TeamImpl();
    player1 = new Player("Ethan", "Smith", LocalDate.of(2013, 12,
        1), Position.FORWARD, 3);
    player2 = new Player("Olivia", "Rodriguez", LocalDate.of(2014, 2,
        14), Position.DEFENDER, 2);
    player3 = new Player("Mason", "Johnson", LocalDate.of(2015, 9,
        5), Position.MIDFIELDER, 4);
    player4 = new Player("Sophia", "Brown", LocalDate.of(2014, 6,
        30), Position.GOALIE, 1);
    player5 = new Player("Liam", "Perez", LocalDate.of(2013, 11,
        9), Position.FORWARD, 5);
    player6 = new Player("Emma", "Hernandez", LocalDate.of(2015, 4,
        2), Position.DEFENDER, 3);
    player7 = new Player("Noah", "Davis", LocalDate.of(2013, 7,
        15), Position.MIDFIELDER, 2);
    player8 = new Player("Ava", "Martinez", LocalDate.of(2014, 9,
        28), Position.GOALIE, 4);
    player9 = new Player("William", "Wilson", LocalDate.of(2015, 2,
        25), Position.FORWARD, 1);
    player10 = new Player("Isabella", "Taylor", LocalDate.of(2013, 12,
        10), Position.DEFENDER, 5);
    player11 = new Player("James", "Thomas", LocalDate.of(2014, 10,
        21), Position.MIDFIELDER, 3);
    player12 = new Player("Mia", "Anderson", LocalDate.of(2015, 3,
        19), Position.GOALIE, 2);
    player13 = new Player("Benjamin", "Martin", LocalDate.of(2013, 5,
        7), Position.FORWARD, 4);
    player14 = new Player("Charlotte", "Garcia", LocalDate.of(2014, 1,
        18), Position.DEFENDER, 1);
    player15 = new Player("Samuel", "Rodriguez", LocalDate.of(2015, 8,
        22), Position.MIDFIELDER, 5);
    player16 = new Player("Abigail", "Perez", LocalDate.of(2013, 6,
        13), Position.GOALIE, 3);
    player17 = new Player("Daniel", "Hernandez", LocalDate.of(2014,
        12, 9), Position.FORWARD, 2);
    player18 = new Player("Emily", "Davis", LocalDate.of(2015, 5,
        3), Position.DEFENDER, 4);
    player19 = new Player("Michael", "Wilson", LocalDate.of(2014, 11,
        26), Position.MIDFIELDER, 1);
    player20 = new Player("Harper", "Taylor", LocalDate.of(2013, 3,
        8), Position.GOALIE, 5);
    player21 = new Player("Jacob", "Thomas", LocalDate.of(2014, 7,
        4), Position.FORWARD, 3);
  }

  /**
   * Helper method to add 9 players to team9.
   */
  public void team9Helper() {
    team9.addPlayer(player1);
    team9.addPlayer(player2);
    team9.addPlayer(player3);
    team9.addPlayer(player4);
    team9.addPlayer(player5);
    team9.addPlayer(player6);
    team9.addPlayer(player7);
    team9.addPlayer(player8);
    team9.addPlayer(player9);
  }

  /**
   * Helper method to add 16 players to team16.
   */
  public void team16Helper() {
    team16.addPlayer(player1);
    team16.addPlayer(player2);
    team16.addPlayer(player3);
    team16.addPlayer(player4);
    team16.addPlayer(player5);
    team16.addPlayer(player6);
    team16.addPlayer(player7);
    team16.addPlayer(player8);
    team16.addPlayer(player9);
    team16.addPlayer(player10);
    team16.addPlayer(player11);
    team16.addPlayer(player12);
    team16.addPlayer(player13);
    team16.addPlayer(player14);
    team16.addPlayer(player15);
    team16.addPlayer(player16);
  }

  /**
   * Helper method to add 21 players to team21.
   */
  public void team21Helper() {
    team21.addPlayer(player1);
    team21.addPlayer(player2);
    team21.addPlayer(player3);
    team21.addPlayer(player4);
    team21.addPlayer(player5);
    team21.addPlayer(player6);
    team21.addPlayer(player7);
    team21.addPlayer(player8);
    team21.addPlayer(player9);
    team21.addPlayer(player10);
    team21.addPlayer(player11);
    team21.addPlayer(player12);
    team21.addPlayer(player13);
    team21.addPlayer(player14);
    team21.addPlayer(player15);
    team21.addPlayer(player16);
    team21.addPlayer(player17);
    team21.addPlayer(player18);
    team21.addPlayer(player19);
    team21.addPlayer(player20);
    team21.addPlayer(player21);
  }


  /**
   * Test for addPlayer method.
   */
  @Test
  public void testAddPlayer() {
    team9Helper();
    team16Helper();
    team21Helper();
    assertEquals(9, team9.getTeam().size());
    assertEquals(16, team16.getTeam().size());
    assertEquals(21, team21.getTeam().size());
  }

  @Test
  public void testRemovePlayer() {
    team9Helper();
    team16Helper();
    team9.removePlayer("Ethan", "Smith");
    team16.removePlayer("Mason", "Johnson");
    assertEquals(8, team9.getTeam().size());
    assertEquals(15, team16.getTeam().size());
  }


  /**
   * Test for createTeam method with invalid number of players (less than 10).
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidCreateTeam() {
    // team9 has 9 players
    team9Helper();
    team9.createTeam();
  }

  /**
   * Test for createTeam method with valid number of players.
   */
  @Test
  public void testCreateTeam() {
    // test for add 10 players
    team9Helper();
    team9.addPlayer(player10);
    team9.createTeam();
    assertEquals(10, team9.getTeam().size());
    // test for add players' number between 10 and 20
    team16Helper();
    team16.createTeam();
    assertEquals(16, team16.getTeam().size());
    // test for add more than 20 players
    team21Helper();
    team21.createTeam();
    assertEquals(20, team21.getTeam().size());
  }


  /**
   * Test for getTeam method.
   */
  @Test
  public void getTeam() {
    List<Player> copyTeam16 = new ArrayList<>();
    copyTeam16.add(player1);
    copyTeam16.add(player2);
    copyTeam16.add(player3);
    copyTeam16.add(player4);
    copyTeam16.add(player5);
    copyTeam16.add(player6);
    copyTeam16.add(player7);
    copyTeam16.add(player8);
    copyTeam16.add(player9);
    copyTeam16.add(player10);
    copyTeam16.add(player11);
    copyTeam16.add(player12);
    copyTeam16.add(player13);
    copyTeam16.add(player14);
    copyTeam16.add(player15);
    copyTeam16.add(player16);

    team16Helper();
    assertEquals(copyTeam16, team16.getTeam());
  }

  /**
   * Test for getStartingLineUp method.
   */
  @Test
  public void getStartingLineUp() {
    List<Player> copyStartingLineUp21 = new ArrayList<>();
    copyStartingLineUp21.add(player20);
    copyStartingLineUp21.add(player8);
    copyStartingLineUp21.add(player10);
    copyStartingLineUp21.add(player3);
    copyStartingLineUp21.add(player13);
    copyStartingLineUp21.add(player15);
    copyStartingLineUp21.add(player5);

    team21Helper();
    team21.createTeam();
    assertEquals(copyStartingLineUp21, team21.getStartingLineUp());
  }

  /**
   * Test for getTeamSize method.
   */
  @Test
  public void testGetTeamSize() {
    team21Helper();
    team21.createTeam();
    assertEquals(20, team21.getTeamSize());
  }

  /**
   * Test for getTeamInfo method.
   * Since jersey number will change every time we create a team, we delete the jersey number
   * in the expected string and actual string, and see if other information matches.
   * Also, check if the team is sorted by last name.
   */
  @Test
  public void testGetTeamInfo() {
    team21Helper();
    team21.createTeam();

    String expected = "U10 Soccer Team\n"
        + "Team Size: 20\n"
        + "------------------------\n"
        + "First Name      Last Name      \n"
        + "Mia             Anderson       \n"
        + "Sophia          Brown          \n"
        + "Emily           Davis          \n"
        + "Noah            Davis          \n"
        + "Charlotte       Garcia         \n"
        + "Emma            Hernandez      \n"
        + "Daniel          Hernandez      \n"
        + "Mason           Johnson        \n"
        + "Benjamin        Martin         \n"
        + "Ava             Martinez       \n"
        + "Liam            Perez          \n"
        + "Abigail         Perez          \n"
        + "Samuel          Rodriguez      \n"
        + "Olivia          Rodriguez      \n"
        + "Ethan           Smith          \n"
        + "Isabella        Taylor         \n"
        + "Harper          Taylor         \n"
        + "James           Thomas         \n"
        + "Jacob           Thomas         \n"
        + "William         Wilson         \n";

    String actual = team21.teamInfo();
    String[] lines = actual.split("\n");
    StringBuilder sb = new StringBuilder();
    String format = "%1$-15s %2$-15s\n";
    String headers = String.format(format, "First Name", "Last Name");

    int length = lines.length;
    String[] newArray = Arrays.copyOfRange(lines, 4, length);

    sb.append("U10 Soccer Team\n"
        + "Team Size: 20\n"
        + "------------------------\n").append(headers);
    // delete jersey number
    for (String item : newArray) {
      String[] columns = item.split("\\s+");

      sb.append(String.format(format, columns[0], columns[1]));
    }
    String modifiedString = sb.toString();

    assertEquals(expected, modifiedString);
  }


  /**
   * Test for getStartingLineUpInfo method. Since jersey number will change every time we create
   * a team, we delete the jersey number in the expected string and actual string, and see if
   * other information matches.
   * Also, check if the team is sorted first by position then by last name.
   */
  @Test
  public void testGetStartingLineup() {
    team21Helper();
    team21.createTeam();

    String expected = "Starting Line Up\n"
        + "------------------------\n"
        + "First Name      Last Name       Position       \n"
        + "Harper          Taylor          Goalie         \n"
        + "Ava             Martinez        Defender       \n"
        + "Isabella        Taylor          Defender       \n"
        + "Mason           Johnson         Midfielder     \n"
        + "Benjamin        Martin          Midfielder     \n"
        + "Samuel          Rodriguez       Midfielder     \n"
        + "Liam            Perez           Forward        \n";

    String actual = team21.startingLineUpInfo();
    String[] lines = actual.split("\n");
    StringBuilder sb = new StringBuilder();
    String format = "%1$-15s %2$-15s %3$-15s\n";
    String headers = String.format(format, "First Name", "Last Name", "Position");

    int length = lines.length;
    String[] newArray = Arrays.copyOfRange(lines, 3, length);

    sb.append("Starting Line Up\n"
        + "------------------------\n").append(headers);
    // delete jersey number
    for (String item : newArray) {
      String[] columns = item.split("\\s+");

      sb.append(String.format(format, columns[0], columns[1], columns[3]));
    }
    String modifiedString = sb.toString();

    assertEquals(expected, modifiedString);
  }



}