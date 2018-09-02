package multiThreading.future;

public class Product {

  private int id ;

  private String name;

  public Product(int id, String name) {
    System.out.println("start to produce " + name);
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    this.id = id;
    this.name = name;

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
