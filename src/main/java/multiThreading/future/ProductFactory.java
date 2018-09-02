package multiThreading.future;

public class ProductFactory {

  public static Future createProduct(String name) {
    Future future = new Future();
    System.out.println("submit order product name: " + name);
    new Thread(() -> {
      Product product = new Product((int)Math.random() *100,"cookie");
      future.setProduct(product);
      System.out.println(name +" finish...");
    }).start();
    return future;
  }

}
