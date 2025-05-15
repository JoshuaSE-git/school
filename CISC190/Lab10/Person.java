/**
 * Person class that models a person with a name.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/13/2025 - (v1.0 Joshua Emralino)
 */
public class Person {

  static final int CURRENT_YEAR = 2025;

  private String name;

  /** No-arg contructor for Person instances; sets default name. */
  public Person() {
    name = "No name yet";
  }

  /**
   * Constructor for Person with name parameter.
   *
   * @param name name of the Person instance
   */
  public Person(String name) {
    this.name = name;
  }

  /**
   * Setter for name field.
   *
   * @param name new name of the Person instance
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for the name field.
   *
   * @return name of the Person instance
   */
  public String getName() {
    return name;
  }

  /**
   * Returns String representation of Person instance.
   *
   * @return String representation of Person instance
   */
  public String toString() {
    return String.format("Name: %s", name);
  }
}
