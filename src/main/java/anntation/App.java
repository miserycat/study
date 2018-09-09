package anntation;

import org.junit.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by shengchao wu on 7/9/2018.
 */
public class App {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestAnnotation testAnnotation = new TestAnnotation();
        Method beforeMethod = null;
        Method afterMethod = null;
        Method[] methods = testAnnotation.getClass().getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Before.class) != null) {
                beforeMethod = method;
            }
            if (method.getAnnotation(After.class) != null) {
                afterMethod = method;
            }
        }
        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                if (beforeMethod != null) {
                    beforeMethod.invoke(testAnnotation);
                }
                method.invoke(testAnnotation);
                if (afterMethod != null) {
                    afterMethod.invoke(testAnnotation);
                }
            }
        }

    }
}
