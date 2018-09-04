package bean;

/**
 * Created by shengchao wu on 7/12/2018.
 */
public class Person {

    private String name;

    static {
        System.out.println("this is Person static...");
    }

    {
        System.out.println("this person {   }  ");
    }

    public Person() {
        System.out.println("xxxx");
    }

    public Person(String name) {
        this.name = name;
    }

}
