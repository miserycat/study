package java8;
import bean.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * lambada体中已经有方法已经实现了，则可以使用方法引用
 *
 * 对象::实例方法名
 *
 * 类::静态方法名
 *
 * 类::实例方法名
 *
 */
public class QuoteTest {

    @Test
    public void test1() {

        PrintStream ps = System.out;

        Consumer<String> consumer = s -> ps.print(s);

        consumer = ps::println;

        consumer = System.out::println;
    }


    //对象::实例方法名
    @Test
    public void test2() {
        Employee employee = new Employee();
        Supplier<String> sup = () -> employee.getName();
        sup = employee::getName;
    }


    //类::静态方法名
    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        comparator = Integer::compare;
    }

    @Test
    public void test4() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        bp = String::equals;
    }


    //构造器引用
    @Test
    public void test5() {
        Supplier<Employee> supplier = () -> new Employee();
        supplier = Employee::new;
    }

    @Test
    public void test6() {
        Function<Integer, Employee> function = x -> new Employee(x);
        function = Employee::new;
    }

    @Test
    public void test7() {
        BiFunction<Integer,String, Employee> function = (x , y) -> new Employee(x, y);
    }

    @Test
    public void test8() {
        Function<Integer, String[]> function = x -> new String[x];
        function = String[]::new;
    }


}
