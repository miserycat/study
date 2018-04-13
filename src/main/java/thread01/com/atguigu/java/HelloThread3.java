package thread01.com.atguigu.java;

public class HelloThread3 implements Runnable{

	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " 优先级：" + Thread.currentThread().getPriority() + "----" + i);
		}
		
	}

}
