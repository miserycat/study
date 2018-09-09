package baeldung.classNotFoundVSNoClassDef;
import org.junit.Test;
/**
 * Both ClassNotFoundException and NoClassDefFoundError occur when the JVM can not find a requested class on the classpath.
 * Although they look familiar, there are some core differences between these two.In this tutorial,
 * we¡¯ll discuss some of the reasons for their occurrences and their solutions.
 */


public class ClassNotFoundTest {


    /**
     *
     * @throws ClassNotFoundException
     */
    @Test(expected = ClassNotFoundException.class)
    public void givenNoDrivers_whenLoadDriverClass_thenClassNotFoundException() throws ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
    }

    @Test(expected = NoClassDefFoundError.class)
    public void givenInitErrorInClass_whenLoadClass_thenNoClassDefFoundError() {
        NoClassDefFoundErrorExample example = new NoClassDefFoundErrorExample();
        example.getClassWithInitErrors();
    }




}
