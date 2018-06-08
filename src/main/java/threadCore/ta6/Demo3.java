package threadCore.ta6;

import java.util.concurrent.TimeUnit;

public class Demo3 {

private volatile int signal;
	
	public synchronized void set () {
		signal = 1;
		notifyAll(); // notify方法会随机叫醒一个处于wait状态的线程
		 // notifyAll叫醒所有的处于wait线程，争夺到时间片的线程只有一个
		System.out.println("叫醒线程叫醒之后休眠开始...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized int get () {
		System.out.println(Thread.currentThread().getName() + " 方法执行了...");
		if(signal != 1) {
			try {
				wait();
				System.out.println("叫醒之后");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " 方法执行完毕...");
		return signal;
	}
	
	public static void main(String[] args) {
		
		Demo3 d = new Demo3();
		Target1 t1 = new Target1(d);
		Target2 t2 = new Target2(d);
		
		new Thread(t2).start();
		new Thread(t2).start();
		new Thread(t2).start();
		new Thread(t2).start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(t1).start();
		
	}
}
