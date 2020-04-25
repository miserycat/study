package jvm.classloader;

/*
    ���ھ�̬�ֶ���˵��ֻ��ֱ�Ӷ����˸��ֶε���Żᱻ��ʼ��
    ��һ�����ʼ��ʱ��Ҫ���丸��ȫ�����Ѿ���ʼ�������
    -XX:+TraceClassLoading, ����׷����ļ�����Ϣ����ӡ����
    -XX:+<option>, ��ʾ����optionѡ��
    -XX:-<option>, ��ʾ�ر�optionѡ��
    -XX:<option>=<value>, ��ʾ��optionѡ���ֵ����Ϊvalue
 */


public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
    }
}

class MyParent1 {
    public static String str = "hello world";

    static {
        System.out.println("myParent1 static block");
    }
}

class MyChild1 extends MyParent1 {
    public static String str2 = "welcome";

    static {
        System.out.println("myChild1 static block");
    }
}
