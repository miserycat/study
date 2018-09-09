package bean;

/**
 * Created by shengchao wu on 7/12/2018.
 */
public class Women extends Person {

    static {
        System.out.println("this is Women static...");

    }

    {
        System.out.println("this women {  }");
    }

    public Women() {
        System.out.println("this women..");
    }


    public static void method() {
        System.out.println("this is Women static method...");
    }
}
