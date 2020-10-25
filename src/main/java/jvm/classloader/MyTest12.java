package jvm.classloader;

/**
 * ����ClassLoader.loadClass("xxx")�����Ƕ��������ʹ�ã����ᵼ����ĳ�ʼ����
 */

public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("jvm.classloader.CL"); //�����ᵼ��CL�ĳ�ʼ��
        System.out.println(clazz);
        System.out.println("============");
        clazz = Class.forName("jvm.classloader.CL");
        System.out.println(clazz);
    }
}

class CL {
    static {
        System.out.println("Class CL");
    }
}
