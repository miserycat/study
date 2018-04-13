package java8;
import bean.Employee;
import bean.Goddess;
import bean.Man;
import bean.NewMan;
import bean.Status;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by shengchao wu on 3/2/2018.
 */
public class OptionalTest {

    @Test
    public void test1() {
        Employee employee = new Employee();
        //java7
        if (employee != null) {
            System.out.println(employee);
        }
        //java8
        Optional<Employee> empOpt = Optional.of(employee);
        empOpt.ifPresent(System.out::println);
    }

    @Test
    public void test2() {
        Employee employee = new Employee("jack", 38, 20000, Status.ONLINE);

        Optional<Employee> employeeOpt = Optional.of(employee);

        getEmployee(employee);

        getEmployee(employeeOpt);
    }

    private Employee getEmployee(Employee employee) {
        if (employee != null) {
            return employee;
        } else {
            return new Employee();
        }
    }

    private Employee getEmployee(Optional<Employee> employeeOpt) {
        return employeeOpt.orElse(new Employee());
    }


    @Test
    public void test3() {
        //java7
        Employee employee = new Employee("jack", 38, 20000, Status.ONLINE);
        if (employee == null) {
            employee = fetchFromDatabase();
        } else {

        }

        //java8
        Optional<Employee> empOpt = Optional.of(employee);
        empOpt.orElseGet(OptionalTest::fetchFromDatabase);

    }

    private static Employee fetchFromDatabase() {
        return new Employee();
    }

    private String method(Employee employee) {
        if (employee == null) {
            return null;
        } else {
            if (employee.getStatus() != null) {
                return employee.getStatus().toString();
            }
            return null;
        }
    }

    private String method(Optional<Employee> empOpt) {
        return empOpt.orElseGet(() -> new Employee()).getName();
    }

    @Test
    public void test4() {
        Man man = new Man();
        String goddessName = getGoddessName(man);

        System.out.println(goddessName);

        NewMan newMan = new NewMan();

        goddessName = getGoddessName(Optional.ofNullable(newMan));

        System.out.println(goddessName);
    }

    private String getGoddessName(Man man) {
        if (man != null) {
            if (man.getGoddess() != null) {
                return man.getGoddess().getName();
            }
            return "goddess";
        }
        return "goddess";
    }

    private String getGoddessName(Optional<NewMan> newMan) {
        return newMan
                .orElse(new NewMan())
                .getGoddessOpt()
                .orElse(new Goddess("goddess"))
                .getName();

    }

}
