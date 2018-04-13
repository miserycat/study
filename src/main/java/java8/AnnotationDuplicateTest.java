package java8;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by shengchao wu on 3/8/2018.
 */
public class AnnotationDuplicateTest {

    @Test
    public void test1() throws NoSuchMethodException {
        Class<AnnotationDuplicateTest> testClazz = AnnotationDuplicateTest.class;
        Method method = testClazz.getMethod("show");

        MyAnnotation[] annotations = method.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation annotation : annotations) {
            System.out.println(annotation.value());
        }


    }


    @MyAnnotation("hello")
    @MyAnnotation("world")
    public void show() {

    }
}
