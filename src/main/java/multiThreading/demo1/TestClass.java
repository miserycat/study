package multiThreading.demo1;

/**
 * Created by shengchao wu on 4/3/2018.
 */
public class TestClass {

    protected void test() {
        System.out.println("test");
    }

    class subClass extends TestClass {
        public void test() {
            super.test();
        }
    }
}
