package thread01.com.atguigu.java;

/*
 * 线程控制方法： 
 * sleep(long millis) : 是一个静态方法，用于使当前线程进入睡眠状态
 * 
 * join() / join(long millis) : 是一个实例方法，使当前线程进入阻塞状态。
 * 
 * interrupt() ： 用于唤醒阻塞状态的线程，唤醒的方式是使阻塞状态的线程抛出 InterruptedException
 * 
 * isAlive() : 判断当前线程是否处于存活状态
 * 
 * yield() : 线程让步
 */
public class TestThread5 {
	
	public static void main(String[] args) {
		HelloThread2 ht2 = new HelloThread2();
		Thread t1 = new Thread(ht2);
		t1.start();

//		while(t1.isAlive()){
//			t1.interrupt();
//		}
//		
		Thread t2 = new Thread(ht2);
		t2.start();

		try {
			t1.join(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (int i = 100; i < 200; i++) {
			t1.yield();
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}
