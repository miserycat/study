package thread01.com.atguigu.java;

public class HelloThread2 implements Runnable{

	@Override
	public void run() {

//		try {
//			Thread.sleep(100000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();   //通常不做处理，用于唤醒睡眠状态的线程
//		}
//
		for (int i = 0; i < 100; i++) {
			
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
		
	}

}
