package thread01.com.atguigu.java;

/*
 * 线程的优先级 （1-10）：默认优先级为 5.
 * 		注意：优先级高并不意味着线程一定会先执行，只不过更多的获取cpu的资源
 * 
 * MAX_PRIORITY : 10
 * NORM_PRIORITY : 5
 * MIN_PRIORITY : 1
 * 
 * getPriority() : 获取线程的优先级
 * setPriority() : 设置线程的优先级
 */
public class TestThread6 {
	
	public static void main(String[] args) {
		HelloThread3 ht3 = new HelloThread3();
		Thread t1 = new Thread(ht3);
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		for (int i = 100; i < 200; i++) {
			System.out.println(Thread.currentThread().getName() + " 优先级：" + Thread.currentThread().getPriority() + " ***" + i);
		}
	}

}
