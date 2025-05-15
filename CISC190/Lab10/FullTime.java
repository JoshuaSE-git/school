/**
 * Fulltime class to represent full-time professors; extends Employee
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/15/2025 - (v1.0 Joshua Emralino)
 */
public class FullTime extends Employee {

  private double salary;

  /** No-arg constructor for FullTime instances. */
  public FullTime() {
    super();
    salary = 0.0;
  }

  /**
   * Constructor for FullTime instances with name, idNum, hireYear, and salary fields.
   *
   * @param name name of FullTime instance
   * @param idNum id number for FullTime instance
   * @param hireYear year the FullTime instance was hired
   * @param salary salary of FullTime instance
   */
  public FullTime(String name, String idNum, int hireYear, double salary) {
    super(name, idNum, hireYear);
    this.salary = salary;
  }

  /**
   * Returns String representation of FullTime instance.
   *
   * @return String representation of FullTime instance
   */
  public String toString() {
    String str = String.format("%s\nSalary: $%,.2f", super.toString(), salary);
    return str;
  }

  /**
   * Setter for salary field.
   *
   * @param salary new salary of FullTime instance
   */
  public void setSalary(double salary) {
    this.salary = salary;
  }

  /**
   * Getter for salary field.
   *
   * @return salary of FullTime instance
   */
  public double getSalary() {
    return salary;
  }
}
