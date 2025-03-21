public class BankAccount {

  private double balance;
  private double deposit;
  private double withdraw;
  private double interest;
  private double monthlyIntRate;

  public BankAccount() {
    monthlyIntRate = 0.035 / 12;
  }

  public BankAccount(double inBalance, double inRate) {
    balance = inBalance;
    monthlyIntRate = inRate / 100 / 12;
  }

  public BankAccount(String inBalance, String inRate) {
    balance = Double.parseDouble(inBalance);
    monthlyIntRate = Double.parseDouble(inRate) / 100 / 12;
  }

  public void makeDeposit(int add) {
    balance += add;
  }

  public void makeDeposit(String add) {
    balance += Integer.parseInt(add);
  }

  public void makeWithdraw(int sub) {
    balance -= sub;
  }

  public void makeWithdraw(String sub) {
    balance -= Integer.parseInt(sub);
  }

  public void calcInterest() {
    // IMPLEMENT THIS
    return;
  }

  public double getBalance() {
    return balance;
  }

  public double getDeposit() {
    return deposit;
  }

  public double getWithdraw() {
    return withdraw;
  }

  public double getInterest() {
    return interest;
  }
}
