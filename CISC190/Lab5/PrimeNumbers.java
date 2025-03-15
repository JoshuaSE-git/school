import java.util.Scanner;

/**
 * Program to tell user whether input number is prime or not.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 3/6/2025 - (v1.0 Joshua Emralino)
 */
public class PrimeNumbers {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int number;
    boolean isPrime;

    System.out.print("Enter a number: ");
    number = input.nextInt();

    isPrime = testForPrime(number);

    if (isPrime) {
      System.out.printf("%d is prime.\n", number);
    } else {
      System.out.printf("%d is not prime.\n", number);
    }
  }

  /**
   * Produce true if input number is prime, false if not.
   *
   * @param num number to be tested
   * @return boolean result of prime test
   */
  public static boolean testForPrime(int num) {

    if (num == 1) {
      return false;
    }

    int numSqRt;
    numSqRt = (int) Math.sqrt(num);

    for (int i = 2; i <= numSqRt; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
