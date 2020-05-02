package designPattern.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
        List<College> colleges = new ArrayList<>();
        colleges.add(new ComputeCollege());
        colleges.add(new LanguageCollege());
        colleges.forEach(college -> {
            final Iterator<College> iterator = college.createIterator();
            while (iterator.hasNext()) {
                final College concreteCollege = iterator.next();
                System.out.println(concreteCollege.getName());

            }
        });
    }
}
