/**
 * Class for representing Citizen instances with a first and last name.
 *
 * @author Joshua Emralino (jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/22/2025 - (v1.0 Joshua Emralino)
 */
public class Citizen {
    private String firstName;
    private String lastName;

    /** No-arg constructor for Citizen instances. */
    public Citizen() {
        firstName = "No Name";
        lastName = "No Name";
    }

    /**
     * Constructor for Citizen instances with first and last name params.
     *
     * @param firstName first name of Citizen instance
     * @param lastName last name of Citizen instance
     */
    public Citizen(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Setter for firstName field.
     *
     * @param firstName new first name of Citizen instance
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for firstName field.
     *
     * @return first name of Citizen instance
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for lastName field.
     *
     * @param lastName new last name of Citizen instance
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for lastName field.
     *
     * @return last name of Citizen instance
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns String representation of Citizen instance.
     *
     * @return String representation of Citizen instance.
     */
    public String toString() {
        return firstName + " " + lastName;
    }
}
