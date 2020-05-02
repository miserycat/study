package designPattern.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LanguageCollege implements College{
    private final List<Department> departments;

    public LanguageCollege() {
        this.departments = new ArrayList<>();
        departments.add(new Department("English"));
        departments.add(new Department("French"));
        departments.add(new Department("Spanish"));
    }

    @Override
    public String getName() {
        return "language";
    }

    @Override
    public Iterator<College> createIterator() {
        return new LanguageCollegeIterator(departments);
    }
}
