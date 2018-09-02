package java8;

import com.google.common.base.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import refactor.Apple;

/**
 *  :: deduce method way
 *
 *
 * 1 static method
 *
 * 2 Class method
 *
 * 3 instance method
 *
 * 4 construct method
 */

public class MethodDeduce {

  public static void main(String[] args) {

    BiFunction<String, Integer, Character> f1 = String::charAt;

    System.out.println(f1.apply("hello", 2));


    String s = new String("hello");
    Function<Integer, Character> f2 = s::charAt;

    System.out.println(f2.apply(3));

    BiFunction<String, Long, Apple> appleBiFunction = Apple::new;

    Apple redApple = appleBiFunction.apply("red", 10l);


    ThreeFunction<String, Long, String, Apple> appleThreeFunction = Apple::new;

    Apple greenApple = appleThreeFunction.apply("green", 200l, "shanghai");

    System.out.println(greenApple);

    List<Apple> apples = Arrays
        .asList(new Apple("red", 99), new Apple("green", 80), new Apple("pink", 999));

    apples.sort((a1, a2) -> a1.getColor().compareTo(a2.getColor()));

    apples.sort(Comparator.comparing(Apple::getColor));

  }



}
