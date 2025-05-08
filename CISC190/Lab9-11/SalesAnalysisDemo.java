import java.io.*;
import java.util.Scanner;

/**
 * Application for tesing SalesAnalysis class
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/8/2025 - (v1.0 Joshua Emralino)
 */
public class SalesAnalysisDemo {

  public static void main(String[] args) throws IOException {
    Scanner keyScanner = new Scanner(System.in);

    String filePath;
    File file;
    SalesAnalysis salesAnalyzer;
    boolean validFile;

    do {
      System.out.print("Enter the path to the SalesData.txt file: ");
      filePath = keyScanner.nextLine().trim();
      file = new File(filePath);
      validFile = file.exists();
      if (!validFile) {
        System.out.println("File could not be found.");
      }
      System.out.println();
    } while (!validFile);

    salesAnalyzer = new SalesAnalysis(filePath);
    salesAnalyzer.processFile();
    salesAnalyzer.writeOutput();
  }
}
