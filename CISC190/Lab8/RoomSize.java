/**
 * Class for representing a room with dimensions and name.
 *
 * @author Joshua Emralino, jemralino@student.sdccd.edu
 * @version v1.0
 * @since 5/4/2025 - (v1.0 Joshua Emralino)
 */
public class RoomSize {

  private String name;
  private double length;
  private double width;

  /**
   * Constructor for RoomSize with name, width, and length params.
   *
   * @param inName name of room
   * @param inLen length of room
   * @param inWidth width of room
   */
  public RoomSize(String inName, double inLen, double inWidth) {
    name = inName;
    length = inLen;
    width = inWidth;
  }

  /**
   * Copy constructor for RoomSize objects.
   *
   * @param object2 the RoomSize object to copy
   */
  public RoomSize(RoomSize object2) {
    name = object2.name;
    length = object2.length;
    width = object2.width;
  }

  /**
   * Returns area of the room (widht * length).
   *
   * @return area of room
   */
  public double getArea() {
    return width * length;
  }

  /**
   * Method for representing RoomSize objects as String Objects.
   *
   * @return String representation of RoomSize object
   */
  public String toString() {
    return String.format(
        "Room Name: %s\nLength: %.1f\nWidth: %.1f\nArea: %.2f",
        name, length, width, (width * length));
  }
}
