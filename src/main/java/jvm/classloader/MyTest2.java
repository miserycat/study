package jvm.classloader;

/*
    �ڱ���׶γ����ᱻ���뵽���øó����ķ�����������ĳ������С�
    �����ϣ������ಢû��ֱ�����õ����峣�����࣬��˲��ᴥ�����峣����ĳ�ʼ����
    ע�⣺����ָ���ǽ�������ŵ���MyTest2�ĳ������У�֮��MyTest2��MyParent2��û���κι�ϵ��
    ���������ǿ��Խ�MyParent2��class�ļ�ɾ����
    javap -c Mytest.class

    //���Ƿ���
      ldc��ʾ��int,float����String���͵ĳ���ֵ�ӳ����������͵�ջ��
      bipush��ʾ�����ֽڣ�-128 ~ 127���ĳ���ֵ
      sipush��ʾ��һ�������γ���ֵ (-32768 ~ 32767)������ջ��
      iconst_x(-1<=x<=5)��ʾ��int����x������ջ��

 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.str);
    }
}

class MyParent2 {
    public static final String str = "hello world";

    public static final short s = 127;

    public static final int i = 128;

    public static final int m = 1;

    static {
        System.out.println("myParent2 static block...");
    }
}

