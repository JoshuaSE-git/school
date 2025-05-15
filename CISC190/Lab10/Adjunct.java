/**
 * Adjunct class to represent part-time professors; extends Employee
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/15/2025 - (v1.0 Joshua Emralino)
 */
public class Adjunct extends Employee {

  private double hours;
  private double hrRate;

  /** No-arg constructor for Adjunct instances. */
  public Adjunct() {
    super();
    hours = 0.0;
    hrRate = 0.0;
  }

  /**
   * Constructor for Adjunct instances with name, idNum, hireYear, hours, and hrRate field.
   *
   * @param name name of Adjunct instance
   * @param idNum id number for Adjunct instance
   * @param hireYear year Adjunct instance was hired
   * @param hours total hours worked by Adjunct instance
   * @param hrRate hourly rate of Adjunct instance
   */
  public Adjunct(String name, String idNum, int hireYear, double hours, double hrRate) {
    super(name, idNum, hireYear);
    this.hours = hours;
    this.hrRate = hrRate;
  }

  /**
   * Returns String representation of Adjunct instances.
   *
   * @return String representatino of Adjunct instance.
   */
  public String toString() {
    String str =
        String.format(
            "%s\nHours: %,.2f, Hourly Rate: $%,.2f, Salary: $%,.2f",
            super.toString(), hours, hrRate, getSalary());
    return str;
  }

  /**
   * Calculates salary (hours * hrRate) and returns it.
   *
   * @return salary of Adjunct instance
   */
  public double getSalary() {
    return hours * hrRate;
  }

  /**
   * Setter for hours field.
   *
   * @param hours number of hours worked by Adjunct instance
   */
  public void setHours(double hours) {
    this.hours = hours;
  }

  /**
   * Setter for hrRate field.
   *
   * @param hrRate new hourly rate of Adjunct instance
   */
  public void setHrRate(double hrRate) {
    this.hrRate = hrRate;
  }

  /**
   * Getter for hours field.
   *
   * @return number of hourse worked by Adjunct instance
   */
  public double getHours() {
    return hours;
  }

  /**
   * Getter for hrRate field.
   *
   * @return hourly rate of Adjunct instance
   */
  public double getHrRate() {
    return hrRate;
  }
}
