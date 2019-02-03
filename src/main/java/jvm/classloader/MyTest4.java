package jvm.classloader;

/*
    对于数组实例来说，其类型是由JVM在运行期间动态生成的，表示为[xxx.xxx.Xxx 这种形式，其父类是Object
     助记符：
        anewarray: 表示创建一个引用类型的(如Class, Interface, array)数组，并将其压入到栈顶。
        newarray: 表示创建一个指定的原生类型(如int, float, char)的数组，并将其压入栈顶。
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
