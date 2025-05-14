public class Adjunct extends Employee {

  private double hours;
  private double hrRate;

  public Adjunct() {
    super();
    hours = 0.0;
    hrRate = 0.0;
  }

  public Adjunct(String name, String idNum, int hireYear, double hours, double hrRate) {
    super(name, idNum, hireYear);
    this.hours = hours;
    this.hrRate = hrRate;
  }

  public String toString() {
    String str =
        String.format(
            "%s\nHours: %,.2f, Hourly Rate: $%,.2f, Salary: $%,.2f",
            super.toString(), hours, hrRate, getSalary());
    return str;
  }

  public double getSalary() {
    return hours * hrRate;
  }

  public void setHours(double hours) {
    this.hours = hours;
  }

  public void setHrRate(double hrRate) {
    this.hrRate = hrRate;
  }

  public double getHours() {
    return hours;
  }

  public double getHrRate() {
    return hrRate;
  }
}
