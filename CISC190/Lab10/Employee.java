/**
 * Employee class to represent employees of school; extends Person class.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/15/2025 - (v1.0 Joshua Emralino)
 */
public class Employee extends Person {

  private int hireYear;
  private String idNum;

  /** No-arg constructor for Employee instances. */
  public Employee() {
    super();
    hireYear = 0;
    idNum = "Onboarding";
  }

  /**
   * Constructor for Employee instances with name, id, and hire-year params.
   *
   * @param name name of the Employee instance
   * @param idNum id number of the Employee instance
   * @param hireYear year the Employee was hired
   */
  public Employee(String name, String idNum, int hireYear) {
    super(name);
    this.idNum = idNum;
    this.hireYear = hireYear;
  }

  /**
   * Takes in an Object and returns true if Object is Employee with identical idNum fields.
   *
   * @param o the object for comparison
   * @return boolean result of comparison
   */
  public boolean equals(Object o) {
    if (o != null && getClass() == o.getClass()) {
      Employee copy = (Employee) o;
      return idNum.equals(copy.idNum);
    }
    return false;
  }

  /**
   * Calculates and returns number of years in service.
   *
   * @return number of years in service
   */
  public int getServiceYears() {
    return CURRENT_YEAR - hireYear;
  }

  /**
   * Returns String representation of Employee instances.
   *
   * @return String representation of Employee instance
   */
  public String toString() {
    String str =
        String.format(
            "%s\nID Number: %s\nYear Hired: %d, Years of Service: %d",
            super.toString(), idNum, hireYear, getServiceYears());
    return str;
  }

  /**
   * Setter for hireYear field.
   *
   * @param hireYear new hireYear field value
   */
  public void setHireYear(int hireYear) {
    this.hireYear = hireYear;
  }

  /**
   * Setter for idNum field.
   *
   * @param idNum new idNum field value
   */
  public void setIdNum(String idNum) {
    this.idNum = idNum;
  }

  /**
   * Getter for hireYear field.
   *
   * @return current hireYear field value.
   */
  public int getHireYear() {
    return hireYear;
  }

  /**
   * Getter for idNum field.
   *
   * @return current idNum field value
   */
  public String getIdNum() {
    return idNum;
  }
}
