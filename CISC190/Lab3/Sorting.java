import java.util.Scanner;
/**
 * Write a program to sort 3 numbers in increasing order
 *
 * @author Joshua Emralino
 * @version v1.0
 * @since 2/25/2025 - (v1.0 Joshua Emralino)
 */
public class Sorting {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int firstInput, secondInput, thirdInput;
        int low, med, high;

        System.out.print("Enter the first number: ");
        firstInput = input.nextInt();
        System.out.print("Enter the second number: ");
        secondInput = input.nextInt();
        System.out.print("Enter the third number: ");
        thirdInput = input.nextInt();
        System.out.println("");

        if (firstInput < secondInput && firstInput < thirdInput) {
            low = firstInput;

            if (secondInput < thirdInput) {
                med = secondInput;
                high = thirdInput;
            } else {
                med = thirdInput;
                high = secondInput;
            }

        } else if (secondInput < thirdInput) {
            low = secondInput;

            if (firstInput < thirdInput) {
                med = firstInput;
                high = thirdInput;
            } else {
                med = thirdInput;
                high = secondInput;
            }

        } else {
            low = thirdInput;

            if (firstInput < secondInput) {
                med = firstInput;
                high = secondInput;
            } else {
                med = secondInput;
                high = firstInput;
            }
        }

        System.out.println("low = " + low + " med = " + med + " high = " + high);
    }
}
