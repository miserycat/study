package java8;

import bean.Employee;
import bean.Status;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void test1() {

        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        Employee[] employees = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(employees);

        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //create infinite stream
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);

        stream4.limit(10).forEach(System.out::println);

        Stream.generate(() -> new Random().nextInt(100))
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("jack", "jane", "peter", "moon", "joel");

        list.stream().map((s) -> s.substring(0,1)).forEach(System.out::println);

        Stream<Stream<Character>> stream = list.stream().map(StreamTest::filterChar);

        stream.forEach(s -> s.forEach(System.out::println)); //{{a,a,a}, {b,b,b}}

        //flatMap
        list.stream().flatMap(StreamTest::filterChar).forEach(System.out::println); //{a,a,a,b,b,b}


    }


    private static Stream<Character> filterChar(String str) {
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }


    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(3,42,21,10,199,99,54);
        Integer integer = list.stream().max((x, y) -> Integer.compare(x, y)).orElse(0);

        System.out.println(integer);
    }


    @Test
    public void test4() {
        List<Employee> list = Arrays.asList(new Employee("one", 10 , 1000),
                new Employee("two", 20 , 2000),
                new Employee("three", 30 , 3000),
                new Employee("four", 40 , 4000));

        Optional<Double> reduce = list.stream().map(Employee::getSalary)
                .reduce(Double::sum);
//                .reduce((x, y) -> x + y);
        System.out.println(reduce.orElse(0d));


        double[] array  = {1,2,3,4,5,6,7,8,9,10};
        double reduce1 = Arrays.stream(array).map(x -> x).reduce(0, ((x, y) -> x + y));

        System.out.println(reduce1);

    }

    @Test
    public void test5() {
        List<Employee> list = Arrays.asList(new Employee("one", 10 , 1000),
                new Employee("two", 20 , 2000),
                new Employee("three", 30 , 3000),
                new Employee("four", 40 , 4000));
        List<String> nameList = list.stream().map(Employee::getName)
                .collect(Collectors.toList());

        nameList.forEach(System.out::println);

        HashSet<String> nameSet = list.stream().map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        nameSet.forEach(System.out::println);

        Long collect = list.stream().collect(Collectors.counting());

        DoubleSummaryStatistics sum = list.stream().collect(Collectors.summarizingDouble(Employee::getSalary));

        System.out.println(sum.getMax());
        System.out.println(sum.getMin());
        System.out.println(sum.getSum());
        System.out.println(sum.getAverage());


        //min salary
        Optional<Double> min = list.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));

        //max salary employee
        Optional<Employee> collect1 = list.stream().collect(Collectors.maxBy((x, y) -> Double.compare(x.getSalary(), y.getSalary())));

    }

    @Test
    public void test6() {
        List<Employee> list = Arrays.asList(
                new Employee("Elizabeth", 28, 5000, Status.ONLINE),
                new Employee("Darcy", 30, 100000, Status.ONLINE),
                new Employee("Lydia", 15, 1000, Status.AWAY),
                new Employee("Boss", 28, 1000, Status.DO_NOT_DISTURB),
                new Employee("Manager", 28, 1000, Status.ON_MEETING),
                new Employee("King", 50, 50000, Status.AWAY)
        );

        Map<Status, List<Employee>> groupList = list.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));

        groupList.forEach(((status, employees) -> employees.forEach(System.out::println)));

        Map<Status, Map<Integer, List<Employee>>> groupMultiple =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(Employee::getAge)));

        System.out.println(groupMultiple);

    }

    @Test
    public void test7() {
        List<Employee> list = Arrays.asList(
                new Employee("Elizabeth", 28, 5000, Status.ONLINE),
                new Employee("Darcy", 30, 100000, Status.ONLINE),
                new Employee("Lydia", 15, 1000, Status.AWAY),
                new Employee("Boss", 28, 1000, Status.DO_NOT_DISTURB),
                new Employee("Manager", 28, 1000, Status.ON_MEETING),
                new Employee("King", 50, 50000, Status.AWAY)
        );

        Map<Boolean, List<Employee>> collect = list.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));

        System.out.println(collect);
    }

    @Test
    public void test8() {
        List<Employee> list = Arrays.asList(
                new Employee("Elizabeth", 28, 5000, Status.ONLINE),
                new Employee("Darcy", 30, 100000, Status.ONLINE),
                new Employee("Lydia", 15, 1000, Status.AWAY),
                new Employee("Boss", 28, 1000, Status.DO_NOT_DISTURB),
                new Employee("Manager", 28, 1000, Status.ON_MEETING),
                new Employee("King", 50, 50000, Status.AWAY)
        );

        String collect = list.stream().map(Employee::getName)
                .collect(Collectors.joining(",", "===", "==="));

        System.out.println(collect);

        Optional<Integer> reduce = list.stream().distinct().map(e -> 1)
                .reduce(Integer::sum);

    }
}
