import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Application that tests BankAccount class functionality.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 3/27/2025 - (v1.0 Joshua Emralino)
 */
public class BankAccountDemo {

  public static void main(String[] args) {
    String userChoice;
    Scanner keyboard = new Scanner(System.in);

    do {
      System.out.print("Press 1 to use console or 2 to use GUI: ");
      userChoice = keyboard.nextLine().trim();
    } while (!userChoice.equals("1") && !userChoice.equals("2"));

    if (userChoice.equals("1")) {
      useConsole();
    } else {
      useGUI();
    }

    System.exit(0);
  }

  /**
   * Initializes BankAccount instance and performs operations based on user input. Uses console
   * interface
   */
  public static void useConsole() {
    Scanner keyboard = new Scanner(System.in);
    System.out.print("What is your starting balance: $");
    double balance = keyboard.nextDouble();
    System.out.print("What is your interest rate? (ie enter 3.5 for 3.5%): ");
    double intRate = keyboard.nextDouble();
    System.out.print("How many months do you want to calculate?: ");
    int counter = keyboard.nextInt();
    BankAccount bankAccount = new BankAccount(balance, intRate);

    System.out.println("===============================");
    for (int i = 1; i <= counter; i++) {
      System.out.print("Enter Month " + i + " deposits: $");
      bankAccount.makeDeposit(keyboard.nextDouble());
      System.out.print("Enter Month " + i + " withdraws: $");
      bankAccount.makeWithdraw(keyboard.nextDouble());
      bankAccount.calcInterest();
    }

    System.out.printf("\nEnding balance: $%,.2f", bankAccount.getBalance());
    System.out.printf("\nTotal deposits: $%,.2f", bankAccount.getDeposit());
    System.out.printf("\nTotal withdraw: $%,.2f", bankAccount.getWithdraw());
    System.out.printf("\nTotal interest: $%,.2f\n", bankAccount.getInterest());
  }

  /**
   * Initializes BankAccount instance and performs operations based on user input. Uses GUI
   * interface
   */
  public static void useGUI() {
    String origBal = JOptionPane.showInputDialog("What is your starting balance");
    String intRate =
        JOptionPane.showInputDialog("What is your interest rate? (ie enter 3.5 for 3.5%)");
    String strCtr = JOptionPane.showInputDialog("How many months do you want to calculate?");
    int counter = Integer.parseInt(strCtr);
    BankAccount bankAccount = new BankAccount(origBal, intRate);

    for (int i = 1; i <= counter; i++) {
      bankAccount.makeDeposit(JOptionPane.showInputDialog("Enter Month " + i + " deposits"));
      bankAccount.makeWithdraw(JOptionPane.showInputDialog("Enter Month " + i + " withdraws"));
      bankAccount.calcInterest();
    }

    JOptionPane.showMessageDialog(
        null,
        String.format("Ending balance: $%,.2f", bankAccount.getBalance())
            + String.format("\nTotal deposits: $%,.2f", bankAccount.getDeposit())
            + String.format("\nTotal withdraw: $%,.2f", bankAccount.getWithdraw())
            + String.format("\nTotal interest: $%,.2f", bankAccount.getInterest()));
  }
}
