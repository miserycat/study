package java8;

import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {

  public static void main(String[] args) {
    List<String> list = Lists.newArrayList("aa", "bb", "cc", "dd");

//    Stream<Stream<Character>> stream = list.stream()
//        .map(s -> {
//          List<Character> cList = Lists.newArrayList();
//          for (char c : s.toCharArray()) {
//            cList.add(c);
//          }
//          return cList.stream();
//        });
//    stream.forEach(characterStream -> characterStream.forEach(System.out::println));

//    Stream<Character> characterStream = list.stream()
//        .flatMap(s -> {
//          List<Character> cList = Lists.newArrayList();
//          for (char c : s.toCharArray()) {
//            cList.add(c);
//          }
//          return cList.stream();
//        });


    List<List<String>> list2 = Arrays.asList(
        Arrays.asList("a"),
        Arrays.asList("b"));

    List<String> result = Lists.newArrayList();
    list2.forEach(result::addAll);

    System.out.println(result);

//    List<String> flatResult = list2.stream()
//        .flatMap(Collection::stream)
//        .collect(Collectors.toList());
//
//    System.out.println(flatResult);


    List<String> flatResult = list2.stream()
        .flatMap(nestedList -> nestedList.stream())
        .collect(Collectors.toList());

    System.out.println(flatResult);
  }

}
