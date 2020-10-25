package wenjun.concurrent.chapter3;

//如果构造方法中没有传入ThreadGroup，Thread会默认获取父线程的ThreadGroup作为该线程的ThreadGroup,此时自线程和父线程会在同一个ThreadGroup中
public class CreateThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        System.out.println(t1.getThreadGroup().getName());
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName());
        System.out.println(threadGroup == t1.getThreadGroup());

        System.out.println(threadGroup.activeCount()); //3
        Thread[] list = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(list);

        //main
        //Monitor Ctrl-Break
        //Thread-0
        for (Thread thread : list) {
            System.out.println(thread.getName());
        }
    }
}
