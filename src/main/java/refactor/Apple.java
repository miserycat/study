package refactor;

public class Apple {

  public Apple(String color, long price) {
    this.color = color;
    this.price = price;
  }

  public Apple(String color, long price, String location) {
    this.color = color;
    this.price = price;
    this.location = location;
  }

  private String color;

  private long price;

  private String location;

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public String toString() {
    return "Apple{" +
        "color='" + color + '\'' +
        ", price=" + price +
        ", location='" + location + '\'' +
        '}';
  }
}
