package multiThreading.demo2;

import multiThreading.demo1.TestClass;

/**
 * Created by shengchao wu on 4/3/2018.
 */
public class Demo {
    public static void main(String[] args) {
        new TestClass() {
            @Override
            protected void test() {
                super.test();
            }
        }.test();

    }
}
