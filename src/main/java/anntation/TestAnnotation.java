package anntation;

/**
 * Created by shengchao wu on 7/9/2018.
 */
public class TestAnnotation {

    @Before
    public void setUp() {
        System.out.println("this is before method...");
    }


    @Test
    public void test1() {
        System.out.println("test1 invoked...");
    }

    @Test
    public void test2() {
        System.out.println("test2 invoked...");
    }

    public void test3() {
        System.out.println("test2 invoked...");
    }



    @After
    public void tearDown() {
        System.out.println("this is after method...");
    }

}
