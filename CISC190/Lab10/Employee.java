public class Employee extends Person {

  private int hireYear;
  private String idNum;

  public Employee() {
    super();
    hireYear = 0;
    idNum = "Onboarding";
  }

  public Employee(String name, String idNum, int hireYear) {
    super(name);
    this.idNum = idNum;
    this.hireYear = hireYear;
  }

  public boolean equals(Object o) {
    if (o != null && getClass() == o.getClass()) {
      Employee copy = (Employee) o;
      return idNum.equals(copy.idNum);
    }
    return false;
  }

  public int getServiceYears() {
    return CURRENT_YEAR - hireYear;
  }

  public String toString() {
    String str =
        String.format(
            "%s\nID Number: %s\nYear Hired: %d, Years of Service: %d",
            super.toString(), idNum, hireYear, getServiceYears());
    return str;
  }

  public void setHireYear(int hireYear) {
    this.hireYear = hireYear;
  }

  public void setIdNum(String idNum) {
    this.idNum = idNum;
  }

  public int getHireYear() {
    return hireYear;
  }

  public String getIdNum() {
    return idNum;
  }
}
