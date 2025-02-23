import javax.swing.JOptionPane;
/**
 * Program that calculates stock purchasing costs using a GUI.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 2/13/25 - (v1.0 Joshua Emralino)
 */
public class ProgChall15 {

    public static void main (String[] args) {

        final double COMMISION = 0.02;

        int stockShares;
        double pricePerShare, totalAmount, totalCost, commisionCost;

        pricePerShare = Double.parseDouble(JOptionPane.showInputDialog("Enter price per share."));
        stockShares = Integer.parseInt(JOptionPane.showInputDialog("Enter number of shares."));

        totalAmount = stockShares * pricePerShare;
        commisionCost = totalAmount * COMMISION;
        totalCost = totalAmount + commisionCost;

        JOptionPane.showMessageDialog(null, "Total cost of shares are: " + 
            String.format("$%,.2f\n", totalAmount) +
            "Commision cost is: " + String.format("$%,.2f\n", commisionCost) +
            "Total cost is: " + String.format("$%,.2f", totalCost));

        System.exit(0);
    }
}

