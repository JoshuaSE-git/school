import java.util.Scanner;

/**
 * Program to print a diamond in ASCII based on input width.
 *
 * @author Joshua Emralino, jemralino@sdccd.edu
 * @version v1.0
 * @since 3/6/2025 - (v1.0 Joshua Emralino)
 */
public class Flashback {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int inputWidth;

    System.out.print("Enter max width of diamond: ");
    inputWidth = input.nextInt();

    if (inputWidth % 2 == 0) {
      inputWidth++;
    }

    // Print upper half of diamond, isReversed set to false.
    printHalfDiamond(inputWidth, false);

    // Print middle row of the diamond.
    printStars(inputWidth);
    System.out.println();

    // Print lower half of diamond, isReversed set to true.
    printHalfDiamond(inputWidth, true);
  }

  /**
   * Print a line of spaces based on input.
   *
   * @param spaces the amount of spaces to print
   */
  public static void printSpaces(int spaces) {

    for (int i = 0; i < spaces; i++) {
      System.out.print(" ");
    }
  }

  /**
   * Print a line of stars based on input.
   *
   * @param stars the amount of stars to print
   */
  public static void printStars(int stars) {

    for (int i = 0; i < stars; i++) {
      System.out.print("*");
    }
  }

  /**
   * Print half of the diamond based on input width and orientation.
   *
   * @param width width of the diamond in characters
   * @param isReversed toggle for printing lower half diamond
   */
  public static void printHalfDiamond(int width, boolean isReversed) {

    if (isReversed) {
      for (int row = width / 2 - 1; row >= 0; row--) {

        int spaces = width / 2 - row;
        int stars = (row + 1) * 2 - 1;

        printSpaces(spaces);
        printStars(stars);

        System.out.println();
      }
    } else {
      for (int row = 0; row < width / 2; row++) {

        int spaces = width / 2 - row;
        int stars = (row + 1) * 2 - 1;

        printSpaces(spaces);
        printStars(stars);

        System.out.println();
      }
    }
  }
}
