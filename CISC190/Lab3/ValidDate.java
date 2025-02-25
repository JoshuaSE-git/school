import java.util.Scanner;
/**
 * Program to validate a user-inputted date.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 2/25/2025 - (v1.0 Joshua Emralino)
 */
public class ValidDate {

    public static void main (String[] args) {
        int month, day, year;
        String output = "";

        Scanner input = new Scanner(System.in).useDelimiter("/");

        System.out.print("Enter a date in MM/DD/YYYY format: ");
        month = input.nextInt();
        day = input.nextInt();
        year = Integer.parseInt(input.nextLine().substring(1)); 
       
        boolean isValid = false;

        if (day < 1) {
            output = "Can never have less than 1 day in a month";
        } else if (day > 31) {
            output = "Can never have more than 31 days in a month.";
        } else {  
            switch (month) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    isValid = true;
                    break;

                case 4: case 6: case 9: case 11:
                    if (day <= 30) {
                        isValid = true;
                    } else {
                        output = "Can not have 31 days for this month.";
                    }
                    break;

                case 2:
                    boolean isLeapYear = false;
                   
                    if (year % 400 == 0 || (year % 4 == 0 && !(year % 100 == 0))) {
                        isLeapYear = true;
                    }
                       
                    if (isLeapYear) {
                            if (day <= 29) {
                                isValid = true;
                            } else {
                                output = "Can not have 30 or more days in a leap year.";
                            }
                    } else {
                            if (day <= 28) {
                                isValid = true;
                            } else {
                                output = "Can not have 29 or more days in a non-leap year.";
                            }
                    }
                    break;

                default:
                    output = "Months must be between 1 and 12.";
                }
            }

        if (isValid) {
            System.out.printf("%d/%d/%d is a valid date.\n", month, day, year);
        } else {
            System.out.printf("%d/%d/%d is not a valid date.  " + output + "\n", month, day, year);
        }
    }
}
