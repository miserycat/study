package thread02.com.atguigu.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable{
	
	private int tick = 100;
	
	Object obj = new Object();

	Lock lock = new ReentrantLock();

	@Override
	public void run() {
		while(true){
			
			try{
//				lock.lock();
				
				if(tick > 0){
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
					
					
					System.out.println(Thread.currentThread().getName() + "完成售票，余票：" + --tick);


				}
				
			}finally{
//				lock.unlock(); //释放锁
			}
			
			
//			show();
			
//			synchronized (obj) {
//			}
			
			
		}
		
	}
	
	public synchronized void show(){
		if(tick > 0){
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			
			
			System.out.println(Thread.currentThread().getName() + "完成售票，余票：" + --tick);
		}
	}

}
