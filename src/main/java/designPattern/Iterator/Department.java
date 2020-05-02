package designPattern.Iterator;

import java.util.Iterator;

public class Department implements College {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;

    }

    @Override
    public Iterator<College> createIterator() {
        return null;
    }
}
