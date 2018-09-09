package java8.java8inAction;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class StreamFilter {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 7, 7, 10);

    List<Integer> filterList = list.stream()
        .filter(i -> i % 2 == 0)
        .collect(toList());

    filterList.forEach(System.out::println);

    list.stream().skip(5)
        .collect(toList())
        .forEach(System.out::println);

    int findValue = findPredictValue(new Integer[]{1, 2, 3, 4, 10}, -1, (i -> i > 10));
    System.out.println(findValue);

    Optional<Integer> result = list.stream()
        .filter(i -> i > 10)
        .findAny();
    System.out.println(result.orElse(-1));

  }

  private static int findPredictValue (Integer[] values, int defaultValue, Predicate<Integer> predicate) {
    for (int i : values) {
      if (predicate.test(i)) {
        return i;
      }
    }
    return defaultValue;
  }

}
