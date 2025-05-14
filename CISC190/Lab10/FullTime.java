public class FullTime extends Employee {

  private double salary;

  public FullTime() {
    super();
    salary = 0.0;
  }

  public FullTime(String name, String idNum, int hireYear, double salary) {
    super(name, idNum, hireYear);
    this.salary = salary;
  }

  public String toString() {
    String str = String.format("%s\nSalary: $%,.2f", super.toString(), salary);
    return str;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public double getSalary() {
    return salary;
  }
}
