import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Processes grades from input file and writes statistics to output file.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 3/13/2025 - (v1.0 Joshua Emralino)
 */
public class Grade {

  public static void main(String[] args) throws IOException {
    String inFile, outFile;

    inFile = getInFile();
    outFile = getOutFile();
    processFile(inFile, outFile);
    System.exit(0);
  }

  /**
   * Performs calculations on input file and writes stats to output.
   *
   * @param inFile file name or path as a String
   * @param outFile file name or path as a String
   */
  public static void processFile(String inFile, String outFile) throws IOException {
    File gradeFile = new File(inFile);
    Scanner fileScanner = new Scanner(gradeFile);

    PrintWriter output = new PrintWriter(outFile);

    int gradeA, gradeB, gradeC, gradeD, gradeF;
    int total, count, min, max, num;
    double avg;
    int set = 0;

    while (fileScanner.hasNextLine()) {
      set++;
      gradeA = gradeB = gradeC = gradeD = gradeF = 0;
      total = count = 0;
      num = max = min = fileScanner.nextInt();

      while (num != -1) {
        total += num;
        count++;

        if (num < min) {
          min = num;
        }

        if (num > max) {
          max = num;
        }

        if (num >= 90) {
          gradeA++;
        } else if (num >= 80) {
          gradeB++;
        } else if (num >= 70) {
          gradeC++;
        } else if (num >= 60) {
          gradeD++;
        } else {
          gradeF++;
        }

        num = fileScanner.nextInt();
      }

      output.println("Set " + set + " of grades calculated");

      if (count == 0) {
        output.println("No grades to average\n");
      } else {
        avg = (double) total / count;

        output.println("Number of As: " + gradeA);
        output.println("Number of Bs: " + gradeB);
        output.println("Number of Cs: " + gradeC);
        output.println("Number of Ds: " + gradeD);
        output.println("Number of Fs: " + gradeF);
        output.println("The high score was: " + max);
        output.println("The low score was: " + min);
        output.printf("The avg score is: %.1f\n\n", avg);
      }
    }
    output.close();
    fileScanner.close();
  }

  /**
   * Prompts user for input file name/path and returns it as String.
   *
   * @return file name/path as String.
   */
  public static String getInFile() {
    File file;
    String filePath;

    filePath = JOptionPane.showInputDialog("Enter name of input file (ie input.txt)");
    file = new File(filePath);

    while (!file.exists()) {
      filePath = JOptionPane.showInputDialog("Enter name of input file (ie input.txt)");
    }

    return filePath;
  }

  public static String getOutFile() {
    return JOptionPane.showInputDialog("Enter name of output file (ie output.txt)");
  }
}
