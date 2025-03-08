import javax.swing.JOptionPane;

/**
 * Program to tell user whether input number is prime or not
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 3/6/2025 - (v1.0 Joshua Emralino)
 */
public class PrimeNumbers {

  public static void main(String[] args) {

    int number;

    number =
        Integer.parseInt(JOptionPane.showInputDialog("Enter a whole number to test if prime."));

    if (testForPrime(number)) {
      JOptionPane.showMessageDialog(null, String.format("%d is prime.", number));
    } else {
      JOptionPane.showMessageDialog(null, String.format("%d is not prime.", number));
    }
  }

  /**
   * Produce true if input number is prime, false if not
   *
   * @param num number to be tested
   * @return boolean result of prime test
   */
  public static boolean testForPrime(int num) {
    return false;
  }
}
