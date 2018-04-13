package thread01.com.atguigu.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable{
	
	static int tick = 100;

	private Object object = new Object();

	private Lock lock = new ReentrantLock();
	@Override
	public void run() {
		while(true) {
			try{
				lock.lock();
				if (tick > 0){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + "完成售票，余票：" + --tick);
				}
			} finally {
				lock.unlock();
			}
		}

	}

	private synchronized void show() {
		if (tick > 0){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "完成售票，余票：" + --tick);
		}
	}
}
