package designPattern.Iterator;

import java.util.Iterator;
import java.util.function.Consumer;

public class ComputerCollegeIterator<T> implements Iterator<College> {
    private Department[] departments;
    private int index;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        return index < departments.length;

    }

    @Override
    public College next() {
        return departments[index++];
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super College> action) {

    }
}
