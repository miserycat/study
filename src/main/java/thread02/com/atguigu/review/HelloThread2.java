package thread02.com.atguigu.review;

public class HelloThread2 implements Runnable{

	@Override
	public void run() {
		HelloThread ht = new HelloThread();
		Thread t1 = new Thread(ht, "线程1");
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
		}
		
		for (int i = 200; i < 300; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}
