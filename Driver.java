package soccerteam;


/**
 * This is the driver of the program, including an example of create a Team object and add 21
 * players to it, and then create the team. When running this driver, it will print out the
 * team information and the starting line up information.
 */
public class Driver {
  /**
   * Driver class.
   * @param args command line arguments not used.
   */
  public static void main(String[] args) {
    Team m = new TeamImpl();
    View v = new ViewImpl("Welcome to U10 Soccer Team Helper!");
    Features c = new ControllerImpl(m, v);
    c.setView(v);
  }
}