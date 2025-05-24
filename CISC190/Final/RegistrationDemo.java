import java.io.IOException;

/**
 * Application that tests Citizen, CarOwner, and RegistrationMethod classes.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/24/2025 - (v1.0 Joshua Emralino)
 */
public class RegistrationDemo {
    public static void main(String[] args) throws IOException {
        int arrSize;
        CarOwner[] ltState, overdue, almostDue;
        String outputPath;

        RegistrationMethods dmv = new RegistrationMethods();

        dmv.setFileNames();
        arrSize = dmv.getArraySize();
        ltState = new CarOwner[arrSize];
        dmv.processTextToArray(ltState);
        dmv.printArrayToFile("List of Car Owners", ltState);
        overdue = dmv.flagOverdueOwners(ltState);
        dmv.printArrayToFile("Owners with Expired Registration", overdue);
        almostDue = dmv.flagAlmostDueOwners(ltState);
        dmv.printArrayToFile("Owners with registration expiring in three months or less", almostDue);
        outputPath = dmv.getOutputFileName();
        System.out.println("The output file can be found at: " + outputPath);
    }
}
