import java.util.Scanner;
/**
 * Program to display information about my name.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 2/6/2025 - (v1.0 Joshua Emralino)
 */
public class ProgChall2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName, middleName, lastName;

        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter your middle name: ");
        middleName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        lastName = scanner.nextLine();
        System.out.println("");

        char firstInit, middleInit, lastInit;

        firstInit = firstName.charAt(0);
        middleInit = middleName.charAt(0);
        lastInit = lastName.charAt(0);

        System.out.println("My name is: " + firstName + " "
            + middleName + " " + lastName);
        System.out.println("My initials are: " + firstInit +
            middleInit + lastInit);
    }
}
