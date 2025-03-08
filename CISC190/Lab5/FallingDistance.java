import java.util.Scanner;

/**
 * Generate a table that shows distance in free fall for different times.
 *
 * @author Joshua Emralino
 * @version v1.0
 * @since 3/6/2025 - (v1.0 Joshua Emralino)
 */
public class FallingDistance {

  public static final double ACCELERATION = 9.8;

  public static void main(String[] args) {

    int seconds;

    Scanner input = new Scanner(System.in);

    System.out.print("Please enter how many seconds to compute: ");
    seconds = input.nextInt();
    System.out.println();

    printHeaders();
    for (int i = 1; i <= seconds; i++) {
      printRow(i);
    }

    input.close();
  }

  /**
   * Produces distance traveled based on inputted seconds.
   *
   * @param seconds current time in falling motion
   * @return distance traveled after x seconds
   */
  public static double getDistance(int seconds) {

    double distance = 0.5 * ACCELERATION * seconds * seconds;

    return distance;
  }

  /** Print headers for falling distance table. */
  public static void printHeaders() {

    System.out.println("Time(secs)  Distance(m)");
    System.out.println("==========  ===========");
  }

  /**
   * Print row of falling distance table.
   *
   * @param seconds the current time in falling motion
   */
  public static void printRow(int seconds) {

    System.out.printf("%-12d%-11.2f\n", seconds, getDistance(seconds));
  }
}
