package jvm.classloader;

public class MyTest7 {
    public static void main(String[] args) throws Exception{
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazzC = Class.forName("jvm.classloader.C");
        System.out.println(clazzC.getClassLoader());

    }
}

class C {

}
