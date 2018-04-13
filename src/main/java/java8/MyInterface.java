package java8;

/**
 * Created by shengchao wu on 3/2/2018.
 */
public interface MyInterface {


    default String getName() {
        return "bar";
    }

    default Integer getAge() {
        return 20;
    }


    public static void method() {
        System.out.println("static method in interface");
    }
}
