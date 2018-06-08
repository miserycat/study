package java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

/**
 * Created by shengchao wu on 2/9/2018.
 */

public class LambdaTest {

    @Test
    public void test1() {
        Comparator<Integer> oldcom = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        Comparator<Integer> newcom = (x, y) -> x - y;
    }

    @Test
    public void test2() {
        List<Customer> customers = Arrays.asList(
                new Customer("jack", 30, 20000),
                new Customer("peter", 20, 10000),
                new Customer("luna", 36, 30000),
                new Customer("king", 50, 50000));

        //filter customers whose age lt 35;
        //way 1 strategy

        List<Customer> oldCustomers = filterByPredictor(customers, customer -> customer.getAge() > 35);

        oldCustomers.forEach(System.out::print);


    }

    @Test
    public void test3() {
        List<Customer> customers = Arrays.asList(
                new Customer("jack", 30, 20000),
                new Customer("peter", 20, 10000),
                new Customer("luna", 36, 30000),
                new Customer("king", 50, 50000));

        //filter customers whose age lt 35;
        //way 2 stream

        customers.stream()
                .filter((e) -> e.getAge() > 35)
                .forEach(System.out::println);
        System.out.println("========================================================");

        customers.stream()
                .filter(e -> e.getAge() > 35)
                .map(Customer::getName)
                .limit(1)
                .sorted()
                .forEach(System.out::println);

    }

    @Test
    public void test4() {
        String str = "\t\t\t\tabcdef";
        String trimed = strHandler("abcdef", (s) -> s.trim());
        System.out.println(trimed);
    }

    @Test
    public void test5() {
        String str = "revert this string";
        String revertStr = strHandler(str, (s) -> {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(s.length() - i - 1));
            }
            return sb.toString();
        });

        System.out.println(revertStr);
    }


    @Test
    public void test6() {
        Long l1 = 101L;
        Long l2 = 102L;
        Long sum = multiple(l1, l2, (x, y) -> x * y);
        System.out.println(sum);

    }


    @Test
    public void test7() {
//        Comparator<Integer> comparator  = (x , y) -> Integer.compare(x, y);
        Comparator<Integer> comparator  = Integer::compare;
        Comparator<Customer> comparator1 = (c1, c2) -> c1.getAge() - c2.getAge();

    }

    @Test
    public void test8() {
//        BiPredicate<String, String> biPredicate = (s1, s2) -> s1.equals(s2);
        BiPredicate<String, String> biPredicate = String::equals;

    }

    private String strHandler(String str, MyFun fun) {
        return fun.getValue(str);
    }

    private Long multiple(Long l1, Long l2, MyFunGe<Long, Long> myFunGe) {
        return myFunGe.getValue(l1, l2);
    }


    private List<Customer> filterByPredictor(List<Customer> customers, MyPredictor<Customer> predictor ) {
        List<Customer> filterCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (predictor.filter(customer)) {
                filterCustomers.add(customer);
            }
        }
        return filterCustomers;
    }

}
