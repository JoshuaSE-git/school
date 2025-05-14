public class HRDemo {

  public static void main(String[] args) {
    FullTime fred = new FullTime("Flintstone, Fred", "BR-1", 2013, 75000.1234);
    Adjunct barney = new Adjunct("Rubble, Barney", "BR-2", 2014, 320.0, 60.55);
    FullTime wilma = new FullTime();
    wilma.setName("Flintstone, Wilma");
    wilma.setIdNum("BR-3");
    wilma.setHireYear(2016);
    wilma.setSalary(78123.2468);
    Employee betty = new Employee("Rubble, Betty", "BR-4", 2020);
    FullTime wilma2 = new FullTime("Slate, Wilma", "BR-3", 2016, 78123.2468);

    Employee[] staff = {fred, barney, wilma, betty, wilma2};
    printStaff(staff);

    System.out.printf(
        "wilma and wilma2 are the same person: %b\n\n",
        wilma.getName(), wilma2.getName(), wilma.equals(wilma2));
    wilma.setName("Slate, Wilma");

    Employee[] staff2 = {fred, barney, wilma, betty};
    printStaff(staff2);
  }

  private static void printStaff(Employee[] staff) {
    for (int i = 0; i < staff.length; i++) {
      System.out.printf("Employee %d\n", i + 1);
      System.out.println(staff[i]);
      System.out.println();
    }
  }
}
