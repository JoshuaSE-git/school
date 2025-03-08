import java.util.Scanner;

/**
 * Program to determine whether a series of words are palindromes.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 3/6/2025 - (v1.0 Joshua Emralino)
 */
public class ReverseWord {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    String inputString, remaining, combined, reversed, choice;
    char firstChar;

    do {
      System.out.println("Enter words seperated by a space ending with the word quit: ");
      inputString = keyboard.next().toLowerCase();
      System.out.println();

      while (!inputString.equals("quit")) {

        firstChar = inputString.charAt(0);
        remaining = inputString.substring(1);
        combined = remaining + firstChar;
        reversed = "";

        for (int i = combined.length() - 1; i >= 0; i--) {
          reversed += combined.charAt(i);
        }

        if (reversed.equals(inputString)) {
          System.out.printf("%s works\n", inputString);
        } else {
          System.out.printf("%s does not work\n", inputString);
        }

        inputString = keyboard.next().toLowerCase();
      }

      System.out.print("\nEnter yes to process another line: ");
      keyboard.nextLine();
      choice = keyboard.nextLine();
    } while (choice.equalsIgnoreCase("yes"));
  }
}
