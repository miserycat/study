package designPattern.Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class LanguageCollegeIterator implements Iterator<College> {
    private final List<Department> departments;
    private int index = 0;

    public LanguageCollegeIterator(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return index < departments.size();
    }

    @Override
    public College next() {
        return departments.get(index++);
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super College> action) {

    }
}
