/**
 * BankAccount class to track and manage financial operations.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 3/27/2025 - (v1.0 Joshua Emralino)
 */
public class BankAccount {

  private double balance;
  private double deposit;
  private double withdraw;
  private double interest;
  private double monthlyIntRate;

  /** No-arg constructor for BankAccount instances. Sets default 3.5 interest. */
  public BankAccount() {
    monthlyIntRate = 0.035 / 12;
  }

  /**
   * Constructor for BankAccount instances with balance and interest rate params.
   *
   * @param inBalance starting balance
   * @param inRate annual interest rate
   */
  public BankAccount(double inBalance, double inRate) {
    balance = inBalance;
    monthlyIntRate = (inRate / 100) / 12;
  }

  /**
   * Constructor for BankAccount instances with balance and interest rate params.
   *
   * @param inBalance starting balance
   * @param inRate annual interest rate
   */
  public BankAccount(String inBalance, String inRate) {
    balance = Double.parseDouble(inBalance);
    monthlyIntRate = Double.parseDouble(inRate) / 100 / 12;
  }

  /**
   * Adds input deposit to balance and deposit fields.
   *
   * @param add the amount to be deposited
   */
  public void makeDeposit(double add) {
    deposit += add;
    balance += add;
  }

  /**
   * Adds input amount to balance and deposit fields.
   *
   * @param add the amount to be deposited
   */
  public void makeDeposit(String add) {
    deposit += Double.parseDouble(add);
    balance += Double.parseDouble(add);
  }

  /**
   * Subtracts input amount from balance field. Adds to withdraw field.
   *
   * @param sub the amount to be withdrawn
   */
  public void makeWithdraw(double sub) {
    withdraw += sub;
    balance -= sub;
  }

  /**
   * Subtracts input amount from balance field. Adds to withdraw field.
   *
   * @param sub the amount to be withdrawn
   */
  public void makeWithdraw(String sub) {
    withdraw += Double.parseDouble(sub);
    balance -= Double.parseDouble(sub);
  }

  /**
   * Calculates monthly interest and adds that amount to balance and interest fields. If balance is
   * less than 0, adds 0 to both fields instead.
   */
  public void calcInterest() {
    double monthlyInterest = balance > 0 ? balance * monthlyIntRate : 0;
    balance += monthlyInterest;
    interest += monthlyInterest;
  }

  /**
   * Returns the current balance.
   *
   * @return current balance
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Returns the running total amount of all deposits made.
   *
   * @return total deposits
   */
  public double getDeposit() {
    return deposit;
  }

  /**
   * Returns the running total amount of all withdrawals made.
   *
   * @return total withdrawals
   */
  public double getWithdraw() {
    return withdraw;
  }

  /**
   * Returns the running total amount of all interest accumulated.
   *
   * @return accumulated interest
   */
  public double getInterest() {
    return interest;
  }
}
