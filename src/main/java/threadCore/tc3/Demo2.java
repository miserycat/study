package threadCore.tc3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {
	
	private Lock lock = new ReentrantLock();
	
	public void a() {
		lock.lock();
		System.out.println("...");
		lock.unlock(); // 1 ½âËø
	}
	
	public void b() {
		lock.lock(); // 2  ¼ÓËø
		System.out.println("...");
		lock.unlock();
	}

}
