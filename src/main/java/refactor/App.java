package refactor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class App {

  public static void main(String[] args) {
    List<Apple> appleList = new ArrayList<>();
    appleList.add(new Apple("red", 10));
    appleList.add(new Apple("green", 20));
    appleList.add(new Apple("yellow", 30));
    appleList.add(new Apple("red", 20));

    filterObject(appleList, apple -> apple.getColor().equals("red")).forEach(System.out::println);

  }

  private static<T> List<T> filterObject(List<T> list, Predicate<T> filter) {
    List<T> result = new ArrayList<>();
    list.forEach(t -> {
      if (filter.test(t)) {
        result.add(t);
      }
    });
    return result;
  }

}
