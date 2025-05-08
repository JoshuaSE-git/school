import java.io.*;
import java.util.Scanner;

/**
 * Class for processing and reporting sales data.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/6/2025 - (v1.0 Joshua Emralino)
 */
public class SalesAnalysis {

  public static final int DAYS_OF_WEEK = 7;

  private String inputFile;
  private double[] weeklyNumber;
  private int lineNumber = 0;

  /**
   * Constructor for SalesAnalysis object with file path param.
   *
   * @param filepath file path of input file
   */
  public SalesAnalysis(String filepath) {
    inputFile = filepath;
    weeklyNumber = new double[4];
  }

  /** Processes weekly sales data and adds it to weeklyNumber field. */
  public void processFile() throws IOException {
    File file = new File(inputFile);
    Scanner fileScanner = new Scanner(file);

    while (fileScanner.hasNextLine()) {
      String[] dailySales = fileScanner.nextLine().split(",");
      setArrayElement(dailySales);
    }

    fileScanner.close();
  }

  /**
   * Helper for processFile; Performs calculations and updates weeklyNumber field.
   *
   * @param inArray the data to be processed
   */
  private void setArrayElement(String[] inArray) {
    double total = 0;
    for (String dailySale : inArray) {
      total += Double.parseDouble(dailySale);
    }
    weeklyNumber[lineNumber] = total;
    lineNumber++;
  }

  /** Generates report for sales data. */
  public void writeOutput() {
    double salesTotal = this.getTotalSales();
    int minWeek = getMinIndex() + 1;
    int maxWeek = getMaxIndex() + 1;
    for (int i = 0; i < weeklyNumber.length; i++) {
      double weeklyTotal = weeklyNumber[i];
      System.out.printf("Week %d Info\n", i + 1);
      System.out.printf("Total Sales: $%,.2f\n", weeklyTotal);
      System.out.printf("Avg Daily Sales for Week: $%,.2f\n", weeklyTotal / 7);
      System.out.println();
    }
    System.out.printf("Total Sales for all Weeks: $%,.2f\n", salesTotal);
    System.out.printf("Avg Weekly Sales: $%,.2f\n", salesTotal / 7);
    System.out.printf("Week %d had the highest amount of sales\n", maxWeek);
    System.out.printf("Week %d had the lowest amount of sales\n", minWeek);
  }

  /** Helper for writeOutput; Calculates and returns grand total sales. */
  private double getTotalSales() {
    double total = 0;
    for (double weeklySale : weeklyNumber) {
      total += weeklySale;
    }
    return total;
  }

  /** Helper for writeOutput; Returns index of lowest weekly sales. */
  private int getMinIndex() {
    int minIndex = 0;
    for (int i = 1; i < weeklyNumber.length; i++) {
      if (weeklyNumber[i] < weeklyNumber[minIndex]) {
        minIndex = i;
      }
    }
    return minIndex;
  }

  /** Helper for writeOutput; Returns index of highest weekly sales. */
  private int getMaxIndex() {
    int maxIndex = 0;
    for (int i = 1; i < weeklyNumber.length; i++) {
      if (weeklyNumber[i] > weeklyNumber[maxIndex]) {
        maxIndex = i;
      }
    }
    return maxIndex;
  }
}
