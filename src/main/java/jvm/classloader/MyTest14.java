package jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MyTest14 {
    public static void main(String[] args) throws IOException {
        String[] strings = new String[2];
        //the classloader of reference object array are the reference object
        System.out.println(strings.getClass().getClassLoader()); //bootstrap classloader
        System.out.println("==================");

        MyTest14[] myTest14s = new MyTest14[2];
        System.out.println(myTest14s.getClass().getClassLoader());
        System.out.println("==================");


        //primitive type has no classloader
        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());

    }
}
