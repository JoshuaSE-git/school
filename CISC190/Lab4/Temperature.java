import java.util.Scanner;

/**
 * Program to convert temperatures between Celcius and Fahrenheit.
 *
 * @author Joshua Emralino
 * @version v1.0
 * @since 3/5/2025 - (v1.0 Joshua Emralino)
 */
public class Temperature {

  public static void main(String[] args) {

    int inputTemp;
    char inputUnit;
    double output;

    Scanner keyboard = new Scanner(System.in);

    do {
      System.out.print("Enter a whole number, a space, and C or F " + "ie 100 F converts to C: ");
      inputTemp = keyboard.nextInt();
      inputUnit = keyboard.next().toUpperCase().charAt(0);

      while (!(inputUnit == 'C' || inputUnit == 'F')) {
        System.out.print("Enter a C or F, F converts to C: ");
        inputUnit = keyboard.next().toUpperCase().charAt(0);
      }

      if (inputUnit == 'F') {
        output = (inputTemp - 32) * 5 / 9;
        System.out.printf("\n%d%c converted is %.1fC\n", inputTemp, inputUnit, output);
      } else {
        output = inputTemp * 9 / 5 + 32;
        System.out.printf("\n%d%c converted is %.1fF\n", inputTemp, inputUnit, output);
      }

      System.out.print("\nEnter yes to calculate another temp: ");
    } while (keyboard.next().equalsIgnoreCase("yes"));
  }
}
