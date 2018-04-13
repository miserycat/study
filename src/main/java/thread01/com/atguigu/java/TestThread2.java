package thread01.com.atguigu.java;

/*
 * 创建线程的方式二：
 * 		①创建一个类实现 Runnable 接口
 * 		②实现 run() 方法，同时编写线程执行体
 * 		③创建该实现类的实例
 * 		④创建 Thread 的实例，并将实现类的实例作为参数传递给Thread的构造器
 * 		⑤调用 Thread 类的 start() 方法启动线程，默认执行 run() 方法
 * 
 * 继承 Thread 类的方式与 实现 Runnable 接口方式的区别？
 * 	①当有多个线程需要访问共享数据时，首选使用实现的方式
 *  ②实现接口的方式解决了单继承的局限性
 */
public class TestThread2 {
	
	public static void main(String[] args) {
		PrimeRun pr = new PrimeRun();
		Thread t1 = new Thread(pr);
		t1.start();

		Thread t2 = new Thread(pr);
		t2.start();
		
		for (int i = 100; i < 200; i++) {
			if(i % 2 != 0){
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
	}

}
