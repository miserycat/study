package wenjun.concurrent.chapter3;

//Thread构造方法的stackSize代表着该线程占用的stack大小，如果没有指定默认是0,0代表忽略该参数

public class CreateThread3 {
    private static int count = 0;

    public static void main(String[] args) {
        int index = 0;
        Thread thread = new Thread(null,() -> {
            try {
                add(index);
            } catch (Error error) {
                error.printStackTrace();
                System.out.println(count);
            }
        }, "", 1 << 24);

        thread.start();
    }


    public static void add(int i) {
        count++;
        add(++i);
    }
}
