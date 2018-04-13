package thread01.com.atguigu.java;

/*
 * 什么是程序：是为了完成某项特定任务，使用某种语言编写的一组指令的集合。
 * 什么是进程：一个正在进行的程序
 * 什么是线程：在一个进程中执行的一套功能流程，称为线程。
 * 			 在一个进程中执行的多套功能流程，称为多线程
 * 
 * 抢占式策略系统：系统会为每个执行的线程分配一个很小的时间段用于完成任务，当该时间段用完后，系统会剥夺其执行权
 * 			    让给其他线程用于执行任务。
 * 
 * JVM 是多线程
 * main方法称为主线程
 * 
 * 创建线程的方式一：
 * 		①创建一个类继承 Thread 类
 * 		②重写 Thread 类的 run() 方法，同时编写线程执行体
 * 		③创建该子类的实例，调用 start() 方法用于启动线程，默认执行 run() 方法
 * 
 * 注意：新建一个线程后，不能启动多次
 * 
 * 
 * 线程的常用方法：
 * 	currentThread() : 用于获取当前线程
 * 	getName() : 获取线程名称
 *  start() : 用于启动线程
 * 
 */
public class TestThread {
	
	public static void main(String[] args) {
		
		PrimeThread pt = new PrimeThread();
		pt.start();//
//		pt.run();
		
		PrimeThread pt2 = new PrimeThread();
		pt2.start();
		
		for (int i = 100; i < 200; i++) {
			if(i % 2 != 0){
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
		
	}

}
