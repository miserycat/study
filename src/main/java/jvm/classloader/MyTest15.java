package jvm.classloader;

public class MyTest15 {
    public static void main(String[] args) {
        //bootstrap classloader scan path
        System.out.println(System.getProperty("sun.boot.class.path"));
        //ext classloader scan path
        System.out.println(System.getProperty("java.ext.dirs"));
        //app classloader scan path
        System.out.println(System.getProperty("java.class.path"));
    }
}
