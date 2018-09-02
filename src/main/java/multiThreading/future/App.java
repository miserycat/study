package multiThreading.future;

public class App {

  public static void main(String[] args) {
    Future future = ProductFactory.createProduct("cookie");

    System.out.println("go to work...");
    System.out.println("fetch cookie..." + future.get());


  }

}
