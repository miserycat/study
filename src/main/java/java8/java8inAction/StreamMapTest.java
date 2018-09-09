package java8.java8inAction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java8.java8inAction.Dish;
import java8.java8inAction.Dish.Type;

public class StreamMapTest {

  public static void main(String[] args) {
    listDish().stream()
        .map(Dish::getName)
        .forEach(System.out::println);

    //flatMap

    String[] words = {"Hello", "World"};

    Stream<String[]> stream = Arrays.stream(words)
        .map(s -> s.split("")); // {"H", "e", "l", "l", "o"}, {"W", "0", "r", "l", "d"}

    Stream<String> flatStream = stream.flatMap(Arrays::stream); // "H", "e", "l", "l", "o", "W", "0", "r", "l", "d"



  }

  private static List<Dish> listDish() {
    return Arrays.asList(
        new Dish("pock", false, 800, Type.MEAT),
        new Dish("beef", false, 700, Type.MEAT),
        new Dish("chicken", false, 400, Type.MEAT),
        new Dish("french fries", true, 530, Type.OHTER),
        new Dish("rice", true, 350, Type.OHTER),
        new Dish("season fruit", true, 120, Type.OHTER),
        new Dish("pizza", true, 800, Type.FISH),
        new Dish("prawns", false, 800, Type.FISH),
        new Dish("salmon", false, 800, Type.FISH));
  }


}
