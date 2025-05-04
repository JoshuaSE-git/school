import java.util.Scanner;

/**
 * Application for testing CarpetCost class.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/1/2025 - (v1.0 Joshua Emralino)
 */
public class CarpetCostDemo {

  public static void main(String[] args) {
    CarpetCost roomOne, roomTwo;

    roomOne = getCarpetCost();
    System.out.println("\n" + roomOne + "\n");
    roomTwo = getCarpetCost();
    System.out.println("\n" + roomTwo);
  }

  /**
   * Create new CarpetCost object from user input.
   *
   * @return CarpetCost object
   */
  private static CarpetCost getCarpetCost() {
    Scanner keyScanner = new Scanner(System.in);
    String name;
    double length, width, cost;

    System.out.print("Enter Room Name: ");
    name = keyScanner.nextLine();
    System.out.print("Enter room length: ");
    length = keyScanner.nextDouble();
    System.out.print("Enter room width: ");
    width = keyScanner.nextDouble();
    System.out.print("Enter cost per square foot: ");
    cost = keyScanner.nextDouble();
    keyScanner.nextLine();

    return new CarpetCost(new RoomSize(name, length, width), cost);
  }
}
