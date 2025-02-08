
/**
 * Write a description of class Imprecision here.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @since 1/31/2025 - (Joshua Emralino, v1.0)
 * @version v1.0
 */
public class Imprecision {
    
    public static void main(String[] args) {
        double x = 12345.6789e200, y, z;
        y = 1 / x;
        z = x * y;
        
        System.out.println("The value of x is: " + x);
        System.out.println("The value of y is: " + y);
        System.out.println("The value of z (x*y) is: " + z);
        System.out.println("The value of 1 - z is: " + (1 - z));
    }
}
