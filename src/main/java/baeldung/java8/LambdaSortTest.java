package baeldung.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaSortTest {

  public static void main(String[] args) {
    List<Human> humans = new ArrayList<>();
    humans.add(new Human("Sarah", 10));
    humans.add(new Human("Jack", 12));
    humans.add(new Human("Jack", 10));

//    humans.sort(Comparator.comparing(Human::getName).reversed());

//    humans.sort(Human::compareByNameThenAge);

    humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
    humans.forEach(System.out::println);


  }
}
