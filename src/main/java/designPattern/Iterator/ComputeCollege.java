package designPattern.Iterator;

import java.util.Iterator;

public class ComputeCollege implements College {
    private static final int MAX_SIZE = 3;
    private final Department[] departments;


    public ComputeCollege() {
        departments = new Department[MAX_SIZE];
        departments[0] = new Department("JAVA");
        departments[1] = new Department("C#");
        departments[2] = new Department("Python");
    }

    @Override
    public String getName() {
        return "computer";
    }

    @Override
    public Iterator<College> createIterator() {
        return new ComputerCollegeIterator<ComputeCollege>(departments);
    }
}
