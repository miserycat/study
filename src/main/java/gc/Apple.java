package gc;

public class Apple implements Comparable<Apple>{

  public Apple(String name, String color) {
    this.name = name;
    this.color = color;
  }

  private String name;

  private String color;


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public int compareTo(Apple apple) {
    return this.getColor().compareTo(apple.getColor());
  }
}
