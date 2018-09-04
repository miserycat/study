package baeldung.classNotFoundVSNoClassDef;

/**
 * Created by shengchao wu on 7/19/2018.
 */
public class NoClassDefFoundErrorExample {

    public ClassWithInitErrors getClassWithInitErrors() {
        ClassWithInitErrors test;
        try {
            test = new ClassWithInitErrors();
        } catch (Throwable t) {
            System.out.println(t);
        }
        test = new ClassWithInitErrors();
        return test;
    }
}
