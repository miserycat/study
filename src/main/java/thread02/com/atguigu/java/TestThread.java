package thread02.com.atguigu.java;

/*
 * 模拟三个售票窗口，同时售票100张
 * 
 * 问题：当三个窗口同时访问共享数据100张车票时，发生无序、重复、超额售票等多线程安全问题
 * 解决：将需要访问的共享数据包装起来，确保一次只有一个线程执行流访问该共享数据
 * 
 * 
 * 1. 同步代码块
 * 
 * 	synchronized(同步监视器){
 * 		//需要访问的共享数据
 *  }
 *  
 *  同步监视器：俗称“锁”。可以使用任意对象充当。 但是需要确保多个线程持有同一把锁（同一个对象）
 * 
 * 2. 同步方法 : 在方法的声明处加 synchronized 关键字
 * 		public synchronized void show() ---- 隐式的锁  this
 * 
 * 3. 同步锁 : Lock 
 * 		注意： 必须保证手动的释放锁
 * 
 */
public class TestThread {
	
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		Thread win1 = new Thread(ticket, "1号窗口");
		Thread win2 = new Thread(ticket, "2号窗口");
		Thread win3 = new Thread(ticket, "3号窗口");
		
		win1.start();
		win2.start();
		win3.start();
	}

}
