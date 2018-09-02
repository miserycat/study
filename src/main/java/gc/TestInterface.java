package gc;

public interface TestInterface {

  default void defaultMethod() {
    System.out.println("this is a default method of a interface");
  }

  static void sayHello() {
    System.out.println("static method in a interface...");

  }

}
