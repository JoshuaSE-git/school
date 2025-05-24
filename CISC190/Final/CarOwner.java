/**
 * Class for representing CarOwner with license, month, and year fields; extends Citizen.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/22/2025 - (v1.0 Joshua Emralino)
 */
public class CarOwner extends Citizen {
    private String license;
    private int month;
    private int year;

    /** No-arg constructor for CarOwner instances. */
    public CarOwner() {
        super();
        license = "Not Assigned";
        month = 0;
        year = 0;
    }

    /**
     * Constructor for CarOwner instances with all field params.
     *
     * @param firstName first name of CarOwner instance
     * @param lastName last name of CarOwner instance
     * @param license license number of CarOwner instance
     * @param month registration month of CarOwner instance
     * @param year registration year of CarOwner instance
     */
    public CarOwner(String firstName, String lastName, String license, int month, int year) {
        super(firstName, lastName);
        this.license = license;
        this.month = month;
        this.year = year;
    }

    /**
     * Getter for license field.
     *
     * @return license number of CarOwner instance
     */
    public String getLicense() {
        return license;
    }

    /**
     * Setter for license field.
     *
     * @param license new license number of CarOwner instance
     */
    public void setLicense(String license) {
        this.license = license;
    }

    /**
     * Getter for month field.
     *
     * @return registration month of CarOwner instance
     */
    public int getMonth() {
        return month;
    }

    /**
     * Setter for month field.
     *
     * @param month new registration month of CarOwner instance
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Getter for year field.
     *
     * @return registration year of CarOwner instance
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter for year field.
     *
     * @param year new registration year of CarOwner instance
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Return String representation of CarOwner instance.
     *
     * @return String representation of CarOwner instance
     */
    public String toString() {
        return String.format("%s\t%s\t%d/%d", super.toString(), license, month, year);
    }
}