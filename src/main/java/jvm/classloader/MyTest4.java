package jvm.classloader;

/*
    ��������ʵ����˵������������JVM�������ڼ䶯̬���ɵģ���ʾΪ[xxx.xxx.Xxx ������ʽ���丸����Object
     ���Ƿ���
        anewarray: ��ʾ����һ���������͵�(��Class, Interface, array)���飬������ѹ�뵽ջ����
        newarray: ��ʾ����һ��ָ����ԭ������(��int, float, char)�����飬������ѹ��ջ����
 */

public class MyTest4 {
    public static void main(String[] args) {
//        MyParent4 myParent4 = new MyParent4();
//        MyParent4 myParent5 = new MyParent4();

        MyParent4[] myParent4s = new MyParent4[1];
        System.out.println(myParent4s.getClass()); //[Ljvm.classloader.MyParent4

        MyParent4[][] myParent4s1 = new MyParent4[1][1];
        System.out.println(myParent4s1.getClass()); //[[Ljvm.classloader.MyParent4
        System.out.println(myParent4s.getClass().getSuperclass());
        System.out.println(myParent4s1.getClass().getSuperclass());

        System.out.println("=============");

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

        char[] chars = new char[1];
        System.out.println(chars.getClass());

        boolean[] booleans = new boolean[1];
        System.out.println(booleans.getClass());

        short[] shorts = new short[1];
        System.out.println(shorts.getClass());

        byte[] bytes = new byte[1];
        System.out.println(bytes.getClass());

    }
}

class MyParent4 {

    static {
        System.out.println("MyParent4 static block...");
    }

}
