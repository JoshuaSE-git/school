import java.util.Scanner;
import java.io.*;

/**
 * Class for providing car registration operations via a RegistrationMethods instance.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/24/2025 - (v1.0 Joshua Emralino)
 */
public class RegistrationMethods {
    private static final int REG_MONTH = 4;
    private static final int REG_YEAR = 2025;

    private String inputFileName;
    private String outputFileName;

    /** Prompts user to initialize input/output filepath names */
    public void setFileNames() {
        String inputFileName;
        File tempFile;
        Scanner keyScanner = new Scanner(System.in);

        System.out.println("Enter the path to the registrations.csv file (ie /tmp/registration.csv):");
        inputFileName = keyScanner.nextLine().trim();
        tempFile = new File(inputFileName);
        while (!tempFile.exists()) {
            System.out.println("The file " + inputFileName + " does not exist.");
            System.out.println("Enter the path to the registrations.csv file (ie /tmp/registration.csv):");
            inputFileName = keyScanner.nextLine().trim();
            tempFile = new File(inputFileName);
        }
        this.inputFileName = inputFileName;

        System.out.println("Enter the path where output.txt should be saved (ie /tmp/output.txt):");
        this.outputFileName = keyScanner.nextLine().trim();
    }

    /**
     * Calculates and returns number of car owners from a csv file (inputFileName field).
     *
     * @return number of car owners
     */
    public int getArraySize() throws IOException {
        int count = 0;
        Scanner fileScanner = new Scanner(new File(inputFileName));
        fileScanner.nextLine();
        while (fileScanner.hasNextLine()) {
            count++;
            fileScanner.nextLine();
        }
        return count;
    }

    /**
     * Takes in CarOwner array and overwrites elements with CarOwner objects from csv file (inputFileName field).
     *
     * @param inArray CarOwner array with initialized size.
     */
    public void processTextToArray(CarOwner[] inArray) throws IOException {
        Scanner fileScanner = new Scanner(new File(inputFileName));
        fileScanner.nextLine();
        int i = 0;
        while (fileScanner.hasNextLine()) {
            String[] tokens = fileScanner.nextLine().split(",");
            inArray[i] = new CarOwner(
                    tokens[1],
                    tokens[0],
                    tokens[2],
                    Integer.parseInt(tokens[3]),
                    Integer.parseInt(tokens[4])
            );
            i++;
        }
        fileScanner.close();
    }

    /**
     * Processes CarOwner array and writes its elements to outputFileName path; inMsg is a header String.
     *
     * @param inMsg a header String
     * @param inArray CarOwner array containing CarOwner instances
     */
    public void printArrayToFile(String inMsg, CarOwner[] inArray) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(outputFileName, true));
        writer.println(inMsg);
        for (CarOwner carOwner : inArray) {
            writer.println(carOwner);
        }
        writer.println();
        writer.close();
    }

    /**
     * Takes in CarOwner array and returns a new CarOwner array containing overdue CarOwners.
     *
     * @param inArray CarOwner array of CarOwner instances
     * @return CarOwner array of overdue CarOwner instances
     */
    public CarOwner[] flagOverdueOwners(CarOwner[] inArray) {
        CarOwner[] outArray;

        int overdueCount = 0;
        for (CarOwner carOwner : inArray) {
            int activeMonths = (REG_YEAR * 12 + REG_MONTH) - (carOwner.getYear() * 12 + carOwner.getMonth());
            if (activeMonths > 12) {
                overdueCount++;
            }
        }

        outArray = new CarOwner[overdueCount];
        int i = 0;
        for (CarOwner carOwner : inArray) {
            int activeMonths = (REG_YEAR * 12 + REG_MONTH) - (carOwner.getYear() * 12 + carOwner.getMonth());
            if (activeMonths > 12) {
                outArray[i] = carOwner;
                i++;
            }
        }

        return outArray;
    }

    /**
     * Takes in CarOwner array and returns a new CarOwner array containing almost overdue CarOwners.
     *
     * @param inArray CarOwner array of CarOwner instances
     * @return CarOwner array of almost overdue CarOwner instances
     */
    public CarOwner[] flagAlmostDueOwners(CarOwner[] inArray) {
        CarOwner[] outArray;

        int almostDue = 0;
        for (CarOwner carOwner : inArray) {
            int activeMonths = (REG_YEAR * 12 + REG_MONTH) - (carOwner.getYear() * 12 + carOwner.getMonth());
            if (activeMonths >= 10 && activeMonths <= 12) {
                almostDue++;
           }
        }

        outArray = new CarOwner[almostDue];
        int i = 0;
        for (CarOwner carOwner : inArray) {
            int activeMonths = (REG_YEAR * 12 + REG_MONTH) - (carOwner.getYear() * 12 + carOwner.getMonth());
            if (activeMonths >= 10 && activeMonths <= 12) {
                outArray[i] = carOwner;
                i++;
            }
        }

        return outArray;
    }

    /**
     * Getter for outputFileName field.
     *
     * @return outputFileName field
     */
    public String getOutputFileName() {
        return outputFileName;
    }
}
