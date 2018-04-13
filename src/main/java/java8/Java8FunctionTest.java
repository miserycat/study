package java8;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 embedded function
 * Consumer<T>: void accept(T);
 *
 * Supplier<T>: T get();
 *
 * Function<T, R>: R apply(T t);
 *
 * Predicate<T>: boolean test(T t);
 *
 * BiFunction<T, U, R> R apply(T t, U u);
 *
 * BinaryFunction<T> T apply(T t1, T t2);
 *
 */

public class Java8FunctionTest {
    @Test
    public void test1() {
        happy(10000, m -> System.out.println("spent " + m + "dollar to happy.."));
    }

    private void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }


    @Test
    public void test2() {
        generateNumberList(100, () -> 1 + new Random().nextInt(100 - 1) + 1).forEach(System.out::println);
    }

    private List<Integer> generateNumberList(int num, Supplier<Integer> sup) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            result.add(n);
        }
        return result;
    }

    @Test
    public void test3() {
        String trimmedStr = strHandler("\t\t this is a string \t\t", s -> s.trim());
        System.out.println(trimmedStr);

        String subStr = strHandler("abcdefg", s -> s.substring(2,5));
        System.out.println(subStr);
    }

    private String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }


    @Test
    public void test4() {
        List<String> list = Arrays.asList("soju", "moon", "remind", "shy");

        List<String> filterList = filterMappedStrings(list, s -> s.length() > 3);

        filterList.forEach(System.out::println);
    }

    private List<String> filterMappedStrings(List<String> list, Predicate<String> pre) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                result.add(s);
            }
        }
        return result;
    }

}


