package gc;

/**
 * Created by shengchao wu on 5/18/2018.
 */
public class InternTest {

    public static void main(String[] args) {
        String hello = "Hello";
        String lo = "lo";
        System.out.println(hello == "Hel" + "lo");
        System.out.println(hello == "Hel" + lo);
        System.out.println(hello == ("Hel" + lo).intern());
    }

}
