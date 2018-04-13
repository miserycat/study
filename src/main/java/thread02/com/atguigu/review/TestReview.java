package thread02.com.atguigu.review;

public class TestReview {
	
	public static void main(String[] args) {
		
		HelloThread2 ht2 = new HelloThread2();
		Thread t2 = new Thread(ht2, "线程2");
		t2.start();
		
		
		for (int i = 100; i < 200; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
		
	}

}
