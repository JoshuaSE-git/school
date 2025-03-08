import javax.swing.JOptionPane;

/**
 * Program to count how many times a character appears in a string.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 3/4/2025 - (v1.0 Joshua Emralino)
 */
public class ProgChall5 {

  public static void main(String[] args) {
    String inputString;
    char inputChar;

    int counter = 0;

    inputString = JOptionPane.showInputDialog("Enter a string");
    inputChar = JOptionPane.showInputDialog("Enter a char to be assessed").trim().charAt(0);

    for (int i = 0; i < inputString.length(); i++) {
      if (inputString.charAt(i) == inputChar) {
        counter++;
      }
    }

    JOptionPane.showMessageDialog(
        null,
        "In the phrase: " + inputString + String.format("\nThere are %d %c's", counter, inputChar));

    System.exit(0);
  }
}
