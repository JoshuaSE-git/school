import java.util.Scanner;
/**
 * Program to display information about a city.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 2/6/2025 - (v1.0 Joshua Emralino)
 */
public class ProgChall12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String cityName;

        System.out.print("Enter a city: ");
        cityName = scanner.nextLine();
        System.out.println("");

        System.out.println("The city entered has: " + cityName.length() + " chars");
        System.out.println("In upper case: " + cityName.toUpperCase());
        System.out.println("In lower case: " + cityName.toLowerCase());
        System.out.println("First character: " + cityName.charAt(0));
    }
}
