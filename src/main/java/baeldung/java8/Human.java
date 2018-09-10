package baeldung.java8;

public class Human {
  private String name;
  private int age;

  public Human() {
  }

  public Human(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public static int compareByNameThenAge(Human lhs, Human rhs) {
    if (lhs.getName().equals(rhs.getName())) {
      return lhs.getAge() - rhs.getAge();
    }
    return lhs.getName().compareTo(lhs.getName());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
