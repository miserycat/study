package collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shengchao wu on 3/30/2018.
 */
public class TestSet {

    public static void main(String[] args) {
        Set<MyClass> set = new HashSet<>();
        MyClass c1 = new MyClass("b");
        MyClass c2 = new MyClass("a");
        MyClass c3 = new MyClass("b");
        set.add(c1);
        System.out.println(set.toString());
        set.add(c2);
        System.out.println(set.toString());
        set.add(c3);
        c2.setName("b");
        System.out.println(set.contains(c2));


        System.out.println(set.toString());
        set.remove(c3);
        System.out.println(set.contains(c3));
        System.out.println(set.toString());
        set.remove(c2);
        System.out.println(set.contains(c2));
        System.out.println(set.toString());
        set.remove(c1);
        System.out.println(set.contains(c1));
        System.out.println(set.toString());


    }
}
