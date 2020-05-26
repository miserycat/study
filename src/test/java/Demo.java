import com.google.common.base.Objects;
import org.junit.Test;
import org.apache.commons.lang.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    private volatile int var;
    int b;
    int c;

    @Test
    public void test1() {
        String input = "I love Java";

        String result1 = StringUtils.leftPad(input, 20, "*");
        String result2 = StringUtils.rightPad(input, 20, "*");
        String result3 = StringUtils.center(input, 20, "*");

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        int a = b = 0;


    }

    @Test
    public void test2() {
        Thread t1 = new Thread(() -> {
            b = 4;
            System.out.println(b);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            var = 3;
        });

        Thread t2 = new Thread(() -> {
            c = var;
            System.out.println(c);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c = b;
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        //0001
        //0010
        //0011 3
        int[] intArray = new int[]{1,1,1,1,1,1,1,2,1,1,1,1,1,1};
        int n = intArray[0];

        for (int i = 1; i < intArray.length; i++) {
            int x = n ^ intArray[i];
            if (x != 0) {
                System.out.println(intArray[i]);
                break;
            }

        }
    }

    @Test
    public void test4() {
        Person person = new Person();
        person.setName("cassie");

        Set<Person> set = new HashSet<>();
        set.add(person);
        System.out.println(set.contains(person));
        person.setName("sc");
        System.out.println(set.contains(person));


    }

    @Test
    public void test6() {
        Node node = new Node();
        Node prev = new Node();
        node.prev = prev;
        Node next = new Node();
        node.next = next;
        node.prev = prev.prev;
    }

    @Test
    public void test5() {
        int a = 10;
        int b = a;
        b = 20;
        System.out.println(a);
    }

    static class Node {
        public Node prev;
        public Node next;
    }

    static class Person  {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof Person)) return false;
//            Person person = (Person) o;
//            return Objects.equal(name, person.name);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hashCode(name);
//        }
    }
}
