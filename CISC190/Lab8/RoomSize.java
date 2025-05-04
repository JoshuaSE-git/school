public class RoomSize {

  private String name;
  private double length;
  private double width;

  public RoomSize(String inName, double inLen, double inWidth) {
    name = inName;
    length = inLen;
    width = inWidth;
  }

  public RoomSize(RoomSize object2) {
    name = object2.name;
    length = object2.length;
    width = object2.width;
  }

  public double getArea() {
    return width * length;
  }

  public String toString() {
    return String.format(
        "Room Name: %s\nLength: %.1f\nWidth: %.1f\nArea: %.2f",
        name, length, width, (width * length));
  }
}
