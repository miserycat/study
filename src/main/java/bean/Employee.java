package bean;

/**
 * Created by shengchao wu on 2/27/2018.
 */
public class Employee {

    public Employee() {}

    public Employee(int age) {
        this.age = age;
    }

    private String name;

    private int age;

    private double salary;

    private Status status;

    public Employee(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    public Employee(String name, int age, double salary, Status status) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee emp = (Employee) obj;

        return this.getName().equals(emp.getName());
    }
}
