package gc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test{

    public Person person = new Person();
    
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();

        Collections.sort(appleList);

        TestInterface.sayHello();
    }

}