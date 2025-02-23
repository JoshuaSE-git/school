import java.util.Scanner;
/**
 * Write a program to compute total restauraunt
 * bill after tax and tip.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 2/6/2025 - (v1.0 Joshua Emralino)
 */
public class ProgChall13 {

    public static void main(String[] args) {

        final double TAX_PERCENT = .0675;
        final double TIP_PERCENT = .2;

        double mealAmount, taxAmount, tipAmount;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter meal amount: $");
        mealAmount = scanner.nextDouble();
        System.out.println("");

        taxAmount = TAX_PERCENT * mealAmount;
        tipAmount = TIP_PERCENT * mealAmount; 

        System.out.printf("The tax is: $%,.2f\n", taxAmount); 

        System.out.printf("The tip is: $%,.2f\n", tipAmount);

        System.out.printf("The meal cost with tax and tip is: $%,.2f\n", (mealAmount + taxAmount + tipAmount));
    }
}

