import java.util.Random;

/**
 * Program to display 3 random numbers and how many multiples of 100 they contain.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 3/4/2025 - (v1.0 Joshua Emralino)
 */
public class BarChart {

  public static void main(String[] args) {

    Random randomNumber = new Random();

    int number1 = randomNumber.nextInt(1000);
    int number2 = randomNumber.nextInt(1000);
    int number3 = randomNumber.nextInt(1000);

    System.out.printf("Number 1 is: %d\n", number1);
    System.out.printf("Number 2 is: %d\n", number2);
    System.out.printf("Number 3 is: %d\n", number3);

    System.out.println("\nNUMBER BAR CHART");
    printRow(number1);
    printRow(number2);
    printRow(number3);
  }

  /**
   * Print an individual row showing how many multiples of 100 are in a number.
   *
   * @param number the number to be used for the row
   */
  public static void printRow(int number) {

    System.out.printf("Number %d is: ", number);

    if (number < 100) {
      System.out.print("<100 no stars");
    } else {
      for (int i = 0; i < number / 100; i++) {
        System.out.print("*");
      }
    }

    System.out.println();
  }
}
