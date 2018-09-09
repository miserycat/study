package java8.java8inAction;

public class Dish {
  private String name;
  private boolean onSale;
  private int price;
  private Dish.Type type;

  public Dish() {}

  public Dish(String name, boolean onSale, int price, Type type) {
    this.name = name;
    this.onSale = onSale;
    this.price = price;
    this.type = type;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isOnSale() {
    return onSale;
  }

  public void setOnSale(boolean onSale) {
    this.onSale = onSale;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  enum  Type {
    MEAT, FISH, OHTER
  }

  @Override
  public String toString() {
    return "Dish{" +
        "name='" + name + '\'' +
        ", onSale=" + onSale +
        ", price=" + price +
        ", type=" + type +
        '}';
  }
}
