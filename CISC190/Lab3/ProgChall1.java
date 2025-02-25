import java.util.Scanner;
/**
 * Program to convert integers 1-3 to Roman numerals
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 2/25/2025 - (v1.0 Joshua Emralino)
 */
public class ProgChall1 {

    public static void main(String[] args) {

        int numberInput;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer between 1 and 3: ");
        numberInput = input.nextInt();
        System.out.println("");

        switch (numberInput) {
            case 1:
                System.out.println("1 is I in Roman Numerals");
                break;
            case 2:
                System.out.println("2 is II in Roman Numerals");
                break;
            case 3:
                System.out.println("3 is III in Roman Numerals");
                break;
            default:
                System.out.println("Invalid input.  Enter an integer between 1 and 3");
        }
    }
}
