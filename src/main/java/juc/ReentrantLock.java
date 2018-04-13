package juc;

public class ReentrantLock {

    private volatile int lockNum;

    private volatile Thread threadOwner;

    private final Object o = new Object();

    public void lock(){
        Thread currentThread = Thread.currentThread();
        synchronized (o){
            if(threadOwner == null){
                threadOwner = currentThread;
            }else if(threadOwner != currentThread){
                while(lockNum != 0){
                    try {
//                        System.out.println("thread : " + currentThread.getName() + " is waiting");
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                System.out.println("thread : " + currentThread.getName() + " is working. lockNum = " + lockNum);
                threadOwner = currentThread;
            }
            lockNum ++;
//            System.out.println("lock() lockNum = " + lockNum);
        }
    }

    public void unlock(){
        if(lockNum == 0){
            return;
        }
        if(threadOwner == null){
            return;
        }
        synchronized (o){
            Thread currentThread = Thread.currentThread();
            if(currentThread == threadOwner){
                lockNum --;
//                System.out.println("unlock() lockNum = " + lockNum);
            }
            if(lockNum == 0){
                threadOwner = null;
//                System.out.println("thread : " + currentThread.getName() + " is done. lockNum = " + lockNum);
                o.notify();
            }
        }
    }
}