package java8.java8inAction;

import com.google.common.collect.Lists;
import refactor.App;
import refactor.Apple;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorIntroduce {
    public static void main(String[] args) {
        List<Apple> list = Lists.newArrayList(
                new Apple("green", 100),
                new Apple("red", 200),
                new Apple("green", 130),
                new Apple("red", 110),
                new Apple("green", 90));


        //group by color
        Optional.ofNullable(groupByNormal(list)).ifPresent(System.out::println);
        System.out.println("==================================");
        Optional.ofNullable(groupByFunction(list)).ifPresent(System.out::println);
        System.out.println("==================================");
        Optional.ofNullable(groupByCollector(list)).ifPresent(System.out::println);
        System.out.println("==================================");


    }

    private static Map<String, List<Apple>> groupByNormal(final List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        for (Apple apple : apples) {
            List<Apple> colorApples = map.get(apple.getColor());
            if (map.get(apple.getColor()) == null) {
                colorApples = new ArrayList<>();
                map.put(apple.getColor(), colorApples);
            }
            colorApples.add(apple);
        }

        return map;
    }

    private static Map<String, List<Apple>> groupByFunction(final List<Apple> apples) {
        Map<String, List<Apple>> map = new HashMap<>();
        apples.stream()
                .forEach(apple -> {
                    List<Apple> colorApples = Optional.ofNullable(map.get(apple.getColor())).orElseGet(() -> {
                        List<Apple> list = new ArrayList<>();
                        map.put(apple.getColor(), list);
                        return list;
                    });

                    colorApples.add(apple);
                });

        return map;
    }

    private static Map<String, List<Apple>> groupByCollector(final List<Apple> apples) {
        return apples.stream().collect(Collectors.groupingBy(Apple::getColor));
    }
}
