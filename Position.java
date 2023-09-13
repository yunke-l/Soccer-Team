package soccerteam;

/**
 * This enum SoccerTeam.Position, representing the position of a player in a soccer team.
 * ---------------------------------------------------------------------------
 * GOALIE: who defends the goal.
 * DEFENDER: who protect the goal.
 * MIDFIELDER: who control the flow of the game.
 * FORWARD: who attack the opponent's goal.
 * BENCH: substitutes ready to play when needed.
 * ---------------------------------------------------------------------------
 * with a toString() method that returns "Goalie", "Defender", "Midfielder",
 * "Forward" and "Bench" accordingly.
 */
public enum Position {
  GOALIE {
    public String toString() {
      return "Goalie";
    }
  },
  DEFENDER {
    public String toString() {
      return "Defender";
    }
  },
  MIDFIELDER {
    public String toString() {
      return "Midfielder";
    }
  },
  FORWARD {
    public String toString() {
      return "Forward";
    }
  },
  BENCH {
    public String toString() {
      return "Bench";
    }
  }
}

