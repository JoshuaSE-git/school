import javax.swing.JOptionPane;
/**
 * GUI program to calculate average grade of three grades
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 2/18/25 - (v1.0 Joshua Emralino)
 */
public class ProgChall4 {

    public static void main(String[] args) {

        int gradeOne, gradeTwo, gradeThree;

        double finalGrade;
        char letterGrade;

        gradeOne = Integer.parseInt(JOptionPane.showInputDialog("Enter first grade"));
        gradeTwo = Integer.parseInt(JOptionPane.showInputDialog("Enter second grade"));
        gradeThree = Integer.parseInt(JOptionPane.showInputDialog("Enter third grade"));

        finalGrade = (double) (gradeOne + gradeTwo + gradeThree) / 3;

        if (finalGrade >= 90) {
            letterGrade = 'A';
        } else if (finalGrade >= 80) {
            letterGrade = 'B';
        } else if (finalGrade >= 70) {
            letterGrade = 'C';
        } else if (finalGrade >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }

        JOptionPane.showMessageDialog(null,
            "With an average score of " + String.format("%,.1f", finalGrade) + "\n"
            + "Your grade is: " + letterGrade);

        System.exit(0);
    }
}

