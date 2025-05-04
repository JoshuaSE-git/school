/**
 * Represents the cost of carpeting a room.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/1/2025 - (v1.0 Joshua Emralino)
 */
public class CarpetCost {

  private RoomSize size;
  private double costPerSqFt;

  /**
   * Constructor for CarpetCost objects.
   *
   * @param area the room represented by a RoomSize object
   * @param cost the cost of carpeting per square foot
   */
  public CarpetCost(RoomSize area, double cost) {
    size = new RoomSize(area);
    costPerSqFt = cost;
  }

  /**
   * Calculates and returns the cost of carpeting the room.
   *
   * @return the cost of carpeting the room
   */
  public double getCost() {
    return costPerSqFt * size.getArea();
  }

  /**
   * Returns string representation of CarpetCost object.
   *
   * @return string representation of CarpetCost object
   */
  public String toString() {
    return String.format(
        "%s\nThe cost per sq ft is: $%,.2f\nThe total cost is: $%,.2f",
        size.toString(), costPerSqFt, this.getCost());
  }
}
