package designPattern.Iterator;

import java.util.Iterator;

public interface College {
    public String getName();

    Iterator<College> createIterator();
}
