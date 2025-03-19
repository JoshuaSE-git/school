import java.util.Scanner;

/**
 * Triangle class for creating Triangle objects with a name, base, and height.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 3/18/25 - (v1.0 Joshua Emralino)
 */
public class Triangle {

  private String name;
  private double base;
  private double height;

  /** No-arg constructor for Triangle instances. Sets default values. */
  public Triangle() {
    name = "Unknown";
    base = 0.0;
    height = 0.0;
  }

  /**
   * Constructor for Triangle instances with name, base, and height params.
   *
   * @param inName name of triangle instance (String)
   * @param inBase base of triangle instance (double)
   * @param inHeight height of triangle instance (double)
   */
  public Triangle(String inName, double inBase, double inHeight) {
    name = inName;
    base = inBase;
    height = inHeight;
  }

  /** Displays fields of triangle instance. */
  public void writeOutput() {
    System.out.printf("Triangle name is: %s\n", name);
    System.out.printf("Triangle base is: %.1f\n", base);
    System.out.printf("Triangle height is: %.1f\n", height);
    System.out.printf("Triangle area is: %.1f\n", getArea());
  }

  /** Reads input from user and sets fields of triangle instance. */
  public void readInput() {
    Scanner keyInput = new Scanner(System.in);
    System.out.print("What is the triangle's name: ");
    setName(keyInput.nextLine());
    System.out.print("What is the triangle's base: ");
    setBase(Double.parseDouble(keyInput.nextLine()));
    System.out.print("What is the triangle's height: ");
    setHeight(Double.parseDouble(keyInput.nextLine()));
  }

  /**
   * Setter for name field.
   *
   * @param newName new name of triangle
   */
  public void setName(String newName) {
    name = newName;
  }

  /**
   * Setter for base field.
   *
   * @param newBase new base of triangle
   */
  public void setBase(double newBase) {
    base = newBase;
  }

  /**
   * Setter for height field.
   *
   * @param newHeight new height of triangle
   */
  public void setHeight(double newHeight) {
    height = newHeight;
  }

  /**
   * Return area of triangle instance (base * height / 2).
   *
   * @return area of triangle
   */
  private double getArea() {
    return base * height / 2;
  }
}
